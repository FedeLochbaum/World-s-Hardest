package com.mygdx.game.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.Game;
import com.mygdx.game.entities.BlockEntity;
import com.mygdx.game.entities.CoinEntity;
import com.mygdx.game.entities.EnemyEntity;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.PlayerEntity;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends MainScreen {

    Stage stage;

    Music music;

    List<Entity> entities;

    PlayerEntity player;

    public GameScreen(final Game game) {
        super(game);

        music = game.getManager().get("audio/song.ogg");

        stage = new Stage(new FillViewport(640, 360));

        entities = new ArrayList<Entity>();
    }

    void renderMapWithPixmap(Pixmap pixmap) {
        Texture playerTexture = getMainGame().getManager().get("player.png");
        Texture enemyTexture = getMainGame().getManager().get("enemy.png");
        Texture coinTexture = getMainGame().getManager().get("coin.png");
        Texture blockTexture = getMainGame().getManager().get("blackBox.png");

        int width = pixmap.getWidth();
        int height = pixmap.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = pixmap.getPixel(x, y);
                Vector2 position = new Vector2((stage.getWidth() * x) / width,(stage.getHeight() * y) / height);
                switch (pixel) {
                    case -824246273:
                        //Exterior
                        break;
                    case -1660965377:
                        //suelo verde
                        break;
                    case -1:
                        //suelo blanco de juego
                        break;
                    case -140769025:
                        //meta
                        break;
                    case 255:
                        entities.add(new BlockEntity(blockTexture, position, new Vector2(8,8)));
                        break;
                    case 279280639:
                        player = new PlayerEntity(playerTexture, position, new Vector2(15,15));
                        break;
                    case -16776961:
                        entities.add(new EnemyEntity(enemyTexture, position, new Vector2(15,15)));
                        break;
                    case -403223809:
                        entities.add(new CoinEntity(coinTexture, position, new Vector2(15,15)));
                        break;
                    default:
                        break;
                }
            }
        }
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.5f,0.8f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(!player.isAlive())
            getMainGame().gameOver();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
