package com.library.lab01;
import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String status;
    private LocalDate returnDueDate;

    public Book(String title, String author, String isbn, double price, String status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.status = status;
    }

    public void checkOut(Member borrower) {
        if (this.status.equals("Available")) {
            if (borrower.canBorrow()) {
                this.status = "Borrowed";
                this.returnDueDate = LocalDate.now().plusDays(14);
                borrower.incrementBorrowed();
                System.out.println(" Book '" + title + "' has been checked out successfully.");
                System.out.println(" Book " + title + " has been borrowed by " + borrower.getName() + ".");
                System.out.println(" Return Due Date: " + returnDueDate);
            } else {
                System.out.println(" Member " + borrower.getName() + " has reached the borrow limit (3).");
                System.out.println(" Borrow request denied for member " + borrower.getName() + ".");
            }
        } else {
            System.out.println(" Error: Book '" + title + "' is already borrowed and cannot be checked out again.");
        }
    }

    public void returnBook() {
        this.status = "Available";
        System.out.println(" Book '" + title + "' has been returned successfully.");
    }

    public void printSummary() {
        System.out.println("Book[Title='" + title + "', Status='" + status + "']");
    }
}