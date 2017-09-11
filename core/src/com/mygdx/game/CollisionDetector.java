package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.entities.Entity;

import java.util.ArrayList;
import java.util.List;


public class CollisionDetector {

    private static List<Entity> actors;

    public static void setEntities(List<Entity> acs){
        actors = acs;
    }

    public static List<Entity> entitiesCollidingWith(Actor actor) {
        List<Entity> res = new ArrayList<Entity>();

        for (Entity i: actors) {
            if(actor != i && isCollider((Entity)actor,(Entity)i))
                res.add(i);
        }
        return res;
    }

    private static boolean isCollider(Entity ac1, Entity ac2){
        return ac1.getBounds().overlaps(ac2.getBounds());
    }

}
