/*********************************************************************************
 *    Copyright (c) XXXXCompany
 *
 *    Package:     com.test
 *    Filename:    SingletonModel
 *    Description:
 *    Copyright:   Copyright (c) 2001-2017
 *    Company:     YLZ Information Technology Co.,Ltd
 *    @author :     hexp
 *    @version :    1.0
 *    Create at:   2021/7/7  21:43
 *
 ********************************************************************************/
package com.test;/**
 * Created by fangxd on 2021/7/7.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.jca.GetInstance;

import java.io.StreamCorruptedException;

/**
 * <p></P>
 * @author : hexp
 * @version v1.1.0
 * @ClassName SingletonModel
 * @date: 2021/7/7 21:43
 */
/*破坏单例对象的方式：1.反射 2.序列化 3.clone */

public class SingletonModel {
    private static Logger logger = LoggerFactory.getLogger(SingletonModel.class);
    //懒汉模式
    private static volatile SingletonModel singleton;//加volatile为了避免指令重排序
    private static boolean light=true;//为了防止反射破坏单例对象
    private SingletonModel(){
        synchronized (SingletonModel.class){
            if(!light){
                throw new RuntimeException("禁止反射破坏单例对象！");

            }
            light=false;
        }

    }
    public static SingletonModel getSingletonInstance(){
        if (singleton==null) {//线程1已经进入方法，如果线程2又加入来访问该锁，初始已经被线程1完成的话，通过该校验可以避免等待，提高效率
            synchronized (SingletonModel.class){
                if(singleton==null){//双重检测，防止在锁的获取过程中其他线程已经实例化对象
                    singleton=new SingletonModel();
                    return singleton;
                }

            }
        }
        return singleton;
    }
    //防止序列化破坏单例模式
    public Object readResolve() throws StreamCorruptedException{
        return singleton;
    }
    //防止克隆破坏单例模式
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return singleton;
    }

}

//恶汉模式
class SingletonHungry{
    private static SingletonHungry singletonHungry=new SingletonHungry();
    private SingletonHungry(){

    }
    public static SingletonHungry getInstance(){
        return singletonHungry;
    }
}

//枚举类型实现单例模式
enum SingletonEnum{
    INSTANCE;

    private void doAnything(){

    }
}

//静态内部类实现单例模式
class SingletonInnerClass{
    private static class SingletonInner{
      private static final  SingletonInnerClass INSTANCE=new SingletonInnerClass();
    }
    private SingletonInnerClass(){

    }
    public static final SingletonInnerClass getInstance(){
       return SingletonInner.INSTANCE;
    }
}
