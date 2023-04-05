package com.example.recycleviewbasic;

import android.widget.TextView;

import java.util.List;

public class Category {
    private String nameCate;
    private List<Book> books;

    public Category(String nameCate, List<Book> books) {
        this.nameCate = nameCate;
        this.books = books;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
