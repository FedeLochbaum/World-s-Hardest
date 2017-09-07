package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.CollisionDetector;

import static com.mygdx.game.Constants.PLAYER_SPEED;

public class PlayerEntity extends Entity {

    private boolean alive = true;

    private int coins = 0;

    public PlayerEntity(Texture textureE, Vector2 pos, Vector2 size) {
        super(textureE, pos, size);
        setName("Player");
    }

    @Override
    public void act(float delta) {
        if (alive) {
            movementCheck(delta);
            collisionCheck();
        }
    }

    private void movementCheck(float delta) {

        if (Gdx.input.isTouched()) {

            Vector2 touch = new Vector2(Gdx.input.getX(), Gdx.input.getY());

            Vector2 sub = new Vector2(touch.x - getX(),  touch.y - getY());

            Vector2 newPosition = sub.nor().scl(delta).scl(PLAYER_SPEED);

            setPosition(getX() + newPosition.x, (getY() + ( - newPosition.y)));//newPosition.x, newPosition.y);
        }
    }

    private void collisionCheck(){
        Array<Actor> actors = CollisionDetector.entitiesCollidingWith(this);

        for (Actor actor: actors) {
            switch (actor.getName()){
                case "Enemy":
                    alive = false;
                    break;
                case "Coin":
                    coins++;
                    actor.remove();
                    break;
                default:
                    break;
            }
        }

    }

    public void detach() {}

    public boolean isAlive() {
        return alive;
    }

}
