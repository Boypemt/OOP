package com.rpg.lab01;

public class DamageBoostDecorator extends AttackDecorator {
    private final int bonusDamage;

    public DamageBoostDecorator(Attack wrappedAttack, int bonusDamage) {
        super(wrappedAttack);
        if (bonusDamage < 0) {
            throw new IllegalArgumentException("Bonus damage cannot be negative.");
        }
        this.bonusDamage = bonusDamage;
    }

    @Override
    public void attack(Character attacker, Destructible target) {
        int originalDamage = attacker.getDamage();

        attacker.setDamage(originalDamage + bonusDamage);

        try {
            System.out.println(" 💪 [DAMAGE BOOST] Attack power increased by " + bonusDamage + "!");
            wrappedAttack.attack(attacker, target);
        } finally {
            attacker.setDamage(originalDamage);
        }
    }
}