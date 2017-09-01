package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.security.Key;

import static com.mygdx.game.entities.Constants.IMPULSE_JUMP;
import static com.mygdx.game.entities.Constants.PIXELS_IN_METER;
import static com.mygdx.game.entities.Constants.PLAYER_SPEED;

public class PlayerEntity extends Actor {

    private Texture texture;

    private World world;

    private Body body;

    private Fixture fixture;

    private boolean alive = true;


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



        if (alive) {
            checkForMovements();
        }

    }

    private void checkForMovements() {

        boolean upTouched = Gdx.input.isTouched() && Gdx.input.getY() < Gdx.graphics.getHeight() / 2 ;
        if (upTouched)
            body.setLinearVelocity(0, PLAYER_SPEED);

        boolean downTouched = Gdx.input.isTouched() && Gdx.input.getY() > Gdx.graphics.getHeight() / 2 ;
        if (downTouched)
            body.setLinearVelocity(0, -PLAYER_SPEED);

        boolean leftTouched = Gdx.input.isTouched() && Gdx.input.getX() < Gdx.graphics.getWidth() / 3;
        if (leftTouched)
            body.setLinearVelocity(-PLAYER_SPEED, 0);

        boolean rightTouched = Gdx.input.isTouched() && Gdx.input.getX() > Gdx.graphics.getWidth() * 2 / 3;
        if (rightTouched)
            body.setLinearVelocity(PLAYER_SPEED, 0);

        if(!upTouched && !downTouched && !leftTouched && !rightTouched)
            body.setLinearVelocity(0, 0);
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


}
