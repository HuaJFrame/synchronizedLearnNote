package com.huajframe.demo05_cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo01 {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        Runnable run = () -> {
            for (int i = 0; i < 1000; i++) {
                atomicInteger.incrementAndGet();
            }
        };

        List<Thread> list = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Thread thread = new Thread(run);
            thread.start();
            list.add(thread);
        }

        for(Thread t : list){
            t.join();
        }
        System.out.println("number = " + atomicInteger.get());
    }
}
