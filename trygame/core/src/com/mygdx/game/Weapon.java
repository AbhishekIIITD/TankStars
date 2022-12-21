package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Weapon extends Shooter{
    private String Weapon;
    private Texture Weapon_Texture;
    private float Weapon_Damage;

    public String getWeapon() {
        return Weapon;
    }

    public void setWeapon(String weapon) {
        Weapon = weapon;
    }

    public Texture getWeapon_Texture() {
        return Weapon_Texture;
    }

    public void setWeapon_Texture(Texture weapon_Texture) {
        Weapon_Texture = weapon_Texture;
    }

    public float getWeapon_Damage() {
        return Weapon_Damage;
    }

    public void setWeapon_Damage(float weapon_Damage) {
        Weapon_Damage = weapon_Damage;
    }
}
