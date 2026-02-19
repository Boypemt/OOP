package com.rpg.lab01;

class Warrior extends Character {
    public int getArmorValue() {
        return armorValue;
    }

    public void setArmorValue(int armorValue) {
        this.armorValue = armorValue;
    }

    private int armorValue;

    public Warrior(String name, int level, int maxHP, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, maxHP, damage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
    }

    @Override
    public void attack(Character target) {
        int bonusDamage = (int) ((this.damage + weapon.getBaseDamage()) * 1.5);
        System.out.println(name + " swings " + weapon + " with heavy force!");
        System.out.println("Raw Attack Damage: " + bonusDamage);
        target.receiveDamage(bonusDamage);
    }

    @Override
    public void receiveDamage(int amount) {
        // Challenge: Using super to keep original HP reduction logic
        int reducedDamage = Math.max(0, amount - armorValue);
        System.out.println(name + "'s Armor: " + armorValue + " (reduces damage from " + amount + " to " + reducedDamage + ")");
        super.receiveDamage(reducedDamage); // เรียกใช้ logic หัก HP ของคลาสแม่
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println(" Armor Value: " + armorValue);
    }
}