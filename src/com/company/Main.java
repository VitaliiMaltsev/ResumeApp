package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Link l1 = new Link("I am the best", "java.com");
        Link l2 = new Link();

        new Thread(new TimeTread()).start();
        Contact contact = new Contact(ContactType.SKYPE, "vitaly");
    }
}
