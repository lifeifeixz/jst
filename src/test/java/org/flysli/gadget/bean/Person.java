package org.flysli.gadget.bean;

import javax.validation.constraints.NotNull;

public class Person {

    @NotNull(message = "姓名不可为空")
    private String name;
    private int age;

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
}
