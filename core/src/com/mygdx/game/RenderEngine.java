package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.entities.Entity;

import java.util.List;

public class RenderEngine {

    private List<Entity> entities;

    public void setEntities(List<Entity> entitiesS) {
        entities = entitiesS;
    }

    public void render(float width, float height) {
        for (Entity entity : entities){
            Vector2 physicPos = entity.getPhysicPosition();
            entity.setPosition(physicPos.x * width, physicPos.y * height);
        }
    }

}
