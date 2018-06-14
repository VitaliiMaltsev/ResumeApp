package com.company.model;

import java.util.Objects;

public class TextSection extends Section {
    static final long serialVersionUID =1L;
    //private String title;
    private String value;

    public TextSection() {
    }

    public TextSection(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final TextSection other = (TextSection) obj;
        return Objects.equals(this.value, other.value);
    }
}
