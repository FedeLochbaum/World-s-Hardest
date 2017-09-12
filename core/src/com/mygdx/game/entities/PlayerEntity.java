package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class PlayerEntity extends Entity {

    private boolean alive = true;

    private int coins = 0;

    public PlayerEntity(Texture textureE, Vector2 pos, Vector2 size, Vector2 speedV) {
        super(textureE, pos, size, speedV);
        setName("Player");
    }

    public void die(){
        alive = false;
    }

    @Override
    public void act(float delta) {
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void detach() {}

    public boolean isAlive() {
        return alive;
    }

}
