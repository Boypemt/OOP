package com.rpg.lab01;

public class Character {
    protected String name;
    protected int level;
    protected int currentHP;
    protected int maxHP;
    protected Weapon weapon;
    protected String characterClass;

    public Character(String name, int level, int maxHP, Weapon weapon, String characterClass) {
        this.name = name;
        this.level = level;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.weapon = weapon;
        this.characterClass = characterClass;
    }

    public String getName() { return name; }

    public int attack() {
        int levelBonus = this.level * 2;
        int totalDamage = weapon.getBaseDamage() + levelBonus;
        System.out.println(name + " (" + characterClass + ") attacks with " + weapon.getName() + "!");
        System.out.println("Attack Damage: " + totalDamage + " (Weapon Base: " + weapon.getBaseDamage() + " + Level Bonus: " + levelBonus + ")");
        return totalDamage;
    }

    public void takeDamage(int damage) {
        this.currentHP -= damage;
        System.out.println(name + " takes " + damage + " damage! Current HP: " + currentHP + "/" + maxHP);
    }

    public void levelUp() {
        this.level++;
        this.maxHP += 10;
        this.currentHP = maxHP;
        System.out.println(name + " leveled up to Level " + level + "!");
        System.out.println("Max Health increased to " + maxHP + " (full heal applied)");
    }

    public void displayCharacterDetails() {
        System.out.println("\n--- " + name.toUpperCase() + " ---");
        System.out.println("Class: " + characterClass);
        System.out.println("Level: " + level);
        System.out.println("Health Points: " + currentHP + "/" + maxHP);
        System.out.println(" Weapon: " + weapon.toString());
    }
}