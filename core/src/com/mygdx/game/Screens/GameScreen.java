package com.mygdx.game.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.Game;
import com.mygdx.game.entities.CoinEntity;
import com.mygdx.game.entities.EnemyEntity;
import com.mygdx.game.entities.PlayerEntity;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends MainScreen {

    Stage stage;

    Music music;

    List<EnemyEntity> enemyList;

    List<CoinEntity> coinList;

    private Skin skin;


    PlayerEntity player;

    public GameScreen(final Game game) {
        super(game);

        music = game.getManager().get("audio/song.ogg");

        skin = new Skin(Gdx.files.internal("skin2/uiskin.json"));

        stage = new Stage(new FillViewport(640, 360));

        enemyList = new ArrayList<EnemyEntity>();

        coinList = new ArrayList<CoinEntity>();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.5f,0.8f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
