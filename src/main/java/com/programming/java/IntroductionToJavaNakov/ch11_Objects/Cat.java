package com.programming.java.IntroductionToJavaNakov.ch11_Objects;

public class Cat {
    // Field name
    private String name;
    // Field color
    private String color;

    // Getter of property name
    public String getName() {
        return this.name;
    }

    // Setter of property name
    public void setName(String name) {
        this.name = name;
    }

    // Getter of property color
    public String getColor() {
        return this.color;
    }

    // Setter of property color
    public void setColor(String color) {
        this.color = color;
    }

    // Default constructor
    public Cat() {
        this.name = "Unnamed";
        this.color = "gray";
    }

    // Constructor with parameters
    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // Method sayMiau
    public void sayMiau() {
        System.out.printf("Cat %s said: Miauuuuuu!%n", name);
    }
}