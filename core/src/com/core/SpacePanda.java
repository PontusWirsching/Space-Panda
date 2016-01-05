package com.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.core.game.Game;
import com.core.graphics.ScreenManager;

/**
 *
 * @author Pontus Wirsching
 * @author Austin Wrenn
 */
public class SpacePanda implements ApplicationListener {

	public static final float SCALE = 4;
	public static final float WIDTH = 1080 / SCALE;
	public static final float HEIGHT = 1920 / SCALE;

	public static enum OS {
		WINDOWS, ANDROID, IOS
	}

	public static OS currentOS = OS.WINDOWS;

	public static boolean RUN_GAME = true;
	
	@Override
	public void create() {

		ScreenManager.add(new Game());

		ScreenManager.setSelected("GAME");

//		Gdx.input.setInputProcessor(new Input());
	}


	@Override
	public void render() {
//		Input.update();
		ScreenManager.render(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void resize(int width, int height) {
		ScreenManager.resize(width, height);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

}
