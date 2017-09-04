package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.mygdx.game.Constants.PIXELS_IN_METER;

public class LevelEntity extends Actor{

    private Texture texture;

    private World world;

    private Body body;

    private Fixture fixture;

    public LevelEntity(World worldD, Texture lvlTexture) {
        world = worldD;
        texture = lvlTexture;
        createLevel();
    }

    private void createLevel() {
        BodyDef def = new BodyDef();
        def.position.set(new Vector2(0f, 0f));
        def.type = BodyDef.BodyType.StaticBody;
        body = world.createBody(def);

        PolygonShape box = new PolygonShape();
        box.setAsBox(0.2f, 0.2f);
        fixture = body.createFixture(box, 3);
        fixture.setUserData("lvl");
        box.dispose();

        setSize(640f, 380f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition((body.getPosition().x - 0.2f) * PIXELS_IN_METER,
                (body.getPosition().y - 0.2f) * PIXELS_IN_METER);

        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public void detach() {
        body.destroyFixture(fixture);
        world.destroyBody(body);
    }
}
