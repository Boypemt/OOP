package com.rpg.lab01;

public class Healer extends Character {
    private int baseHealingPower;

    public Healer(String name, int level, int maxHP, int damage, int defense, Weapon weapon, int baseHealingPower) {
        super(name, level, maxHP, damage, defense, weapon, "Healer");
        this.baseHealingPower = baseHealingPower;
    }

    public void heal() {
        if (!isAlive()) return;
        int totalHeal = baseHealingPower + (level * 2);
        this.currentHP = Math.min(maxHP, currentHP + totalHeal);
        System.out.println(name + " heals themselves for " + totalHeal + " HP!");
    }

    public void healAlly(Character ally) {
        if (!isAlive()) return;
        int totalHeal = baseHealingPower + (level * 2);
        ally.currentHP = Math.min(ally.maxHP, ally.currentHP + totalHeal);
        System.out.println(name + " heals " + ally.name + " for " + totalHeal + " HP!");
    }
}