package com.company.web;

import com.company.model.ContactType;
import com.company.model.Organization;
import com.company.model.Resume;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HtmlUtil {
    public static final String EMPTY_TD = "<img src ='img/s.gif'>";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");

    public static String getContact(Resume r, ContactType type) {
        String contact = r.getContact(type);
        return (contact == null) ? "&nbsp;" : type.toHtml(contact);
    }

    public static String format(LocalDate date){
        return date.equals(Organization.Period.NOW)?"Now": date.format(DATE_FORMATTER);
    }
}
