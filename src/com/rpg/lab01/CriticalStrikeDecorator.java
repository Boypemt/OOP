package com.rpg.lab01;

public class CriticalStrikeDecorator extends AttackDecorator {
    public CriticalStrikeDecorator(Attack wrappedAttack) {
        super(wrappedAttack);
    }

    @Override
    public void attack(Character attacker, Destructible target) {
        int originalDamage = attacker.getDamage();
        boolean critical = (Math.random() * 100) < 25;

        if (critical) {
            attacker.setDamage(originalDamage * 2);
            String targetName = target.getName();
            System.out.println("\n💥 " + attacker.getName() + " lands a CRITICAL STRIKE on " + targetName + "!");
            System.out.println(" Base Damage: " + originalDamage + " -> Critical: " + attacker.getDamage() + " (2x)");
        }

        try {
            wrappedAttack.attack(attacker, target);
        } finally {
            attacker.setDamage(originalDamage);
        }
    }
}