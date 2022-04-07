package com.mmunoz.demo;


import javax.persistence.*;

@Entity
@Table(name = "objectTable")
public class ObjectClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    public ObjectClass() {
    }

    public ObjectClass(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public ObjectClass(String name) {
        this.name = name;
    }

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
