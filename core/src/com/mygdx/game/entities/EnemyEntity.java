package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.CollisionDetector;

import java.util.List;

public class EnemyEntity extends Entity {

    public EnemyEntity(Texture textureE, Vector2 pos, Vector2 size) {
        super(textureE, pos, size);
        setName("Enemy");
    }

    public void detach(){
    }

    @Override
    public void contactWith(PlayerEntity playerEntity) {
        playerEntity.die();
    }

    @Override
    public void act(float delta) {
        collisionCheck();
    }

    private void collisionCheck(){
        List<Entity> actors = CollisionDetector.entitiesCollidingWith(this);

        for (Entity actor: actors) {
            actor.contactWith(this);
        }
    }
}
