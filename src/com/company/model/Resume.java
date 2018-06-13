package com.company.model;

import java.io.Serializable;
import java.util.*;

public class Resume implements Serializable {
    private String uuid;
    private String fullName;
    private String location;
    private String homePage;
    private Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public final static Resume EMPTY;

    public Map<SectionType, Section> getSections() {
        return sections;
    }

    static {

        EMPTY = new Resume();
    }

    public Resume() {
    }


    public void addSection(SectionType type, Section section) {
        sections.put(type, section);
    }

    public String getContact(ContactType type) {
        return contacts.get(type);
    }

    public void addContact(ContactType type, String value) {
        contacts.put(type, value);
    }

    public String getUuid() {
        return uuid;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public void setContacts(Map<ContactType, String> contacts) {
        this.contacts = contacts;
    }

   // public void setSections(List<Section> sections) {
//        this.sections = sections;
//    }

    public String getFullName() {
        return fullName;
    }

    public String getLocation() {
        return location;
    }

    public String getHomePage() {
        return homePage;
    }

    public Map<ContactType, String> getContacts() {
        return contacts;
    }

    public Section getSections(SectionType type) {
        return sections.get(type);
    }

    public Resume(String fullName, String location) {
        this(UUID.randomUUID().toString(), fullName, location);
    }

    public Resume(String uuid, String fullName, String location) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.location = location;
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Resume other = (Resume) obj;
        return uuid.equals(other.uuid);
    }

//    @Override
//   public int compareTo(Resume o) {
//        return fullName.compareTo(o.fullName);
//    }
}
