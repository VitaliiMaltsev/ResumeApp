package com.company.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrganisationSection extends Section {
    private List<Organization>values;

    public OrganisationSection(Organization ...values) {
        this.values = new LinkedList<>(Arrays.asList(values));
    }

    public OrganisationSection() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final OrganisationSection other = (OrganisationSection) obj;
        return Objects.equals(this.values, other.values);
    }

    @Override
    public String toString() {
        return "OrganisationSection{" +
                "values=" + values +
                ", type=" + type +
                '}';
    }

    public List<Organization> getValues() {
        return values;
    }
}
