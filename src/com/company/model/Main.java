package com.company.model;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args){
        Link l1 = new Link("I am the best", "java.com");
        Link l2 = new Link();
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now(ZoneId.of("America/Sao_Paulo")));
        for (int i = 0; i <100 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " " + Math.round(Math.random()*100));
            }).start();
        }
//            Path path = Paths.get("E:\\винда 25,02\\testing\\result.doc");
//        try {
//            Files.lines(path).forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Stream<String>ljh ;
//            Path path2 = Paths.get("E:\\винда 25,02\\testing\\testing.doc");
//        try {
//            Files.createFile(path2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            Files.copy(path,path2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
