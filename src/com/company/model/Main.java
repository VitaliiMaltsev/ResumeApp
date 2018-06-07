package com.company.model;

public class Main {

    public static void main(String[] args){
        Link l1 = new Link("I am the best", "java.com");
        Link l2 = new Link();

        new Thread(new TimeTread()).start();
        Contact contact = new Contact(ContactType.SKYPE, "vitaly");
    }
}
