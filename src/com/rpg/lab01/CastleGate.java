package com.rpg.lab01;

public class CastleGate implements Destructible {
    private String name;
    private int hp;
    private boolean isReinforced;

    public CastleGate(String name, int hp, boolean isReinforced, boolean isOpen) {
        this.name = name;
        this.hp = hp;
        this.isReinforced = isReinforced;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void takeDamage(int amount) {
        int finalDamage = isReinforced ? amount / 2 : amount;
        this.hp = Math.max(0, this.hp - finalDamage);
        System.out.println(name + " takes " + finalDamage + " damage. (HP: " + hp + ")");
    }

    @Override
    public boolean isDestroyed() { return hp <= 0; }

    public void displayGateDetails() {
        System.out.println("Gate: " + name + " Reinforced: " + isReinforced + " HP: " + hp);
    }
}