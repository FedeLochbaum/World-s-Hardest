package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class LevelEntity extends Actor{

    private Texture texture;

    public LevelEntity(Texture lvlTexture) {
        texture = lvlTexture;
        createLevel();
    }

    private void createLevel() {
        setPosition(0, 0);
        setSize(640f, 380f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setPosition(getX(), getY());

        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public void detach() {
    }
}
