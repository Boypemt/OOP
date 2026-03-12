package com.rpg.lab01;

public class BaseAttack implements Attack {
    @Override
    public void attack(Character attacker, Destructible target) {
        int rawDamage = attacker.damage + attacker.weapon.getBaseDamage();
        System.out.println(attacker.name + " performs a basic attack!");
        target.takeDamage(rawDamage);
    }
}