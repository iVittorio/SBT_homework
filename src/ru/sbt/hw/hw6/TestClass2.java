package ru.sbt.hw.hw6;

/**
 * Created by i.viktor on 08/08/16.
 */
public class TestClass2 {
    private Number age;
    private String name;
    private boolean sex;

    public TestClass2(Number age, String name, boolean sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public TestClass2() {

    }

    public Number getAge() {
        return age;
    }

    public void setAge(Number age) {
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
