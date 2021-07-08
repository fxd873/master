/*********************************************************************************
 *    Copyright (c) XXXXCompany
 *
 *    Package:     com.test
 *    Filename:    deadLockTest
 *    Description:
 *    Copyright:   Copyright (c) 2001-2017
 *    Company:     YLZ Information Technology Co.,Ltd
 *    @author :     hexp
 *    @version :    1.0
 *    Create at:   2021/7/8  16:00
 *
 ********************************************************************************/
package com.test;/**
 * Created by fangxd on 2021/7/8.
 */
import org.slf4j.*;

/**
 * <p></P>
 * @author : hexp
 * @version v1.1.0
 * @ClassName deadLockTest
 * @date: 2021/7/8 16:00
 */
public class deadLockTest {
    private static Logger logger = LoggerFactory.getLogger(deadLockTest.class);

    public static void main(String args[]) {
        //死锁测试
        Object obj1 = new Object();
        Object obj2 = new Object();
        Thread thread1 = new Thread(() -> {
            try {
                while (true) {
                    synchronized (obj1) {
                        System.out.println("线程" + Thread.currentThread().getName() + ":获取到了obj1");
                        Thread.sleep(1000);
                        synchronized (obj2) {
                            System.out.println("线程" + Thread.currentThread().getName() + ":获取到了obj2");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A");
        Thread thread2 = new Thread(() -> {
            try {
                while (true) {
                    synchronized (obj2) {
                        System.out.println("线程" + Thread.currentThread().getName() + ":获取到了obj2");
                        Thread.sleep(1000);
                        synchronized (obj1) {
                            System.out.println("线程" + Thread.currentThread().getName() + ":获取到了obj1");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B");
        thread1.start();
        thread2.start();
    }
}
