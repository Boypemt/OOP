package com.rpg.lab01;

public class Warrior extends Character {
    private int armorValue;

    public Warrior(String name, int level, int maxHP, int damage, int defense, int armorValue, Weapon weapon) {
        super(name, level, maxHP, damage, defense, weapon, "Warrior");
        this.armorValue = armorValue;
    }

    /**
     * แก้ไข: เปลี่ยนพารามิเตอร์จาก Character เป็น Destructible
     * เพื่อให้ตรงกับเมธอดในคลาสแม่ที่ปรับปรุงใหม่
     */
    @Override
    public void attack(Destructible target) {
        if (this.isDestroyed()) return;

        int bonusDamage = (int) ((this.damage + weapon.getBaseDamage()) * 1.5);
        System.out.println(name + " swings " + weapon.getName() + " with heavy force! (1.5x Bonus)");
        System.out.println(" ⚔️ Raw Attack Damage: " + bonusDamage);

        // เรียกใช้ takeDamage แทน receiveDamage
        target.takeDamage(bonusDamage);
    }

    /**
     * แก้ไข: เปลี่ยนชื่อเมธอดจาก receiveDamage เป็น takeDamage
     * เพื่อให้ Override เมธอดจากคลาสแม่และ Interface ได้ถูกต้อง
     */
    @Override
    public void takeDamage(int amount) {
        int reducedDamage = Math.max(0, amount - armorValue);
        System.out.println(" 🛡️ " + name + "'s Armor: " + armorValue +
                " (reduces damage from " + amount + " to " + reducedDamage + ")");

        super.takeDamage(reducedDamage);
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println(" Armor Value:    " + armorValue);
    }

    public int getArmorValue() { return armorValue; }
    public void setArmorValue(int armorValue) { this.armorValue = armorValue; }
}