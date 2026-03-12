package com.rpg.lab01;

public class HealthPotion implements Consumable {
    private String name;
    private int healAmount;
    private int uses;

    public HealthPotion(String name, int healAmount, int uses) {
        this.name = name;
        this.healAmount = healAmount;
        this.uses = uses;
    }

    @Override
    public void use(Character user) {
        if (uses > 0 && user.isAlive()) {
            user.receiveHeal(healAmount);
            uses--;
            System.out.println(" 🧪 " + user.getName() + " used " + name + ". (Remaining: " + uses + ")");
        } else if (!user.isAlive()) {
            System.out.println(" ❌ Cannot use " + name + ". " + user.getName() + " is fainted!");
        } else {
            System.out.println(" ❌ " + name + " is empty!");
        }
    }

    public void displayPotionDetails() {
        System.out.println(" - " + name + " (Heals: " + healAmount + ", Uses: " + uses + ")");
    }
}