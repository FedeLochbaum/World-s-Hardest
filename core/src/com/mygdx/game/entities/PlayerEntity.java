package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Constants;

import static com.mygdx.game.Constants.PLAYER_SPEED;

public class PlayerEntity extends Actor {

    private Texture texture;

    private boolean alive = true;

    private int coins = 0;

    public PlayerEntity(Texture textureE, Vector2 pos) {
        texture = textureE;
        createPlayer(pos);
    }

    private void createPlayer(Vector2 pos) {
        setPosition(pos.x, pos.y);
        setSize(20f, 20f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(getX(), getY());

        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        if (alive)
            checkForMovements(delta);
    }

    private void checkForMovements(float delta) {

        if (Gdx.input.isTouched()) {

            Vector2 touch = new Vector2(Gdx.input.getX(), Gdx.input.getY());

            Vector2 sub = new Vector2(touch.x - getX(),  touch.y - getY());

            Vector2 newPosition = sub.nor().scl(delta).scl(PLAYER_SPEED);

            setPosition(getX() + newPosition.x, (getY() + ( - newPosition.y)));//newPosition.x, newPosition.y);
        }
    }

    public void detach() {}

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void addCoin(){
        coins++;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

}
