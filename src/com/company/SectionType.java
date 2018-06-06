package com.company;

public enum SectionType {
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




