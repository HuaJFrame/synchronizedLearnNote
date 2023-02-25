package com.huajframe.demo01_concurrent_problem;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

/**
 * 有序性
 * 是指程序中代码的执行顺序，Java在编译时和运行时会对代码进行优化，会导致
 * 程序最终的执行顺序不一定就是我们编写代码时的顺序。
 *
 * 出现0的结果就是线程2执行顺序出现问题
 */
// @JCStressTest
// @Outcome(id = {"1", "4"}, expect = Expect.ACCEPTABLE, desc = "ok")
// @Outcome(id = "0", expect = Expect.ACCEPTABLE_INTERESTING, desc = "danger")
// @State
public class Test03Orderliness {
    int num = 0;
    boolean ready = false;

    //线程1
    // @Actor
    public void actor1(I_Result r){
        if(ready){
            r.r1 = num + num;
        }else{
            r.r1 = 1;
        }
    }

    //线程2
    // @Actor
    public void actor2(I_Result r){
        num = 2;
        ready = true;
    }
}
