package com.example.recycleviewbasic;

public class Book {
    private int Imagae;
    private String name;

    public Book(int imagae, String name) {
        Imagae = imagae;
        this.name = name;
    }

    public int getImagae() {
        return Imagae;
    }

    public void setImagae(int imagae) {
        Imagae = imagae;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
