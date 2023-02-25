package com.huajframe.demo02_concurrent_problem;

/**
 * synchronized保证可见性操作
 *
 * 可见性（Visibility）：是指一个线程对共享变量进行修改，另一个线程立即得到修改后的最新值
 * 可见性演示
 *      一个线程对共享变量的修改,另一个线程不能立即得到最新值
 */
public class Test01Visibility {
    /**
     * 当写一个volatile变量时，JMM会把该线程本地内存中的变量强制刷新到主内存中去；
     *     这个写会操作会导致其他线程中的volatile变量缓存无效
     */
    // private static volatile boolean run = true;

    private static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        //线程2修改后线程1并没有结束，程序一直在运行
        Thread t1 = new Thread(() -> {
            while (run){
                synchronized (Test01Visibility.class){

                }
                // System.out.println(run);
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
