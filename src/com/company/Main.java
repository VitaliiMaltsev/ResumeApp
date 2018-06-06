package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Link l1= new Link("I am the best", "java.com");
        Link l2 =l1;
        System.out.println(l1.equals(l2));
        Link l3 = new Link(l1);
        System.out.println(l3.equals(l1));
//        TimeTread timeTread = new TimeTread();
//        Thread thread = new Thread(timeTread);
        System.out.println(args[0] +l1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy  HH:mm:ss");
        System.out.println(sdf.format(new Date()));
//        thread.start();
    }
}
