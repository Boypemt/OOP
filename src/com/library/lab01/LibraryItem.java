package com.library.lab01;
import java.time.LocalDate;

public abstract class LibraryItem {
    protected String title;
    protected String author;
    protected String isbn;
    protected double price;
    protected String status = "Available";
    protected LocalDate returnDueDate;

    public LibraryItem(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }

    public void checkOut(Member borrower) {
        if (this.status.equals("Available")) {
            if (borrower.canBorrow()) {
                this.status = "Borrowed";
                this.returnDueDate = LocalDate.now().plusDays(14);
                borrower.incrementBorrowed();
                System.out.println("Item '" + title + "' has been checked out successfully.");
                System.out.println("Return Due Date: " + returnDueDate);
            } else {
                System.out.println("Error: Member " + borrower.getName() + " has reached the borrow limit.");
            }
        } else {
            System.out.println("Error: Item '" + title + "' is already borrowed.");
        }
    }

    public void returnItem() {
        this.status = "Available";
        this.returnDueDate = null;
        System.out.println("Item '" + title + "' has been returned successfully.");
    }

    public void displayDetails() {
        System.out.println("- Title:           " + title);
        System.out.println("- Author:          " + author);
        System.out.println("- ISBN:            " + isbn);
    }

    public void printSummary() {
        System.out.println(getClass().getSimpleName() + "[Title='" + title + "', Status='" + status + "']");
    }

    public abstract double calculateLateFee(int days);
}