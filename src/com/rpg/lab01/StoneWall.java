package com.rpg.lab01;


public class StoneWall implements Destructible {
    private String name;
    private int hp;
    private String location;

    public StoneWall(String name, int hp, String location) {
        this.name = name;
        this.hp = hp;
        this.location = location;
    }

    @Override
    public String getName() { return name; }

    @Override
    public boolean isDestroyed() { return hp <= 0; }

    @Override
    public void takeDamage(int amount) {
        int finalDamage = amount / 2;
        this.hp = Math.max(0, this.hp - finalDamage);
        System.out.println(" 🧱 " + name + " is very sturdy! Damage reduced: " + finalDamage + " (Remaining HP: " + hp + ")");
    }

    public String getLocation() {
        return location;
    }

    public void displayWallDetails() {
        System.out.println("Structure: " + name + " | Location: " + location + " | HP: " + hp + " | Status: " + (isDestroyed() ? "DESTROYED" : "INTACT"));
    }
}