package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.CollisionDetector;
import com.mygdx.game.Game;
import com.mygdx.game.entities.CoinEntity;
import com.mygdx.game.entities.EnemyEntity;
import com.mygdx.game.entities.LevelEntity;

public class GameScreenLevel1 extends com.mygdx.game.Screens.GameScreen {

    private LevelEntity lvl;

    public GameScreenLevel1(Game game) {
        super(game);
    }

    @Override
    public void show() {
        Texture lvlTexture = getMainGame().getManager().get("level1.png");

        Pixmap pixmap = new Pixmap(Gdx.files.internal("bitmaps/level.bmp"));

        renderMapWithPixmap(pixmap);

        lvl  = new LevelEntity(lvlTexture, new Vector2(0,0), new Vector2(640,360));

        stage.addActor(lvl);

        stage.addActor(player);

        for (EnemyEntity e : enemyList) {
            stage.addActor(e);
        }

        for (CoinEntity c : coinList) {
            stage.addActor(c);
        }

        CollisionDetector.setEntities(stage.getActors());

        music.setVolume(0.75f);
        music.play();
    }



    @Override
    public void hide() {
        player.detach();
        player.remove();

        for (EnemyEntity e : enemyList) {
            e.remove();
        }

        for (CoinEntity c : coinList) {
            c.remove();
        }

        lvl.detach();
        lvl.remove();

    }


}
