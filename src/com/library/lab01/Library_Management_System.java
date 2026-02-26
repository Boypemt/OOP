package com.library.lab01;

import java.util.ArrayList;
import java.util.List;

public class Library_Management_System {

    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  LIBRARY MANAGEMENT SYSTEM - INTERFACE & TAX DEMO");
        System.out.println("=".repeat(60));

        // 1. Create a list of LibraryItem (Inheritance & Polymorphism)
        List<LibraryItem> items = new ArrayList<>();

        // Add Physical Books (Implement Taxable 7%)
        items.add(new PhysicalBook("Java Programming", "John Smith", "978-0134685991", 450.0, "A1-04"));
        items.add(new PhysicalBook("Clean Code", "Robert Martin", "978-0132350884", 520.0, "B2-15"));
        items.add(new PhysicalBook("Design Patterns", "Gang of Four", "978-0201633612", 680.0, "A3-22"));

        // Add E-Books (Implement DigitalContent & Taxable 5%)
        items.add(new Ebook("Effective Java", "Joshua Bloch", "978-0134685991", "https://library.ebooks.com/effective-java.pdf", 5.2));
        items.add(new Ebook("Python Crash Course", "Eric Matthes", "978-1593279288", "https://library.ebooks.com/python-crash.pdf", 8.7));

        // 2. Display all items
        System.out.println("\n--- ALL LIBRARY ITEMS (Initial Summary) ---");
        for (LibraryItem item : items) {
            item.printSummary();
        }

        // 3. Testing Checkout & Return
        Member member1 = new Member("M001", "Somsak");
        System.out.println("\n--- TESTING CHECKOUT FUNCTIONALITY ---");
        items.get(0).checkOut(member1); // Borrowing Item 1

        // 4. Interface Implementation: Digital Content Demo
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  INTERFACE IMPLEMENTATION: DIGITAL CONTENT DEMO");
        System.out.println("=".repeat(60));

        System.out.println("\nProcessing Digital Access (Only for items implementing DigitalContent):");
        for (LibraryItem item : items) {
            if (item instanceof DigitalContent) {
                System.out.println("\n[Authorized] Accessing Digital Book: " + item.getTitle());
                launchStreamingPlayer((DigitalContent) item);
            }
        }

        // 5. Interface Implementation: Taxable Demo
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  INTERFACE IMPLEMENTATION: TAXABLE DEMO");
        System.out.println("=".repeat(60));

        System.out.println("\nCalculating Tax (Physical: 7%, Digital: 5%):");
        for (LibraryItem item : items) {
            if (item instanceof Taxable) {
                Taxable taxableItem = (Taxable) item;
                double tax = taxableItem.calculateTax();
                System.out.printf("  %s: Price = %.2f, Tax = %.2f, Total = %.2f Baht\n",
                        item.getTitle(), item.getPrice(), tax, item.getPrice() + tax);
            }
        }

        // 6. Challenge: Universal Streaming Player (Movies + EBooks)
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  UNIVERSAL STREAMING PLAYER (Challenge Section)");
        System.out.println("=".repeat(60));

        List<DigitalContent> digitalContentList = new ArrayList<>();

        // Add LibraryMovie (Does NOT inherit from LibraryItem, but implements DigitalContent)
        digitalContentList.add(new LibraryMovie("The Matrix", "Lana Wachowski", "https://stream.com/matrix.mp4", 136, 1999, "Sci-Fi", 199.0));
        digitalContentList.add(new LibraryMovie("Inception", "Christopher Nolan", "https://stream.com/inception.mp4", 148, 2010, "Sci-Fi/Thriller", 249.0));

        // Add EBooks to the same DigitalContent list (Interface Polymorphism)
        digitalContentList.add((DigitalContent) items.get(3)); // Effective Java

        for (DigitalContent content : digitalContentList) {
            System.out.println("\n--- Loading New Content ---");
            if (content instanceof LibraryMovie) {
                System.out.println("Type: MOVIE | Title: " + ((LibraryMovie) content).getTitle());
            } else if (content instanceof Ebook) {
                System.out.println("Type: E-BOOK | Title: " + ((LibraryItem) content).getTitle());
            }
            launchStreamingPlayer(content);
        }
    }

    /**
     * Universal Player: Works with ANY object that implements DigitalContent contract
     */
    public static void launchStreamingPlayer(DigitalContent content) {
        System.out.println("Connecting to streaming service...");
        content.streamOnline();
        System.out.println("User requests offline copy:");
        content.download();
    }
}