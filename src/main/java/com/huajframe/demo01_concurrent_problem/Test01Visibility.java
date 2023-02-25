package com.huajframe.demo01_concurrent_problem;

/**
 * 可见性（Visibility）：是指一个线程对共享变量进行修改，另一个线程立即得到修改后的最新值
 * 可见性演示
 *      一个线程对共享变量的修改,另一个线程不能立即得到最新值
 */
public class Test01Visibility {
    private static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        //线程2修改后线程1并没有结束，程序一直在运行
        Thread t1 = new Thread(() -> {
            while (run){

            }
        });

        t1.start();

        Thread.sleep(1000);

        Thread t2 = new Thread(() -> {
            run = false;
            System.out.println("时间到，线程2设置为false");
        });
        t2.start();
    }
}
