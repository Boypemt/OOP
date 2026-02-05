package com.rpg.lab01;

public class Healer extends Character {
    private int baseHealingPower;

    public Healer(String name, int level, int maxHP, Weapon weapon, int baseHealingPower) {
        super(name, level, maxHP, weapon, "Healer");
        this.baseHealingPower = baseHealingPower;
    }

    public void heal() {
        int levelBonus = this.level * 3;
        int totalHeal = baseHealingPower + levelBonus;
        this.currentHP = Math.min(this.maxHP, this.currentHP + totalHeal);
        System.out.println(name + " (Healer) casts a healing spell!");
        System.out.println("Healing Amount: " + totalHeal + " (Base: " + baseHealingPower + " + Level Bonus: " + levelBonus + ")");
        System.out.println("Restored " + totalHeal + " HP! Current HP: " + currentHP + "/" + maxHP);
    }

    public void healAlly(Character ally) {
        int levelBonus = this.level * 3;
        int totalHeal = baseHealingPower + levelBonus;
        ally.currentHP = Math.min(ally.maxHP, ally.currentHP + totalHeal);
        System.out.println(name + " (Healer) casts healing spell on " + ally.getName() + "!");
        System.out.println("Healing Amount: " + totalHeal);
        System.out.println("Restored " + totalHeal + " HP to " + ally.getName() + "! Their HP: " + ally.currentHP);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println(" Healing Power: " + baseHealingPower);
    }
}