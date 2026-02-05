package com.rpg.lab01;

public class Weapon {
    private String name;
    private String type;
    private int baseDamage;
    private String ability;

    public Weapon(String name, String type, int baseDamage, String ability){
        this.name = name;
        this.type = type;
        this.baseDamage = baseDamage;
        this.ability = ability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
    @Override
    public  String toString(){
        return  name + " (Type: " + type + ", Damage: " + baseDamage + ", Ability: " + ability + ")";
    }
}
