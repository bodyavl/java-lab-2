package org.lab;

public class Book {
    public String title;
    public String author;
    public long ISBN;
    public int releaseYear;

    public Book(String title, String author, long ISBN, int releaseYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.releaseYear = releaseYear;
    }
}
