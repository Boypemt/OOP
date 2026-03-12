package com.rpg.lab01;

public abstract class Character implements Destructible {
    protected String name;
    protected String characterClass;
    protected int level;
    protected int currentHP;
    protected int maxHP;
    protected int damage;
    protected int defense;
    protected Weapon weapon;
    private Attack attackBehavior;

    public Character(String name, int level, int maxHP, int damage, int defense, Weapon weapon, String characterClass) {
        this.name = name;
        this.level = level;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.damage = damage;
        this.defense = defense;
        this.weapon = weapon;
        this.characterClass = characterClass;
        this.attackBehavior = new BaseAttack();
    }

    public int getHealthPoints() {
        return currentHP;
    }

    public int getMaxHealthPoints() {
        return maxHP;
    }

    public void setHealthPoints(int healthPoints) {
        // ตรวจสอบไม่ให้เลือดเกินค่าสูงสุด หรือต่ำกว่า 0
        this.currentHP = Math.max(0, Math.min(maxHP, healthPoints));
    }


    public void setAttack(Attack newAttack) {
        this.attackBehavior = newAttack;
    }

    public Attack getAttack() {
        return attackBehavior;
    }

    public void attack(Destructible target) {
        if (this.isDestroyed()) {
            System.out.println(name + " is fainted and cannot attack!");
            return;
        }
        attackBehavior.attack(this, target);
    }

    public String getName() { return name; }
    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }
    public Weapon getWeapon() { return weapon; }

    @Override
    public boolean isDestroyed() { return currentHP <= 0; }

    @Override
    public void takeDamage(int amount) {
        int finalDamage = Math.max(0, amount - this.defense);
        this.currentHP = Math.max(0, this.currentHP - finalDamage);
        System.out.println(" 💥 Actual Damage Taken by " + name + ": " + finalDamage);
        System.out.println(" ❤️ HP: " + currentHP + "/" + maxHP);
    }

    public boolean isAlive() { return currentHP > 0; }

    public void displayCharacterDetails() {
        String status = isAlive() ? "Active" : "Fainted";
        System.out.println("\n--- " + name.toUpperCase() + " (" + characterClass.toUpperCase() + ") ---");
        System.out.println(" Status:         " + status);
        System.out.println(" Health Points:  " + currentHP + "/" + maxHP);
        System.out.println(" Weapon:         " + weapon.getName());
    }

    public void receiveHeal(int amount) {
        if (!isAlive()) return; // ถ้าตายแล้วฟื้นฟูไม่ได้

        int newHP = Math.min(maxHP, currentHP + amount);
        int actualHeal = newHP - currentHP;

        setHealthPoints(newHP);

        System.out.println(" ✨ " + name + " restored " + actualHeal + " HP! (Current HP: " + currentHP + "/" + maxHP + ")");
    }
}