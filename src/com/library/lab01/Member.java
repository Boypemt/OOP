package com.library.lab01;

public class Member {
    private String memberId;
    private String name;
    private int borrowedCount = 0;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getName() { return name; }

    public boolean canBorrow() {
        return borrowedCount < 3;
    }

    public void incrementBorrowed() { borrowedCount++; }
    public void decrementBorrowed() { borrowedCount--; }
}