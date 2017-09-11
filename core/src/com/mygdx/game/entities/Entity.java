package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Entity extends Actor {

    private Texture texture;

    private Rectangle bounds;

    public Entity(Texture textureE, Vector2 pos, Vector2 size) {
        texture = textureE;
        create(pos, size);
        bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    private void create(Vector2 pos, Vector2 size) {
        setPosition(pos.x, pos.y);
        setSize(size.x,size.y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(getX(), getY());
        bounds.setPosition(getX(), getY());
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public void contactWith(EnemyEntity enemyEntity){}

    public void contactWith(PlayerEntity playerEntity){}

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }
}
