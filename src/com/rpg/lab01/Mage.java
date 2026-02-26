package com.rpg.lab01;

public class Mage extends Character {
    private int mana;

    public Mage(String name, int level, int maxHP, int damage, int defense, int mana, Weapon weapon) {
        super(name, level, maxHP, damage, defense, weapon, "Mage");
        this.mana = mana;
    }

    /**
     * แก้ไข: เปลี่ยนพารามิเตอร์เป็น Destructible
     * เพื่อให้สามารถโจมตีได้ทั้งตัวละครและวัตถุ (เช่น WoodenBox)
     */
    @Override
    public void attack(Destructible target) {
        if (this.isDestroyed()) {
            System.out.println(name + " is fainted and cannot cast spells!");
            return;
        }

        if (mana >= 10) {
            this.mana -= 10;
            System.out.println(name + " casts Magic Missile spell! (Mana left: " + mana + ")");

            int rawDamage = this.damage + weapon.getBaseDamage();
            System.out.println(" 🪄 Raw Attack Damage: " + rawDamage);

            target.takeDamage(rawDamage);
        } else {
            System.out.println(name + " out of mana!");
        }
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println(" Mana:           " + mana + "/150");
    }

    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }
}
