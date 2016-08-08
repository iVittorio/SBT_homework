package ru.sbt.hw.hw6;

/**
 * Created by i.viktor on 08/08/16.
 */
public class TestClass {
    private int age;
    private String name;
    private boolean sex;

    public TestClass() {

    }

    public TestClass(int age, String name, boolean sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
