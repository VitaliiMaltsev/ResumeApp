package com.company.model;

import com.company.web.SectionHtmlType;

import java.io.Serializable;

public enum SectionType implements Serializable {
    OBJECTIVE("Позиция", SectionHtmlType.TEXT),
    ARCHIEVEMENT("Достижения",  SectionHtmlType.MULTI_TEXT),
    QUALIFICATIONS("Квалификация", SectionHtmlType.MULTI_TEXT),
    EXPIRIENCE("Опыт работы", SectionHtmlType.ORGANIZATION),
    EDUCATION("Образование",SectionHtmlType.ORGANIZATION);

    private String title;
    private SectionHtmlType htmlType;

    SectionType(String title, SectionHtmlType htmlType) {
        this.title = title;
        this.htmlType = htmlType;
    }

    public SectionHtmlType getHtmlType() {
        return htmlType;
    }

    public String getTitle() {
        return title;
    }
}




