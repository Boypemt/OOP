package com.rpg.lab01;

public class Character {
    protected String name;
    protected String characterClass;
    protected int level;
    protected int currentHP;
    protected int maxHP;
    protected int damage;
    protected int defense;
    protected Weapon weapon;

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

    public String getName() { return name; }

    public boolean isAlive() { return currentHP > 0; }

    public void attack(Character target) {
        if (!this.isAlive()) {
            System.out.println(name + " is fainted and cannot attack!");
            return;
        }

        int rawDamage = this.damage + weapon.getBaseDamage();

        System.out.println(name + " attacks " + target.getName() + "!");

        target.receiveDamage(rawDamage);
    }

    public void receiveDamage(int amount) {
        int finalDamage = Math.max(0, amount - this.defense);

        this.currentHP = Math.max(0, this.currentHP - finalDamage);

        System.out.println(" Actual Damage Taken: " + finalDamage);
        System.out.println(name + "'s HP: " + currentHP + "/" + maxHP);
    }

    public void levelUp() {
        this.level++;
        this.maxHP += 100;
        this.currentHP = maxHP;
        System.out.println(name + " leveled up to Level " + level + "!");
    }

    public void displayCharacterDetails() {
        String status = isAlive() ? "Active" : "Fainted";
        System.out.println("\n--- " + name.toUpperCase() + " (" + characterClass.toUpperCase() + ") ---");
        System.out.println(" Status:         " + status);
        System.out.println(" Level:          " + level);
        System.out.println(" Health Points:  " + currentHP + "/" + maxHP);
        System.out.println(" Damage:         " + damage);
        System.out.println(" Defense:        " + defense);
        System.out.println(" Weapon:         " + weapon.toString());
    }
}