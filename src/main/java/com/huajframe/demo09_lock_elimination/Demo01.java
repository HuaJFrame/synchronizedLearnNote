package com.huajframe.demo09_lock_elimination;

public class Demo01 {
    public static void main(String[] args) {
        contactString("aa", "bb", "cc");
    }

    public static String contactString(String s1, String s2, String s3) {
        //将append方法中的synchronized抹掉
        return new StringBuffer().append(s1).append(s2).append(s3).toString();
    }
}
