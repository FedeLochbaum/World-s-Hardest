package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class CoinEntity extends Entity {

    public CoinEntity (Texture textureE, Vector2 pos, Vector2 size) {
        super(textureE, pos, size);
        setName("Coin");
    }

    public void detach(){
    }

    public void die(){
        addAction(Actions.removeActor());
    }

    @Override
    public void act(float delta) {}
}
