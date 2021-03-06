package com.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.core.game.Game;
import com.core.game.GameOver;
import com.core.graphics.ScreenManager;
import com.core.resources.Resources;

/**
 *
 * @author Pontus Wirsching
 * @author Austin Wrenn
 */
public class SpacePanda implements ApplicationListener {

	public static final float SCALE = 4;
	public static final float WIDTH = 1080 / SCALE; // This won\t change during the game so we use this.
	public static final float HEIGHT = 1920 / SCALE;
	
	public int tester = 0;

	public static Rectangle screenBounds = new Rectangle();
	
	public static enum OS {
		WINDOWS, ANDROID, IOS
	}

	public static OS currentOS = OS.WINDOWS;

	public static boolean RUN_GAME = true;
	
	@Override
	public void create() {
		
		Resources.load();

		ScreenManager.add(new GameOver());
		ScreenManager.add(new Game());

		//just showing you the screen ive made
		ScreenManager.setSelected("GAME");
		
		System.out.println(Game.getScore());
		

//		Gdx.input.setInputProcessor(new Input());
	}


	@Override
	public void render() {
		Input.update();
		ScreenManager.render(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void resize(int width, int height) {
		ScreenManager.resize(width, height);
		float w = ScreenManager.getSelected().camera.viewportWidth;
		float h = ScreenManager.getSelected().camera.viewportHeight;
		screenBounds = new Rectangle(-w / 2, -h / 2, w, h);
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
