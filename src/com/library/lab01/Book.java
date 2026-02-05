package com.library.lab01;
import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String borrow;
    private LocalDate returnDueDate;

    public Book(String title, String author, String isbn, double price, String borrowStatus) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.borrow = "Available";
    }

    public void checkOut() {
        if(this.borrow.equals("Available")){
            System.out.println("Book '" + title +"' has been checked out successfully.");
            this.borrow = "Already Borrowed";
            this.returnDueDate = LocalDate.now().plusDays(14);
        } else {
            System.out.println("Error: Book '" + title +"' is already borrowed and cannot be checked out again.");
        }
    }

    public void returnBook() {
        this.borrow = "Available";
        this.returnDueDate = null;
        System.out.println("Book '" + title +"' has been returned successfully");
    }

    public void displayDetails() {
        System.out.println(" -Title: " + title);
        System.out.println(" -Author: " + author);
        System.out.println(" -ISBN: " + isbn + " - Price: " + price + " Baht");
        System.out.println(" -Status: " + borrow);

        // เช็คเงื่อนไขการแสดงวันที่
        if (borrow.equals("Available")) {
            System.out.println(" -Return Due Date: N/A (Book is available)");
        } else {
            System.out.println(" -Return Due Date: " + returnDueDate);
        }
    }
}