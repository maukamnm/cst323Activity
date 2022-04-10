package com.munoz.munoz.model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="student")
public class Student {
    @Id
   // @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
