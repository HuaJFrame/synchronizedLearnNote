package com.huajframe.demo10_lock_coarsing;

public class Demo01 {
    public static void main(String[] args) {
        // synchronized (Demo01.class) {
        //     System.out.println("aaa");
        // }

        StringBuffer sb = new StringBuffer();

        //将append方法中的synchronized抹掉，加在循环外
        // synchronized (Demo01.class){
            for (int i = 0; i < 100; i++) {
                sb.append("aa");
            }
        // }


        System.out.println(sb.toString());
    }
}
