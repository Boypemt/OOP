package com.rpg.lab01;

public class Character {
    protected String name;
    protected int level;
    protected int currentHP;
    protected int maxHP;
    protected int damage;    // พลังโจมตีพื้นฐาน
    protected int defense;   // พลังป้องกัน
    protected Weapon weapon;
    protected String characterClass;

    public Character(String name, int level, int maxHP, int damage, int defense, Weapon weapon, String characterClass) {
        this.name = name;
        this.level = level;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.damage = damage;
        this.defense = defense;
        this.weapon = weapon;
        this.characterClass = characterClass;
    }

    public boolean isAlive() { //
        return currentHP > 0;
    }

    public void attack(Character target) { //
        if (!this.isAlive()) {
            System.out.println(name + " is fainted and cannot attack!");
            return;
        }
        int rawDamage = this.damage + weapon.getBaseDamage();
        System.out.println(name + " (" + characterClass + ") attacks " + target.name + " (" + target.characterClass + ")!");
        target.takeDamage(rawDamage); // ส่งค่าความเสียหายดิบไปให้เป้าหมาย
    }

    public void takeDamage(int rawDamage) { //
        int finalDamage = rawDamage - this.defense;
        if (finalDamage < 0) finalDamage = 0;

        this.currentHP -= finalDamage;
        if (this.currentHP < 0) this.currentHP = 0;

        System.out.println(" > " + name + " receives " + finalDamage + " damage (Raw: " + rawDamage + " - Def: " + defense + ")");
        System.out.println(" > Current HP of " + name + ": " + currentHP + "/" + maxHP);
    }

    public void levelUp() {
        this.level++;
        this.maxHP += 10;
        this.currentHP = maxHP;
        System.out.println(name + " leveled up to Level " + level + "!");
    }

    public void displayCharacterDetails() {
        String status = isAlive() ? "Active" : "Fainted"; //
        System.out.println("\n--- " + name.toUpperCase() + " ---");
        System.out.println("Class: " + characterClass + " [" + status + "]");
        System.out.println("Level: " + level);
        System.out.println("HP: " + currentHP + "/" + maxHP);
        System.out.println("Atk: " + damage + " | Def: " + defense);
        System.out.println("Weapon: " + weapon.toString());
    }
}