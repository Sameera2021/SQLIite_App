package com.example.app;

public class Car {
    private int id;
    private String model;
    private String color;
    private double dpl;
    private String image;
    private String description;

    public Car(int id, String model, String color, double dpl, String image, String description) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.dpl = dpl;
        this.image = image;
        this.description = description;
    }

    public Car(String model, String color, double dpl, String image, String description) {
        this.model = model;
        this.color = color;
        this.dpl = dpl;
        this.image = image;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDpl(double dpl) {
        this.dpl = dpl;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getDpl() {
        return dpl;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
