package com.rpg.lab01;

public class WoodenBox implements Destructible {
    private String name;
    private int hp;
    private String itemInside;

    public WoodenBox(String name, int hp, boolean isLocked, String item) {
        this.name = name;
        this.hp = hp;
        this.itemInside = item;
    }

    @Override
    public void takeDamage(int amount) {
        if (isDestroyed()) return;
        this.hp = Math.max(0, this.hp - amount);
        System.out.println(" 📦 " + name + " takes " + amount + " damage. (HP left: " + hp + ")");
    }

    @Override
    public boolean isDestroyed() { return hp <= 0; }

    @Override
    public String getName() { return name; }

    public void breakOpen() {
        if (isDestroyed()) {
            System.out.println(" Box broken! Found: " + itemInside);
        } else {
            System.out.println(" The box is still intact. Keep attacking!");
        }
    }

    public void displayBoxDetails() {
        System.out.println(" - " + name + " (HP: " + hp + ")");
    }
}