package com.rpg.lab01;

public interface Destructible {
    void takeDamage(int amount);
    boolean isDestroyed();
    String getName();
}