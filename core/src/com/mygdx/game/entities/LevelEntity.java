package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class LevelEntity extends Entity {

    public LevelEntity(Texture lvlTexture, Vector2 pos, Vector2 size) {
        super(lvlTexture, pos, size);
        setName("LevelEntity");
    }

    public void detach() {
    }
}
