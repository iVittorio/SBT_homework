package ru.sbt.hw.hw6;

/**
 * Created by i.viktor on 08/08/16.
 */
public class TestClass {
    private Integer age;
    private String name;
    private boolean sex;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public TestClass() {
    }

    public TestClass(Integer age, String name, boolean sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }


}
