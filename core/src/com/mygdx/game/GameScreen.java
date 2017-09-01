package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.entities.LevelEntity;
import com.mygdx.game.entities.PlayerEntity;

public class GameScreen extends MainScreen {

    private Stage stage;

    private World world;

    private PlayerEntity player;

    private LevelEntity lvl;

    //private EnemyEntity enemy;

    private Music music;

    public GameScreen(final Game game) {
        super(game);

        music = game.getManager().get("audio/song.ogg");

        stage = new Stage(new FillViewport(640, 360));
        world = new World(new Vector2(0, 0), true);

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
                                        Actions.delay(1.5f),
                                        Actions.run(new Runnable() {
                                            @Override
                                            public void run() {
                                                game.gameOver();
                                            }
                                        })
                                )
                        );
                    }
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
    public void show() {
        Texture playerTexture = getMainGame().getManager().get("player.png");
        Texture lvlTexture = getMainGame().getManager().get("level1.png");

        player = new PlayerEntity(world, playerTexture, new Vector2(3.5f,5.5f));

        lvl  = new LevelEntity(world, lvlTexture);

        stage.addActor(lvl);
        stage.addActor(player);


        //music.setVolume(0.75f);
        //music.play();
    }

    @Override
    public void hide() {
        player.detach();
        player.remove();

        lvl.detach();
        lvl.remove();

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
