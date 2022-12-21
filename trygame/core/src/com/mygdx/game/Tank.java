package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.ArrayList;

public class Tank extends Sprite {
    public static World world;
    public Body b2body;

    private float x_Coordinates;
    private float y_Coordinates;

    private Texture texture;
    private float Fuel;
    private float HealthRating;
    private float DamageRating ;
    private float DamageConsumed;
    private ArrayList<Weapon> All_Weapon;
    private Shooter Cannon;
    private float Tank_Width;
    private float Tank_Height;

    public Tank(Texture texture, float fuel, float healthRating, float damageRating, float damageConsumed, World world,float x_Coordinates,float y_Coordinates) {
        this.world = world;
        this.texture = texture;
        Fuel = fuel;
        HealthRating = healthRating;
        DamageRating = damageRating;
        DamageConsumed = damageConsumed;
        this.Tank_Width = 50;
        this.Tank_Height = 25;
        this.Cannon = new Shooter();
        this.x_Coordinates = x_Coordinates;
        this.y_Coordinates = y_Coordinates;
        DefineTank();
    }

    public void DefineTank(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(x_Coordinates / TestGame.PPM1,y_Coordinates / TestGame.PPM1);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Tank_Width,Tank_Height,new Vector2(Tank_Width/2,Tank_Height/2),0);
        fdef.shape = shape;
        b2body.createFixture(fdef);
        shape.dispose();
    }

    public float getTank_Width() {
        return Tank_Width;
    }

    public void setTank_Width(float tank_Width) {
        Tank_Width = tank_Width;
    }

    public float getTank_Height() {
        return Tank_Height;
    }

    public void setTank_Height(float tank_Height) {
        Tank_Height = tank_Height;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Body getB2body() {
        return b2body;
    }

    public void setB2body(Body b2body) {
        this.b2body = b2body;
    }

    public float getX_Coordinates() {
        return x_Coordinates;
    }

    public void setX_Coordinates(float x_Coordinates) {
        this.x_Coordinates = x_Coordinates;
    }

    public float getY_Coordinates() {
        return y_Coordinates;
    }

    public void setY_Coordinates(float y_Coordinates) {
        this.y_Coordinates = y_Coordinates;
    }

    public void setFuel(float fuel) {
        Fuel = fuel;
    }

    public void setHealthRating(float healthRating) {
        HealthRating = healthRating;
    }

    public void setDamageRating(float damageRating) {
        DamageRating = damageRating;
    }

    public void setDamageConsumed(float damageConsumed) {
        DamageConsumed = damageConsumed;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getFuel() {
        return Fuel;
    }

    public float getHealthRating() {
        return HealthRating;
    }

    public float getDamageRating() {
        return DamageRating;
    }

    public float getDamageConsumed() {
        return DamageConsumed;
    }

    public ArrayList<Weapon> getAll_Weapon() {
        return All_Weapon;
    }

    public void setAll_Weapon(ArrayList<Weapon> all_Weapon) {
        All_Weapon = all_Weapon;
    }

    public Shooter getCannon() {
        return Cannon;
    }

    public void setCannon(Shooter cannon) {
        Cannon = cannon;
    }

    public void Shoot() {

    }

    public void MoveLeft() {

    }

    public void MoveCannonRight() {

    }

    public void MoveCannonLeft() {

    }

    public void MoveRight() {

    }

    public boolean IsEmptyFuel() {
        return false;
    }

    public boolean IsAlive() {
        return false;
    }
}
