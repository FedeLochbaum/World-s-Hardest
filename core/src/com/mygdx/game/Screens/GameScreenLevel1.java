package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.CollisionDetector;
import com.mygdx.game.Game;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.LevelEntity;

public class GameScreenLevel1 extends com.mygdx.game.Screens.GameScreen {

    private LevelEntity lvl;

    public GameScreenLevel1(Game game) {
        super(game);
    }

    @Override
    public void show() {

        Pixmap pixmap = new Pixmap(Gdx.files.internal("bitmaps/level1.bmp"));

        renderMapWithPixmap(pixmap);

        stage.addActor(player);

        for (Entity e : entities) {
            stage.addActor(e);
        }

        CollisionDetector.setEntities(entities);

        music.setVolume(0.75f);
        music.play();
    }



    @Override
    public void hide() {
        player.detach();
        player.remove();

        for (Entity e : entities) {
            e.remove();
        }

    }


}
