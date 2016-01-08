package com.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.core.graphics.ScreenManager;
import com.core.utils.Point;

/**
 * Offsets the Gdx.input.getX(), to fit the camera.
 * 
 * @author Pontus Wirsching
 * 
 */
public class Input implements InputProcessor {

	static float x, y;
	
	static boolean touched = false;
	
	private static SwipeInterface s;
	
	public static void setSwipeInterface(SwipeInterface ss) {
		s = ss;
	}

	public static void update() {

		Vector3 input = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
		ScreenManager.getSelected().camera.unproject(input);

		x = input.x;
		y = input.y;

	}

	public static float getX() {
		return x;
	}

	public static float getY() {
		return y;
	}
	
	public static boolean isTouched() {
		return touched;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	static long touchTime = 0;
	long start = 0;
	long end = 0;

	public static Point startPos = new Point();
	public static Point endPos = new Point();
	static Vector2 swipe = new Vector2();

	/**
	 * Returns a Vector of the last swipe. Combine this with the touch position
	 * to get an exact swipe.
	 */
	public static Vector2 getSwipe() {
		return swipe;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		touchTime = 0;
		start = System.currentTimeMillis();
		touched = true;
		startPos = new Point((int) getX(), (int) getY());
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		endPos = new Point((int) getX(), (int) getY());
		swipe = new Vector2(endPos.x - startPos.x, endPos.y - startPos.y);
		if (s != null){
			s.swiped(swipe);
		}
		touched = false;
		end = System.currentTimeMillis();
		touchTime = end - start;
		return false;
	}

	public static boolean lastTouchWas(long ms) {
		if (touchTime > ms) {
			touchTime = 0;
			return true;
		} else
			return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
