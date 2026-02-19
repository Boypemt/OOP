package com.library.lab01;

public class Ebook extends LibraryItem {
    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    private String downloadUrl;
    private double fileSize;

    public Ebook(String title, String author, String isbn, String downloadUrl, double fileSize) {
        super(title, author, isbn, 0.0);
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
    }

    @Override
    public void displayDetails() {
        System.out.println("E-BOOK");
        super.displayDetails();
        System.out.println(" - Download Url:    " + this.downloadUrl);
        System.out.println(" - File Size:       " + this.fileSize + " MB");
        System.out.println(" - Status:          " + this.status);
        System.out.println();
    }

    @Override
    public double calculateLateFee(int days) {
        return 0.0;
    }
}