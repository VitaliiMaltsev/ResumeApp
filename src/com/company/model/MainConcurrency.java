package com.company.model;

//import static sun.jvm.hotspot.runtime.PerfMemory.start;

import java.util.concurrent.atomic.AtomicInteger;


public class MainConcurrency {
    private static volatile int sum;
    private static final AtomicInteger ATOMIC_SUM = new AtomicInteger();
    private static int syncSum;


    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sum++;
                ATOMIC_SUM.incrementAndGet();
                synchronized (this) {

                    syncSum++;
                }
                }
            }).start();
//        try {
//            Thread.sleep(400);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Non-Atomic :" + sum);
        System.out.println("Atomic :" + ATOMIC_SUM);
        System.out.println("Synchronized :" + syncSum);
    }
}

