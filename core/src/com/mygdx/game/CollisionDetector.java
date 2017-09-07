package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.entities.Entity;


public class CollisionDetector {

    private static Array<Actor> actors;

    public static void setEntities(Array<Actor> acs){
        actors = acs;
    }

    public static Array<Actor> entitiesCollidingWith(Actor actor) {
        Array<Actor> res = new Array<>();

        for (Actor i: actors) {
            if(actor != i && isCollider((Entity)actor,(Entity)i))
                res.add(i);
        }
        return res;
    }

    private static boolean isCollider(Entity ac1, Entity ac2){
        return ac1.getBounds().overlaps(ac2.getBounds());
    }

}
