
package com.test;
import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * <p>nothing</P>
 * @author : hexp
 * @version v1.1.0
 * @ClassName SpringTestPage
 * @date: 2021/6/28 19:55
 */

public class SpringTestPage {
    //private static Logger logger = LoggerFactory.getLogger(SpringTestPage.class);
    public static void main(String args[]){
        String a="123";
        String b="123";
        String c=new String("345");
        String d=new String("345");
        System.out.println("a==b:"+(a==b));
        System.out.println("a.equals(b): "+a.equals(b));
        System.out.println("c==d: "+(c==d));
        System.out.println("c.equals(d): "+c.equals(d));

      //  Person person=new Person();
        String str="java.lang.String";
        Class clazz=null;

        try{
            clazz=Class.forName(str);
            System.out.println(clazz.getSuperclass());

        }catch (ClassNotFoundException e){
            System.out.println(e.toString());
        }



    }

}
