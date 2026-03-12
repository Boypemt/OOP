package com.rpg.lab01;

public abstract class AttackDecorator implements Attack {
    protected final Attack wrappedAttack;

    public AttackDecorator(Attack attack) {
        this.wrappedAttack = attack;
    }

    @Override
    public void attack(Character attacker, Destructible target) {
        wrappedAttack.attack(attacker, target);
    }
}