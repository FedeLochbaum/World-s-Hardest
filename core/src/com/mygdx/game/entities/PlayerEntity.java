package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.mygdx.game.Constants;

import java.sql.Time;

import sun.rmi.runtime.Log;

import static com.mygdx.game.Constants.PIXELS_IN_METER;
import static com.mygdx.game.Constants.PLAYER_SPEED;

public class PlayerEntity extends Actor {

    private Texture texture;

    private World world;

    private Body body;

    private Fixture fixture;

    private boolean alive = true;

    private int coins = 0;

    public PlayerEntity(World worldD, Texture textureE, Vector2 pos) {
        world = worldD;
        texture = textureE;
        createPlayer(pos);
    }

    private void createPlayer(Vector2 pos) {
        BodyDef def = new BodyDef();
        def.position.set(pos);
        def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(def);

        PolygonShape box = new PolygonShape();
        box.setAsBox(0.2f, 0.2f);
        fixture = body.createFixture(box, 3);
        fixture.setUserData("player");
        box.dispose();

        setSize(20f, 20f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition((body.getPosition().x - 0.2f) * PIXELS_IN_METER,
                (body.getPosition().y - 0.2f) * PIXELS_IN_METER);

        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        if (alive)
            checkForMovements(delta);
        else body.setLinearVelocity(0,0);
    }

    private void checkForMovements(float delta) {

        if (Gdx.input.isTouched()) {
            Vector2 touch = new Vector2(Gdx.input.getX() / Constants.PIXELS_IN_METER, Gdx.input.getY() / Constants.PIXELS_IN_METER);

            Vector2 sub = new Vector2(touch.x - body.getPosition().x, touch.y - body.getPosition().y);
            Vector2 newPosition = sub.nor().scl(PLAYER_SPEED);

            body.setLinearVelocity(newPosition.x, newPosition.y);
            //setPosition(newPosition.x, newPosition.y);
        } else body.setLinearVelocity(0,0);
    }

    public void detach() {
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

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

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

}
