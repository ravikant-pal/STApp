package com.alok.components;


import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;


public class CompanyNameAndAddressComponent {

    @Parameter(required = true)
    @Property
    private String value;

}
