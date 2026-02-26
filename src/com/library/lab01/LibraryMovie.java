package com.library.lab01;

public class LibraryMovie implements DigitalContent {
    private String title;
    private String director;
    private String streamingUrl;
    private int durationMinutes;
    private int releaseYear;
    private String genre;
    private double rentalPrice;

    public LibraryMovie(String title, String director, String streamingUrl, int durationMinutes, int releaseYear, String genre, double rentalPrice) {
        this.title = title;
        this.director = director;
        this.streamingUrl = streamingUrl;
        this.durationMinutes = durationMinutes;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rentalPrice = rentalPrice;
    }

    @Override
    public void streamOnline() {
        System.out.println(" 🎬 Playing Movie: " + title + " [" + genre + "]");
        System.out.println(" > Directed by: " + director);
        System.out.println(" > Streaming from: " + streamingUrl);
    }

    @Override
    public void download() {
        System.out.println(" > Downloading movie: " + title + " (HD Quality)...");
        System.out.println(" > Please check your offline library once finished.");
    }

    // Getter สำหรับใช้ในหน้า Main
    public String getTitle() { return title; }
}