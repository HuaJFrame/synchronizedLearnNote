package com.huajframe.demo03_concurrent_problem;

public class Demo01 {

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
    }

    public static void test01(){
        synchronized (MyThread.class){
            String name = Thread.currentThread().getName();
            System.out.println(name + "进入了同步代码快2");
        }
    }
}

class MyThread extends Thread{

    @Override
    public void run() {
        synchronized (MyThread.class){
            System.out.println(getName() + "进入了同步代码快1");

            // synchronized (MyThread.class){
            //     System.out.println(getName() + "进入了同步代码快2");
            // }
            Demo01.test01();
        }
    }
}
