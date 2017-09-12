package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;


public class BlockEntity extends Entity {

    public BlockEntity (Texture textureE, Vector2 pos, Vector2 size, Vector2 speedV) {
        super(textureE, pos, size, speedV);
        setName("Block");
    }

    public void detach(){
    }

    @Override
    public void act(float delta) {
    }

    @Override
    public void contactWith(PlayerEntity playerEntity) {
        //playerEntity.setSpeed(0f);
    }

    @Override
    public void contactWith(EnemyEntity playerEntity) {
        playerEntity.setPosition(playerEntity.getX(), playerEntity.getY());
    }

    public void die(){
        addAction(Actions.removeActor());
    }

}
