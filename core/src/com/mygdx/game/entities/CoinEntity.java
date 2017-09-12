package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class CoinEntity extends Entity {

    public CoinEntity (Texture textureE, Vector2 pos, Vector2 size, Vector2 speedV) {
        super(textureE, pos, size, speedV);
        setName("Coin");
    }

    public void detach(){
    }

    @Override
    public void contactWith(PlayerEntity playerEntity) {
        playerEntity.setCoins(playerEntity.getCoins() + 1);
        remove();
    }

    @Override
    public void act(float delta) {}
}
