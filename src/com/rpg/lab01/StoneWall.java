package com.rpg.lab01;

public class StoneWall implements Destructible {
    private int hp = 500;
    public String getName() { return "Stone Wall"; }
    public boolean isDestroyed() { return hp <= 0; }
    public void takeDamage(int amount) {
        hp -= (amount / 2);
        System.out.println(" 🧱 Stone Wall is very sturdy! (HP: " + hp + ")");
    }
}