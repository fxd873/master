/*********************************************************************************
 *    Copyright (c) XXXXCompany
 *
 *    Package:     com.test
 *    Filename:    LambdaTest
 *    Description:
 *    Copyright:   Copyright (c) 2001-2017
 *    Company:     YLZ Information Technology Co.,Ltd
 *    @author :     hexp
 *    @version :    1.0
 *    Create at:   2021/7/3  21:20
 *
 ********************************************************************************/
package com.test;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
/**
 * Created by fangxd on 2021/7/3.
 */
/**
 * <p>null</P>
 * @author : hexp
 * @version v1.1.0
 * @ClassName LambdaTest
 * @date: 2021/7/3 21:20
 */
public class LambdaTest {
    private static Logger logger = LoggerFactory.getLogger(LambdaTest.class);


    public static void main(String args[]){
        Comparator<Integer> comp=(x,y)-> {
            System.out.println("闭包");
            return Integer.compare(x,y);};
        comp.compare(5,6);


        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(123,456,789,445,667));
        list.forEach(o->{
            if(o%2==1)System.out.println("被选中的数：" + o);
             else System.out.println("被抛弃的数："+o);
        });

        list.forEach(System.out::println);

        Thread a=new Thread(()->{
            try {
                Thread.sleep(3000);

            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"：coming in !!!!");
            LockSupport.park();
            System.out.println("unpark唤醒线程："+Thread.currentThread().getName());
        },"a");
        a.start();

        Thread b=new Thread(()->{
            try {
                Thread.sleep(1000);

            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"coming in!!!!");
            LockSupport.park();
            System.out.println("unpark唤醒线程："+Thread.currentThread().getName());

        },"b");
        b.start();
        LockSupport.unpark(a);
        LockSupport.unpark(b);


        Runtime.getRuntime();

        System.out.println("JVM剩余空闲内存大小："+Runtime.getRuntime().freeMemory()/(1024*1024));
        System.out.println("JVM可以从服务器挖取的最大内存："+Runtime.getRuntime().maxMemory()/(1024*1024));
        System.out.println("JVM已经从服务器挖取的内存大小："+Runtime.getRuntime().totalMemory()/(1024*1024));
        System.out.println("服务器核心数："+Runtime.getRuntime().availableProcessors());


        Runtime.getRuntime().addShutdownHook(new Thread(()->{
          try{
              System.out.println("start ThreadHook1: "+Thread.currentThread().getName());

          }catch (Exception e){e.printStackTrace();}
            System.out.println("exit ThreadHook1: "+Thread.currentThread().getName());

        }));
        System.out.println("主线程退出："+Thread.currentThread().getName());


        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] allThreads = mxBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : allThreads) {
            System.out.println(threadInfo.getThreadId()+"==="+threadInfo.getThreadName());

        }

    }





}
