package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import static com.mygdx.game.Constants.PIXELS_IN_METER;

public class CoinEntity extends Actor {

    private Texture texture;

    private World world;

    private Body body;

    private Fixture fixture;

    public CoinEntity (World worldD, Texture textureE, Vector2 pos) {
        world = worldD;
        texture = textureE;
        createCoin(pos);
    }

    private void createCoin(Vector2 pos) {
        BodyDef def = new BodyDef();
        def.position.set(pos);
        def.type = BodyDef.BodyType.StaticBody;
        body = world.createBody(def);

        CircleShape ball = new CircleShape();
        ball.setRadius(0.2f);
        fixture = body.createFixture(ball, 3);
        fixture.setUserData("coin");
        ball.dispose();

        setSize(20f, 20f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition((body.getPosition().x - 0.2f) * PIXELS_IN_METER,
                (body.getPosition().y - 0.2f) * PIXELS_IN_METER);

        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public void detach(){
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }

    public void die(){
        addAction(Actions.removeActor());
    }

    @Override
    public void act(float delta) {}


}
