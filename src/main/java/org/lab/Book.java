package org.lab;

public class Book extends Item {
    public String author;


    public Book(String uuid, String title, String author) {
        super(uuid, title);
        this.author = author;
    }

    @Override
    public void borrowItem() {
        this.isBorrowed = true;
    }
    @Override
    public void returnItem() {
        this.isBorrowed = false;
    }
}
