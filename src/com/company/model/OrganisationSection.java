package com.company.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrganisationSection extends Section {
    private List<Organization>values;

    public OrganisationSection(Organization ...values) {
        this.values = new LinkedList<>(Arrays.asList(values));
    }
}
