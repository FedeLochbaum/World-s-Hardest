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
            Vector2 pos = entity.getPhysicPosition();
            entity.setPosition(pos.x * width, pos.y * height);
        }
    }

}
