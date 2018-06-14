package com.company.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MultiTextSection extends Section {
    static final long serialVersionUID =1L;
    private List<String>values;

    public List<String> getValues() {
        return values;
    }

    public MultiTextSection(String... values) {
        this(new LinkedList<>(Arrays.asList(values)));
    }

    public MultiTextSection(List<String> values) {
        this.values = values;
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
        final MultiTextSection other = (MultiTextSection) obj;
        return Objects.equals(this.values, other.values);
    }
}
