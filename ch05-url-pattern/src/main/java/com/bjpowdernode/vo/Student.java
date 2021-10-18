package com.bjpowdernode.vo;

/**
 * @author gjd
 * @create 2021/10/11  19:16:43
 */
public class Student {

    //用对象封装请求参数
    //要求：属性名和请求参数名要保持一致
    private String name;
    private Integer age;

    public Student() {
        System.out.println("Student无参构造方法......");
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
