package com.library;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int id;
    private List<PhysicalBook> borrowedBooks = new ArrayList<>();
    private List<String> messages = new ArrayList<>();

    public Member(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addBook(PhysicalBook book) {
        borrowedBooks.add(book);
    }

    public boolean removeBook(PhysicalBook book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            return true;
        } else {
            return false;
        }
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public void printDetails() {
        System.out.println(String.format("Name: %s%nID: %s", this.name, this.id));
        System.out.println("Messages:");
        printMessages();
        System.out.println("Borrowed Books:");
        printBorrowedBookDetails();
    }

    public void printMessages() {
        for (String message: messages) {
            System.out.println(message);
        }
    }

    public void printBorrowedBookDetails() {
        for (PhysicalBook book: borrowedBooks) {
            book.printDetails();
        }
    }

    public int borrowedBookCount() {
        return borrowedBooks.size();
    }
}
