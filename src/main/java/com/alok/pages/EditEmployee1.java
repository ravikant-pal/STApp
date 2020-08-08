package com.alok.pages;

import com.alok.entities.Employee;
import com.alok.services.Impl.EmployeeServiceImpl;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Events;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

@Events({ EditEmployee1.CANCELED, EditEmployee1.UPDATED })
public class EditEmployee1 {
    public static final String CANCELED = "canceled";
    public static final String UPDATED = "updated";

    // Parameters

    @Parameter(required = true)
    @Property
    private Long personId;

    // Screen fields

    @Property
    private Employee employee;

    // Generally useful bits and pieces

    @Inject
    private EmployeeServiceImpl employeeServiceImpl;

    @InjectComponent
    private Form form;

    @InjectComponent
    private Zone formZone;

    @Inject
    private Request request;

    @Inject
    private ComponentResources componentResources;

    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;

    // The code

    boolean onCancel(Long personId) {
        this.personId = personId;

        componentResources.triggerEvent(CANCELED, new Object[] { personId }, null);
        // We don't want the event to bubble up, so we return true to say we've
        // handled it.
        return true;
    }

    void onPrepareForRender() {

        // If fresh start, make sure there's a Person object available.

        if (form.isValid()) {
            employee = employeeServiceImpl.getById(personId);
            // Handle null person in the template.
        }
    }

    void onPrepareForSubmit(Long personId) {
        this.personId = personId;

        // Get objects for the form fields to overlay.
        employee = employeeServiceImpl.getById(personId);

        if (employee == null) {
            form.recordError("Person has been deleted by another process.");
            // Instantiate an empty person to avoid NPE in the Form.
            employee = new Employee();
        }
    }

    boolean onValidateFromForm() {

        if (form.getHasErrors()) {
            return true;
        }

        try {
            employee = employeeServiceImpl.update(employee);
        }
        catch (Exception e) {
            // Display the cause. In a real system we would try harder to get a
            // user-friendly message.
            form.recordError(e.getMessage());
        }

        return true;
    }

    boolean onSuccess() {
        // We want to tell our containing page explicitly what person we've updated, so we trigger a new event with a
        // parameter. It will bubble up because we don't have a handler method for it.
        componentResources.triggerEvent(UPDATED, new Object[] { employee }, null);

        // We don't want the original event to bubble up, so we return true to
        // say we've handled it.
        return true;
    }

    boolean onFailure() {

        if (request.isXHR()) {
            ajaxResponseRenderer.addRender(formZone);
        }

        // We don't want the event to bubble up, so we return true to say we've
        // handled it.
        return true;
    }
}
