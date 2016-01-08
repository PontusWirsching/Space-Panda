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
		// This method is looping when we hold our finger / mouse down, using that boolean it will set the start and then prevent the if statment to run again.
		touchTime = 0;
		start = System.currentTimeMillis();

		startPos = new Point((int) getX(), (int) getY());
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// nevermind, wait shouldn't we be setting the endPos or the startPos to the value screenX and screenY?
		// good question but no, the getX() and getY() is custom written to integrate the touch with the camera.
		// The screenX and screenY works in some cases but will get weird when you scale the window etc.
		// what is the int button? What button you pressed.
		endPos = new Point((int) getX(), (int) getY());
		swipe = new Vector2(endPos.x - startPos.x, endPos.y - startPos.y);
		if (s != null){
			s.swiped(swipe);
		}
		end = System.currentTimeMillis();
		touchTime = end - start;
		return false;
	}

	// Gets the time of the last touch. Very useful.k
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
