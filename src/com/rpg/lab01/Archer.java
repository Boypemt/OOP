package com.rpg.lab01;

public class Archer extends Character {

    private int accuracy;

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public Archer(String name, int level, int maxHP, int damage, int defense, int accuracy, Weapon weapon) {
        super(name, level, maxHP, damage, defense, weapon, "Archer");
        this.accuracy = accuracy;
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println(" Accuracy: " + accuracy + "%");
        System.out.println(" Range Advantage: Yes (30% bonus)");

    }
}
