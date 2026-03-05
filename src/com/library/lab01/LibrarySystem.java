package com.library.lab01;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private static LibrarySystem instance;
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    private LibrarySystem() {} // Private constructor

    public static LibrarySystem getInstance() {
        if (instance == null) {
            instance = new LibrarySystem();
        }
        return instance;
    }

    public void addItem(LibraryItem item) { items.add(item); }
    public void addMember(Member member) { members.add(member); }
    public List<Member> getAllMembers() { return members; }
    public List<LibraryItem> getAllItems() { return items; }

    public Member findMemberById(String id) {
        return members.stream().filter(m -> m.getMemberId().equals(id)).findFirst().orElse(null);
    }

    public void displayStatistics() {
        System.out.println("Total Items: " + items.size());
        System.out.println("Total Members: " + members.size());
    }
}