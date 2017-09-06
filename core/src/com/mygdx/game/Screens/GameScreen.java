package com.mygdx.game.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.Game;
import com.mygdx.game.TouchPad;
import com.mygdx.game.entities.CoinEntity;
import com.mygdx.game.entities.EnemyEntity;
import com.mygdx.game.entities.PlayerEntity;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends MainScreen {

    Stage stage;

    World world;

    private Music music;

    List<EnemyEntity> enemyList;

    List<CoinEntity> coinList;

    protected TouchPad touchPad;

    PlayerEntity player;

    public GameScreen(final Game game) {
        super(game);

        music = game.getManager().get("audio/song.ogg");

        stage = new Stage(new FillViewport(640, 360));
        world = new World(new Vector2(0, 0), true);

        enemyList = new ArrayList<EnemyEntity>();

        coinList = new ArrayList<CoinEntity>();

        world.setContactListener(new ContactListener() {

            private boolean areCollided(Contact contact, Object userA, Object userB){
                return (contact.getFixtureA().getUserData().equals(userA) && contact.getFixtureB().getUserData().equals(userB)
                        || contact.getFixtureA().getUserData().equals(userB) && contact.getFixtureB().getUserData().equals(userA));
            }

            @Override
            public void beginContact(Contact contact) {

                if (areCollided(contact, "player", "enemy")){
                    if (player.isAlive()) {
                        player.setAlive(false);
                        //music.stop();

                        stage.addAction(
                                Actions.sequence(
                                        Actions.run(new Runnable() {
                                            @Override
                                            public void run() {
                                                game.gameOver();
                                            }
                                        })
                                )
                        );
                    }
                } else if (areCollided(contact, "player", "coin")) {
                    if (contact.getFixtureA().getUserData().equals("coin")){
                    } else contact.getFixtureB().getShape().dispose();
                }
            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.5f,0.8f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        stage.act();
        world.step(delta, 6, 2);
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        world.dispose();
    }

}
