package com.test;
/*********************************************************************************
 *    Copyright (c) XXXXCompany
 *
 *    Package:     PACKAGE_NAME
 *    Filename:    Person
 *    Description:
 *    Copyright:   Copyright (c) 2001-2017
 *    Company:     YLZ Information Technology Co.,Ltd
 *    @author :     hexp
 *    @version :    1.0
 *    Create at:   2021/7/2  12:02
 *
 ********************************************************************************/
/**
 * Created by fangxd on 2021/7/2.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.test.Person;
/**
 * <p>nothing</P>
 * @author : hexp
 * @version v1.1.0
 * @ClassName Person
 * @date: 2021/7/2 12:02
 */
public class Person
{
    private static Logger logger = LoggerFactory.getLogger(Person.class);
    private int age;
    private String name;
    private int idcard;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIdcard() {
        return idcard;
    }
    public void setIdcard(int idcard) {
        this.idcard = idcard;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        if (age != person.age)
            return false;
        if (idcard != person.idcard)
            return false;
        return name.equals(person.name);
    }
    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + name.hashCode();
        result = 31 * result + idcard;
        return result;
    }
}
