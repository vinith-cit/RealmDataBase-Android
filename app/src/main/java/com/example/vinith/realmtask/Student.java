package com.example.vinith.realmtask;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by sony on 20-Oct-16.
 */

public class Student extends RealmObject {

    @PrimaryKey
    private long id;

    private String name;

    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
