package com.huajframe.demo02_concurrent_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * synchronized保证原子性操作
 *
 * 原子性（Atomicity）：在一次或多次操作中，要么所有的操作都执行并且不会受其他因素干扰而中
 * 断，要么所有的操作都不执行。
 */
public class Test02Atomicity {
    private static int number = 0;
    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable increment = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (obj){
                    number++;
                }
            }
        };

        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(increment);
            t.start();
            list.add(t);
        }

        for(Thread t : list){
            t.join();
        }

        System.out.println("number = " + number);
    }
}
