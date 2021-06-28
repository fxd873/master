/*********************************************************************************
 *    Copyright (c) 易联众信息技术股份有限公司
 *
 *    Package:     com.test
 *    Filename:    SpringTestPage
 *    Description:
 *    Copyright:   Copyright (c) 2001-2017
 *    Company:     YLZ Information Technology Co.,Ltd
 *    @author :     hexp
 *    @version :    1.0
 *    Create at:   2021/6/28  19:55
 *
 ********************************************************************************/
package com.test;/**"
 * Created by fangxd on 2021/6/28.
 */
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
    }

}
