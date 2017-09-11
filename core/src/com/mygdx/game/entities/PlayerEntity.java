package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.CollisionDetector;

import java.util.List;

public class PlayerEntity extends Entity {

    private boolean alive = true;

    private float speed = 100f;

    private int coins = 0;

    public PlayerEntity(Texture textureE, Vector2 pos, Vector2 size) {
        super(textureE, pos, size);
        setName("Player");
    }

    public void die(){
        alive = false;
    }

    @Override
    public void act(float delta) {
        if (alive) {
            movementCheck(delta);
            collisionCheck();
        }
    }

    private void movementCheck(float delta) {
        if (speed == 0f)
            speed = 100f;

        if (Gdx.input.isTouched()) {

            Vector2 touch = new Vector2(Gdx.input.getX(), Gdx.input.getY());

            Vector2 sub = new Vector2(touch.x - getX(),  touch.y - getY());

            Vector2 newPosition = sub.nor().scl(delta).scl(speed);

            setPosition(getX() + newPosition.x, (getY() + ( - newPosition.y)));//newPosition.x, newPosition.y);
        }


    }

    private void collisionCheck(){
        List<Entity> actors = CollisionDetector.entitiesCollidingWith(this);

        for (Entity actor: actors) {
            actor.contactWith(this);
        }
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void detach() {}

    public boolean isAlive() {
        return alive;
    }

}
