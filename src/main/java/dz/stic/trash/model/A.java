package dz.stic.trash.model;

import javax.persistence.Entity;

import lombok.Data;
@Data
public class A {
    int age;
    String name;

    public A(int age, String name) {
        this.age = age;
        this.name = name;
    }

}
