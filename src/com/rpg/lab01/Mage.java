package com.rpg.lab01;

public class Mage extends Character {
    private int mana;
    private int maxMana = 150; // กำหนดค่าสูงสุดตามที่แสดงใน displayCharacterDetails

    public Mage(String name, int level, int maxHP, int damage, int defense, int mana, Weapon weapon) {
        super(name, level, maxHP, damage, defense, weapon, "Mage");
        this.mana = mana;
        this.maxMana = 150;

        setAttack(new MageStyleDecorator(getAttack()));
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println(" Mana:           " + mana + "/" + maxMana);
    }


    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}