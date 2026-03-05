package com.library.lab01;

/**
 * STRATEGY PATTERN - FamilyMembershipStrategy
 * สมาชิกประเภทครอบครัว (Family Membership) ตามข้อกำหนด Lab 05
 */
public class FamilyMembershipStrategy implements MembershipStrategy {
    private static final int BORROW_LIMIT = 6;
    private static final int LOAN_PERIOD = 21;
    private static final double LATE_FEE_DISCOUNT = 0.10;
    private static final double MEMBERSHIP_COST = 500.0;

    @Override
    public int getBorrowLimit() {
        return BORROW_LIMIT;
    }

    @Override
    public int getLoanPeriodDays() {
        return LOAN_PERIOD;
    }

    @Override
    public double applyLateFeeDiscount(double baseFee) {
        double discount = baseFee * LATE_FEE_DISCOUNT;
        double finalFee = baseFee - discount;
        System.out.println(" 👨‍👩‍👧‍👦 [Family Discount Applied]");
        System.out.println(" Original Fee: " + baseFee + " Baht");
        System.out.println(" Family Discount (10%): -" + discount + " Baht");
        return finalFee; // Base fee 200 -> Final fee 180
    }

    @Override
    public String getMembershipType() {
        return "Family Member";
    }

    @Override
    public double getMembershipCost() {
        return MEMBERSHIP_COST;
    }

    @Override
    public boolean hasUnlimitedBorrowing() {
        return false;
    }
}