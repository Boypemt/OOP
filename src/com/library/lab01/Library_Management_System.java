package com.library.lab01;

import com.library.lab01.PhysicalBook;
import com.library.lab01.Ebook;

public class Library_Management_System {

    public static void main(String[] args) {
        // ==================== SINGLETON PATTERN DEMO ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" DESIGN PATTERNS: SINGLETON & STRATEGY");
        System.out.println("=".repeat(70));

        // Get the single instance of LibrarySystem (Singleton Pattern)
        System.out.println("\n[STEP 1] Initializing LibrarySystem (Singleton Pattern):");
        LibrarySystem librarySystem = LibrarySystem.getInstance();

        // Try to get instance again - should return same instance
        System.out.println("Getting LibrarySystem instance again:");
        LibrarySystem sameInstance = LibrarySystem.getInstance();
        System.out.println(" ✅ Same instance? " + (librarySystem == sameInstance));

        // ==================== CREATE LIBRARY ITEMS ====================
        System.out.println("\n[STEP 2] Creating Library Items:");
        PhysicalBook book1 = new PhysicalBook("Java Programming", "John Smith", "978-0134685991", 450.0, "A1-04");
        PhysicalBook book2 = new PhysicalBook("Clean Code", "Robert Martin", "978-0132350884", 520.0, "B2-15");
        PhysicalBook book3 = new PhysicalBook("Design Patterns", "Gang of Four", "978-0201633612", 680.0, "A3-22");
        PhysicalBook book4 = new PhysicalBook("The Art of War", "Sun Tzu", "978-1599869773", 250.0, "C1-10");
        PhysicalBook book5 = new PhysicalBook("Refactoring", "Martin Fowler", "978-0134757599", 550.0, "A2-08");

        librarySystem.addItem(book1);
        librarySystem.addItem(book2);
        librarySystem.addItem(book3);
        librarySystem.addItem(book4);
        librarySystem.addItem(book5);

        Ebook ebook1 = new Ebook("Effective Java", "Joshua Bloch", "978-0134685991", "https://library.ebooks.com/effective-java.pdf", 5.2);
        Ebook ebook2 = new Ebook("Python Crash Course", "Eric Matthes", "978-1593279288", "https://library.ebooks.com/python-crash.pdf", 8.7);

        librarySystem.addItem(ebook1);
        librarySystem.addItem(ebook2);

        // ==================== STRATEGY PATTERN: CREATE MEMBERS ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 3] STRATEGY PATTERN: Creating Members");
        System.out.println("=".repeat(70));
        System.out.println("\n✨ KEY CONCEPT: Each member has a MembershipStrategy!");

        Member basicMember = new Member("M001", "Somsak", new BasicMembershipStrategy());
        Member studentMember = new Member("M002", "Suda", new StudentMembershipStrategy());
        Member premiumMember = new Member("M003", "Somchai", new PremiumMembershipStrategy());

        // Add Family Member (As per Scenario 1 requirements)
        Member familyMember = new Member("M004", "Siri", new FamilyMembershipStrategy());

        librarySystem.addMember(basicMember);
        librarySystem.addMember(studentMember);
        librarySystem.addMember(premiumMember);
        librarySystem.addMember(familyMember);

        System.out.println("--- MEMBER INFORMATION ---");
        for (Member member : librarySystem.getAllMembers()) {
            member.displayMemberInfo();
        }

        // ==================== TESTING BORROW BEHAVIORS ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 4] STRATEGY PATTERN: Testing Borrow Behaviors");
        System.out.println("=".repeat(70));

        System.out.println("--- Basic Member (Somsak) Borrows (Limit: 1, Period: 14) ---");
        book1.checkOut(basicMember);

        System.out.println("\n--- Student Member (Suda) Borrows (Limit: 5, Period: 21) ---");
        book2.checkOut(studentMember);

        System.out.println("\n--- Family Member (Siri) Borrows (Limit: 6, Period: 21) ---");
        book4.checkOut(familyMember);

        System.out.println("\n--- Premium Member (Somchai) Borrows (Unlimited, Period: 30) ---");
        book3.checkOut(premiumMember);
        ebook1.checkOut(premiumMember);

        // ==================== LATE FEE COMPARISON ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 5] STRATEGY PATTERN: Late Fee Discounts");
        System.out.println("=".repeat(70));

        double baseFee = 200.0; // ใช้ฐาน 200 ตามโจทย์ Family Strategy
        System.out.println("Base Late Fee: " + baseFee + " Baht\n");

        System.out.println("1️⃣ Basic Member (No discount):");
        System.out.println(" Final: " + basicMember.calculateLateFee(baseFee) + " Baht\n");

        System.out.println("2️⃣ Student Member (20% discount):");
        System.out.println(" Final: " + studentMember.calculateLateFee(baseFee) + " Baht\n");

        System.out.println("3️⃣ Family Member (10% discount):");
        double familyFee = familyMember.calculateLateFee(baseFee);
        System.out.println(" ✅ Final: " + familyFee + " Baht (Expected: 180)\n");

        System.out.println("4️⃣ Premium Member (100% FREE!):");
        System.out.println(" Final: " + premiumMember.calculateLateFee(baseFee) + " Baht\n");

        // ==================== RUNTIME STRATEGY CHANGE ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println(" [STEP 6] STRATEGY PATTERN: Changing Strategy at Runtime");
        System.out.println("=".repeat(70));

        System.out.println("--- Somsak Upgrades from Basic to Premium ---");
        Member somsak = librarySystem.findMemberById("M001");

        System.out.println("\n--- Before Upgrade: Attempting to borrow more than limit --- ");
        book5.checkOut(somsak); // Should fail

        somsak.setMembershipStrategy(new PremiumMembershipStrategy());
        System.out.println("\n--- After Upgrade: Somsak is now Premium ---");
        somsak.displayMemberInfo();
        book5.checkOut(somsak); // Now success!

        // ==================== STATISTICS ====================
        librarySystem.displayStatistics();
    }
}