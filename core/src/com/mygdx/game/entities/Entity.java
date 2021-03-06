package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Entity extends Actor {

    private Texture texture;

    private Rectangle bounds;

    private Vector2 physicPosition;

    private Vector2 speed;

    public Entity(Texture textureE, Vector2 pos, Vector2 size, Vector2 speedV) {
        speed = speedV;
        physicPosition = pos;

        texture = textureE;

        setSize(size.x,size.y);
        bounds = new Rectangle(pos.x, pos.y, getWidth(), getHeight());
    }

    public void updatePosition(float delta){
        physicPosition = physicPosition.add(speed).scl(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        bounds.setPosition(physicPosition);

        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public void contactWith(EnemyEntity enemyEntity){}

    public void contactWith(PlayerEntity playerEntity){}

    public void contactWith(Entity entity){}

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

    public Vector2 getPhysicPosition() {
        return physicPosition;
    }

    public void setPhysicPosition(Vector2 physicPosition) {
        this.physicPosition = physicPosition;
    }

    public Vector2 getSpeed() {
        return speed;
    }

    public void setSpeed(Vector2 speed) {
        this.speed = speed;
    }
}
