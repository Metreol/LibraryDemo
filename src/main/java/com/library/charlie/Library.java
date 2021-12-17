package com.library.charlie;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> catalogue = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public List<Book> getCatalogue() {
        return catalogue;
    }

    public List<Member> getMembers() {
        return members;
    }

    public int getCatalogueCount() {
        return catalogue.size();
    }

    public boolean addBook(Book book) {
        if (catalogueContains(book)) {
            return false;
        } else {
            catalogue.add(book);
            return true;
        }
    }

    public boolean removeBook(Book book) {
        if (catalogueContains(book)) {
            catalogue.remove(book);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeBookAtIndex(int index) {
        if (index < getCatalogueCount()) {
            catalogue.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public boolean addMember(Member member) {
        if (members.contains(member)) {
            return false;
        } else {
            members.add(member);
            return true;
        }
    }

    public boolean removeMember(Member member) {
        if (members.contains(member)) {
            members.remove(member);
            return true;
        } else {
            return false;
        }
    }

    public boolean lendBook(Member member, PhysicalBook book) {
        if (catalogueContains(book) && member.borrowedBookCount() < 5) {
            book.setMember(member);
            member.addBook(book);
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook(PhysicalBook book, Member member, boolean recordDamages, String damages) {
        if (catalogueContains(book)) {
            member.removeBook(book);
            book.setMember(null);
            if (recordDamages) {
                book.setCondition(damages);
            }
            return true;
        } else {
            return false;
        }
    }

    public void sendMessage(String message) {
        for (Member member : members) {
            if (member.borrowedBookCount() > 0) {
                member.addMessage(message);
            }
        }
    }

    public boolean changeTitle(Book book, String newTitle) {
        if (catalogueContains(book)) {
            book.setTitle(newTitle);
            return true;
        } else {
            return false;
        }
    }

    public boolean catalogueContains(Book book) {
        return catalogue.contains(book);
    }

    public Book inspectBook(Book book) {
        if (catalogueContains(book)) {
            return book;
        } else {
            return null;
        }
    }

    public void printBookDetails(String isbn) {
        for (Book book : catalogue) {
            if (book.getISBN().equals(isbn)) {
                book.printDetails();
                return;
            }
        }
        System.out.println(
            String.format("No book with ISBN \"%s\" exists in the Library catalogue", isbn));
    }

    public void printAllPhysicalBookDetails() {
        System.out.println("All Physical Books:");
        for (Book book : catalogue) {
            if (book instanceof PhysicalBook physicalBook) {
                physicalBook.printDetails();
                System.out.println();
            }
        }
    }

    public void printAllElectronicBookDetails() {
        System.out.println("All Electronic Books:");
        for (Book book : catalogue) {
            if (book instanceof EBook electronicBook) {
                electronicBook.printDetails();
                System.out.println();
            }
        }
    }

    public void printAllAvailableBooks() {
        System.out.println("All Available Physical Books:");
        for (Book book : catalogue) {
            if (book instanceof PhysicalBook physicalBook && physicalBook.isAvailable()) {
                physicalBook.printDetails();
                System.out.println();
            }
        }
        printAllElectronicBookDetails();
    }

    public void printAuthorDeatils(String author) {
        for (Book book : catalogue) {
            if (book.getAuthor().equals(author)) {
                if (book instanceof PhysicalBook physicalBook) {
                    physicalBook.printDetails();
                } else {
                    ((EBook) book).printDetails();
                }
            }
        }
    }

    public void printAllBookDetails() {
        printAllPhysicalBookDetails();
        printAllElectronicBookDetails();
    }

}
