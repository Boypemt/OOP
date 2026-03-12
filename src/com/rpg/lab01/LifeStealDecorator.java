package com.rpg.lab01;


public class LifeStealDecorator extends AttackDecorator {
    private final double ratio;

    public LifeStealDecorator(Attack wrappedAttack, double ratio) {
        super(wrappedAttack);
        if (ratio < 0 || ratio > 1) {
            throw new IllegalArgumentException("Life steal ratio must be between 0 and 1.");
        }
        this.ratio = ratio;
    }

    @Override
    public void attack(Character attacker, Destructible target) {
        int hpBefore = attacker.getHealthPoints();

        wrappedAttack.attack(attacker, target);

        if (!attacker.isAlive()) return;

        // คำนวณปริมาณการฟื้นฟู (Base Damage + Weapon)
        int healBase = attacker.getDamage() + attacker.getWeapon().getBaseDamage();
        int healAmount = Math.max(1, (int) Math.round(healBase * ratio));
        int missing = attacker.getMaxHealthPoints() - attacker.getHealthPoints();

        if (missing <= 0) return;

        // ทำการฟื้นฟู HP
        int restored = Math.min(healAmount, missing);
        attacker.setHealthPoints(attacker.getHealthPoints() + restored);

        System.out.println(" 🩸 [LIFE STEAL] Restored " + restored + " HP to " + attacker.getName()
                + " (" + hpBefore + " -> " + attacker.getHealthPoints() + ")");
    }
}