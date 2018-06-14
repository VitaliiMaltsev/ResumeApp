package com.company.model;

import java.io.Serializable;

public enum SectionType implements Serializable {
    OBJECTIVE("Позиция"),
    ARCHIEVEMENT("Достижения"),
    EXPIRIENCE("Опыт работы"),
    QUALIFICATIONS("Квалификация"),
    EDUCATION("Образование");

    private String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}




