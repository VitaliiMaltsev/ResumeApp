package com.company.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public class Section implements Serializable {
    protected SectionType type;

    public Section() {
    }

    @Override
    public String toString() {
        return "Section{" +
                "type=" + type +
                '}';
    }
}
