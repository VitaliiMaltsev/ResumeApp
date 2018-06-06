package com.company;

public enum ContactType {
    PHONE("Тел. "),
    MOBILE("Мобильный тел. "),
    HOME_PHONE("Домашний тел. "),
    MAIL("e-mail: "),
    SKYPE("Skype: ");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
