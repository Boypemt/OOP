package com.rpg.lab01;

public class Warrior extends Character {
    private int armorValue;

    public Warrior(String name, int level, int maxHP, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, maxHP, damage, defense, weapon, "Warrior");
        this.armorValue = armorValue;

        setAttack(new WarriorStyleDecorator(getAttack()));
    }


    @Override
    public void takeDamage(int amount) {
        int reducedDamage = Math.max(0, amount - armorValue);
        System.out.println(" 🛡️ Armor " + armorValue + " reduces damage to " + reducedDamage);
        super.takeDamage(reducedDamage);
    }
}