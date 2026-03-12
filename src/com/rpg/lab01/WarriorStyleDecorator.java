package com.rpg.lab01;

public class WarriorStyleDecorator extends AttackDecorator {
    public WarriorStyleDecorator(Attack wrappedAttack) {
        super(wrappedAttack);
    }

    @Override
    public void attack(Character attacker, Destructible target) {
        int originalDamage = attacker.getDamage();
        int enhancedDamage = (int) Math.round(originalDamage * 1.5);

        attacker.setDamage(enhancedDamage);
        System.out.println("\n🔥 Warrior Power Strike (1.5x Multiplier)!");

        try {
            wrappedAttack.attack(attacker, target);
        } finally {
            attacker.setDamage(originalDamage); // คืนค่าดาเมจปกติหลังโจมตีเสร็จ
        }
    }
}