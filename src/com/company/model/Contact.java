package com.company.model;

public class Contact {
private final ContactType type;
private final String value;

    public ContactType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public Contact(ContactType type, String value) {

        this.type = type;
        this.value = value;
    }
}
