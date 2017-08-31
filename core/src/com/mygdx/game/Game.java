package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

public class Game extends com.badlogic.gdx.Game {

	private AssetManager manager;

	@Override
	public void create() {
		manager = new AssetManager();

		manager.load("menu.jpg", Texture.class);
		manager.load("level1.png", Texture.class);
		manager.load("player.png", Texture.class);
		manager.load("audio/song.ogg", Music.class);

		loadScreen();
	}

	public AssetManager getManager() {
		return manager;
	}

	public void startGame(){
		setScreen(new GameScreen(this));
	}

	public void gameOver(){
		setScreen(new GameOverScreen(this));
	}

	public void menu(){
		setScreen(new MenuScreen(this));
	}

	public void loadScreen(){
		setScreen(new LoadingScreen(this));
	}

	public void startBoard(){
		setScreen(new BoardLvls(this));
	}
}
