package com.rpg.lab01;

class Mage extends Character {
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    private int mana;

    public Mage(String name, int level, int maxHP, int damage, int defense, int mana, Weapon weapon) {
        super(name, level, maxHP, damage, defense, weapon, "Mage");
        this.mana = mana;
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " casts Magic Missile spell! (Mana left: " + (mana-10) + ")");
        int rawDamage = this.damage + weapon.getBaseDamage();
        System.out.println(" 🪄 Raw Attack Damage: " + rawDamage);
        target.receiveDamage(rawDamage);
    }
}
