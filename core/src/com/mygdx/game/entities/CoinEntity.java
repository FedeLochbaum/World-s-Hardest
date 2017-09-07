package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class CoinEntity extends Actor {

    private Texture texture;

    public CoinEntity (Texture textureE, Vector2 pos) {
        texture = textureE;
        createCoin(pos);
    }

    private void createCoin(Vector2 pos) {
        setPosition(pos.x, pos.y);
        setSize(20f, 20f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(getX(), getY());
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public void detach(){
    }

    public void die(){
        addAction(Actions.removeActor());
    }

    @Override
    public void act(float delta) {}

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }


}
