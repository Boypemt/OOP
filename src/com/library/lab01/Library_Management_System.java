package com.library.lab01;

import java.util.ArrayList;
import java.util.List;

public class Library_Management_System {
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println(" LIBRARY MANAGEMENT SYSTEM - POLYMORPHISM DEMO");
        System.out.println("=".repeat(60));

        List<LibraryItem> books = new ArrayList<>();

        books.add(new PhysicalBook("Java Programming", "John Smith", "978-0134685991", 450.0, "A1-04"));
        books.add(new PhysicalBook("Clean Code", "Robert Martin", "978-0132350884", 520.0, "B2-15"));
        books.add(new PhysicalBook("Design Patterns", "Gang of Four", "978-0201633612", 680.0, "A3-22"));
        books.add(new Ebook("Effective Java", "Joshua Bloch", "978-0134685991", "https://lib.com/java.pdf", 5.2));
        books.add(new Ebook("Python Crash Course", "Eric Matthes", "978-1593279288", "https://lib.com/python.pdf", 8.7));

        Member member1 = new Member("M001", "Somsak");

        System.out.println("\n--- Initial Library Items Information ---");
        for (LibraryItem item : books) {
            item.displayDetails();
        }

        System.out.println("\n--- Testing checkOut() Method ---");
        System.out.println("\nAttempting to checkout Item 1 (Physical) and Item 4 (E-Book):");
        books.get(0).checkOut(member1);
        books.get(3).checkOut(member1);

        System.out.println("\nAttempting to checkout Item 1 again (Already Borrowed):");
        books.get(0).checkOut(member1);

        System.out.println("\n--- Testing returnItem() Method ---");
        System.out.println("\nReturning Item 1:");
        books.get(0).returnItem();

        System.out.println("\n--- Challenging Scenario: Borrowing Limit ---");
        books.get(0).checkOut(member1);
        books.get(1).checkOut(member1);
        books.get(2).checkOut(member1);

        System.out.println("\n--- Final Library Status Summary ---");
        for (LibraryItem item : books) {
            item.printSummary();
        }

        System.out.println("\n--- Late Fee Calculation (5 days) ---");
        for (LibraryItem item : books) {
            double fee = item.calculateLateFee(5);
            System.out.println(" - " + item.getTitle() + ": " + fee + " Baht");
        }
    }
}