package com.rpg.lab01;

import java.util.ArrayList;
import java.util.List;

public class RPG_Game_Character {

    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("  SCENARIO 4: INTERFACES - DESTRUCTIBLE & CONSUMABLE");
        System.out.println("=".repeat(70));

        // ==================== CREATE WEAPONS ====================
        System.out.println("\n[STEP 1] Creating Weapons...");
        Weapon swordWeapon = new Weapon("Excalibur", "Melee", 30, "Slash Attack");
        Weapon staffWeapon = new Weapon("Staff of Mysticism", "Magic", 20, "Spell Cast");
        Weapon bowWeapon = new Weapon("Bow of Elven Make", "Ranged", 18, "Precise Shot");

        // ==================== CREATE CHARACTERS ====================
        System.out.println("\n[STEP 2] Creating Characters...");
        Warrior warrior = new Warrior("Aragorn", 12, 2000, 25, 8, 15, swordWeapon);
        Mage mage = new Mage("Gandalf", 14, 1200, 20, 5, 150, staffWeapon);
        Archer archer = new Archer("Legolas", 13, 1400, 22, 6, 85, bowWeapon);

        // ==================== CREATE DESTRUCTIBLE OBJECTS (NON-CHARACTER)
        System.out.println("\n[STEP 3] Creating Destructible Objects (Non-Character)...");
        WoodenBox treasureBox = new WoodenBox("Treasure Chest", 300, true, "1000 Gold Coins");
        WoodenBox crate = new WoodenBox("Supply Crate", 150, false, "Medicine & Supplies");

        // ==================== CREATE CONSUMABLE ITEMS ====================
        System.out.println("\n[STEP 4] Creating Consumable Items...");
        HealthPotion potionGreater = new HealthPotion("Greater Health Potion", 100, 3);
        HealthPotion potionMinor = new HealthPotion("Minor Health Potion", 10, 10);

        // ==================== DISPLAY INITIAL STATUS ====================
        System.out.println("\n[STEP 5] Initial Status:");
        System.out.println("\n--- CHARACTERS (Destructible) ---");
        warrior.displayCharacterDetails();
        mage.displayCharacterDetails();
        archer.displayCharacterDetails();

        System.out.println("\n--- DESTRUCTIBLE OBJECTS (Non-Character) ---");
        treasureBox.displayBoxDetails();
        crate.displayBoxDetails();

        System.out.println("\n--- CONSUMABLE ITEMS ---");
        potionGreater.displayPotionDetails();
        potionMinor.displayPotionDetails();

        // ==================== DEMONSTRATE INTERFACE POLYMORPHISM: DESTRUCTIBLE
        // ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println("  [STEP 6] INTERFACE POLYMORPHISM: Destructible Objects");
        System.out.println("=".repeat(70));
        System.out.println("\n✨ KEY CONCEPT: Warriors can attack BOTH Characters and Objects!");
        System.out.println("   Both implement Destructible, but DON'T share inheritance.\n");

        // Create a list of destructible items (both Characters and non-Characters!)
        List<Destructible> battleTargets = new ArrayList<>();
        battleTargets.add(mage); // Character is Destructible
        battleTargets.add(warrior); // Another Character is Destructible
        battleTargets.add(treasureBox); // WoodenBox is Destructible (NOT a Character!)
        battleTargets.add(crate); // Another WoodenBox

        System.out.println("--- Aragorn and Mage attacks each other (Character - Destructible) -- ");
        for (int i = 0; i < 5; i++) {
            warrior.attack(battleTargets.get(1));
            mage.attack(battleTargets.get(0));
        }

        System.out.println("\n--- Aragorn continues attacking the Treasure Chest ---");
        while (!battleTargets.get(2).isDestroyed()) {
            warrior.attack(battleTargets.get(2));
        }

        System.out.println("\n--- Legolas attacks a Supply Crate (Object - Destructible) ---");
        archer.attack(battleTargets.get(3));

        // ==================== SHOW STATUS AFTER ATTACKS ====================
        System.out.println("\n[STEP 7] Status After Combat:");
        System.out.println("\n--- Mage Status ---");
        mage.displayCharacterDetails();

        System.out.println("\n--- Destructible Objects Status ---");
        treasureBox.displayBoxDetails();
        crate.displayBoxDetails();

        // ==================== DEMONSTRATE INTERFACE POLYMORPHISM: CONSUMABLE
        // ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println("  [STEP 8] INTERFACE POLYMORPHISM: Consumable Items");
        System.out.println("=".repeat(70));
        System.out.println("\n✨ KEY CONCEPT: Different consumable items, same 'use' method!\n");

        // Create a list of consumable items
        List<Consumable> inventory = new ArrayList<>();
        inventory.add(potionGreater);
        inventory.add(potionMinor);

        System.out.println("--- Gandalf uses a Greater Health Potion ---");
        inventory.get(0).use(mage);

        System.out.println("\n--- Gandalf uses a Minor Health Potion ---");
        inventory.get(1).use(mage);

        // ==================== OPEN DESTROYED BOX ====================
        System.out.println("\n[STEP 9] Breaking Open Boxes:");
        System.out.println("\n--- Breaking open the Treasure Chest ---");
        treasureBox.breakOpen();

        System.out.println("\n--- Attempting to break the Supply Crate (still intact) ---");
        crate.breakOpen();
    }
} 