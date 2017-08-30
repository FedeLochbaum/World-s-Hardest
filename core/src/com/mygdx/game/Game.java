package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Game extends com.badlogic.gdx.Game {

	private AssetManager manager;

	@Override
	public void create() {
		manager = new AssetManager();

		manager.load("60.png", Texture.class);

		loadScreen();
	}

	public AssetManager getManager() {
		return manager;
	}

	public void startGame(){
		//setScreen(new GameScreen(this));
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
}
