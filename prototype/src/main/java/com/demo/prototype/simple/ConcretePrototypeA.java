package com.demo.prototype.simple;

import java.util.List;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 9:52
 * @version: V1.0
 * @detail:
 **/
public class ConcretePrototypeA implements Prototype{
    private int age;
    private String name;
    private List hobbies;
    @Override
    public Prototype clone() {
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setAge(this.age);
        concretePrototypeA.setHobbies(this.hobbies);
        concretePrototypeA.setName(this.name);

        return concretePrototypeA;
    }

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

    public List getHobbies() {
        return hobbies;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }
}
