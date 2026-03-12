package com.rpg.lab01;

public class Archer extends Character {
    private int accuracy;
    private boolean rangeAdvantage = true;

    public Archer(String name, int level, int maxHP, int damage, int defense, int accuracy, Weapon weapon) {
        super(name, level, maxHP, damage, defense, weapon, "Archer");
        this.accuracy = accuracy;

        setAttack(new ArcherStyleDecorator(getAttack()));
    }

    public int getAccuracy() { return accuracy; }
    public boolean hasRangeAdvantage() { return rangeAdvantage; }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println(" Accuracy: " + accuracy + "%");
        System.out.println(" Range Advantage: " + (rangeAdvantage ? "Yes (30% bonus)" : "No"));
    }
}