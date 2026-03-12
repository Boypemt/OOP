package com.rpg.lab01;


public class MageStyleDecorator extends AttackDecorator {
    private static final int MAGIC_MISSILE_COST = 30;

    public MageStyleDecorator(Attack wrappedAttack) {
        super(wrappedAttack);
    }

    @Override
    public void attack(Character attacker, Destructible target) {
        if (!(attacker instanceof Mage)) {
            wrappedAttack.attack(attacker, target);
            return;
        }

        Mage mage = (Mage) attacker;
        String targetName = target.getName();

        if (mage.getMana() < MAGIC_MISSILE_COST) {
            System.out.println("\n✨ " + mage.getName() + " attempts to cast Magic Missile, but has insufficient mana!");
            System.out.println(" Current Mana: " + mage.getMana() + "/" + mage.getMaxMana() + " (Need: " + MAGIC_MISSILE_COST + ")");
            return;
        }

        int originalDamage = mage.getDamage();

        // ประยุกต์ใช้ Mana-based spell bonus (Step 6)
        mage.setDamage(originalDamage + 10);
        mage.setMana(mage.getMana() - MAGIC_MISSILE_COST);

        System.out.println("\n✨ " + mage.getName() + " (Mage) casts MAGIC MISSILE at " + targetName + "!");
        System.out.println(" Spell Bonus: +10 | Mana Used: " + MAGIC_MISSILE_COST + " | Remaining: " + mage.getMana() + "/" + mage.getMaxMana());

        try {
            wrappedAttack.attack(attacker, target);
        } finally {
            mage.setDamage(originalDamage);
        }
    }
}