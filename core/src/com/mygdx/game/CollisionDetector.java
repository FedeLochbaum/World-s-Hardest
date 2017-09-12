package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;
import java.util.List;


public class CollisionDetector {

    public List<Entity> entitiesCollidingWith(List<Entity> entities, Entity actor) {
        List<Entity> res = new ArrayList<>();

        for (Entity i: entities) {
            if(actor != i && isCollider(actor, i))
                res.add(i);
        }
        return res;
    }

    private boolean isCollider(Entity ac1, Entity ac2){
        return ac1.getBounds().overlaps(ac2.getBounds());
    }

}
