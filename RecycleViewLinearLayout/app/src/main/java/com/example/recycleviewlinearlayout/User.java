package com.example.recycleviewlinearlayout;

public class User {
    private int resourceImage;
    private String name;
    private String Age;

    public User(int resourceImage, String name, String age) {
        this.resourceImage = resourceImage;
        this.name = name;
        Age = age;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }
}
