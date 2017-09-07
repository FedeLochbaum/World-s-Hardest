package com.mygdx.game.Screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.CollisionDetector;
import com.mygdx.game.Game;
import com.mygdx.game.entities.CoinEntity;
import com.mygdx.game.entities.EnemyEntity;
import com.mygdx.game.entities.LevelEntity;
import com.mygdx.game.entities.PlayerEntity;

public class GameScreenLevel1 extends com.mygdx.game.Screens.GameScreen {

    private LevelEntity lvl;

    public GameScreenLevel1(Game game) {
        super(game);
    }

    @Override
    public void show() {
        Texture playerTexture = getMainGame().getManager().get("player.png");
        Texture lvlTexture = getMainGame().getManager().get("level1.png");
        Texture enemyTexture = getMainGame().getManager().get("enemy.png");
        Texture coinTexture = getMainGame().getManager().get("coin.png");

        player = new PlayerEntity(playerTexture, new Vector2(200f,200f), new Vector2(20,20));

        EnemyEntity enemy = new EnemyEntity(enemyTexture, new Vector2(300f,180f), new Vector2(20,20));

        CoinEntity coin = new CoinEntity(coinTexture, new Vector2(250f,180f), new Vector2(20,20));

        enemyList.add(enemy);

        coinList.add(coin);

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
