package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.entities.Entity;
import java.util.List;

public class PhysicEngine {

    private CollisionDetector detector = new CollisionDetector();

    private List<Entity> entities;

    private  Entity player;

    public void setEntities(List<Entity> entitiesS,Entity playerS) {
        entities = entitiesS;
        player = playerS;
    }

    public void update(float delta){
        detectInput();
        detectCollisions();
        updatePositions(delta);
    }

    private void detectInput() {
        if (Gdx.input.isTouched()) {

            Vector2 touch = new Vector2(Gdx.input.getX(), Gdx.input.getY());

            Vector2 sub = new Vector2(touch.x - player.getPhysicPosition().x,  touch.y - player.getPhysicPosition().y);

            Vector2 newSpeed = sub.nor().scl(player.getSpeed());

            player.setSpeed(newSpeed);
        }
    }


    private void detectCollisions() {
        for (Entity entity : entities){
            for (Entity coll : detector.entitiesCollidingWith(entities, entity)){
                coll.contactWith(entity);
            }
        }
    }

    private void updatePositions(float delta) {
        for (Entity entity : entities){
            entity.updatePosition(delta);
        }
    }

}
