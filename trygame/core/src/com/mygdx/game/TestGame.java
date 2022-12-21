package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Screens.PlayScreen;

public class TestGame extends Game {
	public static final int V_WIDTH = 960;
	public static final int V_HEIGHT = 540;
	public static final int PPM = 32;
	public static final int PPM1 = 1;
	private SpriteBatch batch;
	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		PlayScreen p1 = new PlayScreen(this);
		setScreen(p1);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		this.getBatch().dispose();
	}
}
