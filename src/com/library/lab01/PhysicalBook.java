package com.library.lab01;

public class PhysicalBook extends LibraryItem implements Taxable {
    private String shelfLocation;

    public PhysicalBook(String title, String author, String isbn, double price, String shelfLocation) {
        super(title, author, isbn, price);
        this.shelfLocation = shelfLocation;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    @Override
    public void displayDetails() {
        System.out.println("PHYSICAL BOOK");
        super.displayDetails();
        System.out.println("- Price:           " + price + " Baht");
        System.out.println("- Shelf Location:  " + shelfLocation);
        System.out.println("- Status:          " + status);
        System.out.println("- Return Due Date: " + (status.equals("Available") ? "N/A (Book is available)" : returnDueDate));
        System.out.println();
    }

    @Override
    public void printSummary() {
        System.out.println("PhysicalBook[Title='" + title + "', Location='" + shelfLocation + "', Status='" + status + "']");
    }

    @Override
    public double calculateLateFee(int days) {
        return days * 5.0;
    }

    @Override
    public double calculateTax() {
        return this.price * 0.07;
    }
}