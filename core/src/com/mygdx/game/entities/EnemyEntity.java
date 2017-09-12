package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class EnemyEntity extends Entity {

    public EnemyEntity(Texture textureE, Vector2 pos, Vector2 size, Vector2 speedV) {
        super(textureE, pos, size, speedV);
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
    }

}
