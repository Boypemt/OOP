package com.library.lab01;

public class Member {
    private String memberId;
    private String name;
    private int borrowedCount = 0;
    // เพิ่มฟิลด์สำหรับ Strategy Pattern
    private MembershipStrategy membershipStrategy;

    public Member(String memberId, String name, MembershipStrategy strategy) {
        this.memberId = memberId;
        this.name = name;
        this.membershipStrategy = strategy;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public boolean canBorrow() {
        return borrowedCount < membershipStrategy.getBorrowLimit();
    }

    public double calculateLateFee(double baseFee) {
        return membershipStrategy.applyLateFeeDiscount(baseFee);
    }

    public void setMembershipStrategy(MembershipStrategy strategy) {
        this.membershipStrategy = strategy;
    }

    public void displayMemberInfo() {
        System.out.println("Member: " + name + " [" + memberId + "]");
        System.out.println(" - Type: " + membershipStrategy.getMembershipType());
        System.out.println(" - Borrow Limit: " + membershipStrategy.getBorrowLimit());
    }

    public void incrementBorrowed() { borrowedCount++; }
    public void decrementBorrowed() { borrowedCount--; }
}