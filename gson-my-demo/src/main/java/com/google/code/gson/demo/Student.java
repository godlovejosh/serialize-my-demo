package com.google.code.gson.demo;

/**
 * @author wuxing
 */
public class Student {
    public String name;
    public int age;
    public String emailAddress;

    public Student(String name, int age, String emailAddress) {
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
