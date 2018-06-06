package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTread implements Runnable {
    @Override
    public void run() {
        while (true) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy  HH:mm:ss:SS");
            System.out.println(sdf.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
