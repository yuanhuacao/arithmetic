package com.example.arithmetic.simple;

import java.util.Objects;

public class Pet {

    public Pet(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet(String type, String name) {
        this.type = type;
        this.name = name;
    }
}
