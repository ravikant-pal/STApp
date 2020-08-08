package com.alok.pages;

import com.alok.dto.EmployeeDetailsDTO;
import com.alok.services.Impl.EmployeeServiceImpl;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;


import java.util.List;
import java.util.stream.Collectors;

@Import(stylesheet = "context:css/popup.css",library = {"context:jquery/popup-image.js"})
public class AllEmployee {

    @Property
    private List<EmployeeDetailsDTO> employees;

    @Property
    private EmployeeDetailsDTO employee;

    @InjectComponent
    private Zone detailsZone;

    @Inject
    private EmployeeServiceImpl employeeServiceImpl;

    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;


    void onRefreshZone() {
        employees = employeeServiceImpl.getAll().stream().map(emp-> new EmployeeDetailsDTO(emp.getId(),emp.getFirstName(), emp.getLastName(), emp.getAge(), emp.getAddress(), emp.getEmail())).collect(Collectors.toList());
        ajaxResponseRenderer.addRender(detailsZone);
    }
}
