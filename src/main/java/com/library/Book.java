package com.library;


public class Book {
    String title;
    String author;
    String isbn;

    /** 
    * Represents a book object for the Library Demo.
    * @author  Charlie Shale
    * @version 1.0
    * @since   2021-12-18
    */
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public void printDetails() {
        System.out.println(String.format("Title: %s%nAuthor: %s%nISBN: %s",
                title, author, isbn));
    }
}
