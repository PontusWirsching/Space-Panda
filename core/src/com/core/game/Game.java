package com.core.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.core.Input;
import com.core.SpacePanda;
import com.core.graphics.Screen;
import com.core.resources.Resources;

public class Game extends Screen  {

	public Game() {
		super("GAME");

		Resources.loadSheet("background");

	}

	Texture t = new Texture("badlogic.jpg");

	float[] offsetValues = new float[6];

	float runtime = 1;

	float y = 0;
	float bambooLooping = 0;

	@Override
	public void render(float delta) {
		super.render(delta);
		
		Gdx.input.setInputProcessor(new Input());

		sb.begin();

		float w = camera.viewportWidth;
		float h = camera.viewportHeight;

		float speedDevider = 5;

		y += 100 * delta;
		bambooLooping += 100 * delta;

		if (bambooLooping > SpacePanda.HEIGHT)
			bambooLooping = 0;

		float scale = 4 - (runtime / (1000));
		runtime += ((delta / 10 + 1) * scale);

//System.out.println(scale + " . " + ((delta / 10 + 1) * scale));
//		scale = 1;

		int ww = (int) (w / (270 * scale));

		for (int i = 0; i < offsetValues.length; i++) {
			if (offsetValues[i] > 270 * scale)
				offsetValues[i] = 0;
		}
		float backgroundSpeed = 30;

		float preScale = scale;
		scale = 1;
		ww = (int) (w / (270 * scale));
		for (int i = -ww / 2 - 1; i < ww / 2 + 2; i++) {
			sb.draw(Resources.get("game:background:sky_1"), -270 * scale / 2 + i * 270 * scale, -h / 2, 270 * scale, h * scale);
			sb.draw(Resources.get("game:background:sky_2"), -270 * scale / 2 + i * 270 * scale + offsetValues[0], -h / 2, 270 * scale, h * scale);
			sb.draw(Resources.get("game:background:sky_3"), -270 * scale / 2 + i * 270 * scale + offsetValues[1], -h / 2, 270 * scale, h * scale);
		}
		scale = preScale;
		
		scale *= 3;

		
		float x = -135 * scale;
		float yy = -240 - y / backgroundSpeed / 1.5f;
		sb.draw(Resources.get("game:background:mountain_back"), x, yy, 270 * scale, h * scale);
		sb.draw(Resources.get("game:background:mountain_front"), x, yy, 270 * scale, h * scale);
		sb.draw(Resources.get("game:background:mountain_grass_1"), x, yy, 270 * scale, h * scale);
		sb.draw(Resources.get("game:background:mountain_grass_2"), x, yy, 270 * scale, h * scale);
		sb.draw(Resources.get("game:background:mountain_snow"), x, yy, 270 * scale, h * scale);
		
		ww = (int) (w / (270 * scale));
		for (int i = -ww / 2 - 1; i < ww / 2 + 2; i++) {
			float xx = -135 * scale + i * 270 * scale;
			float yyy = -240 - y / backgroundSpeed / 1.5f;
			sb.draw(Resources.get("game:background:mountain_small_clouds"), xx, yyy, 270 * scale, h * scale);
			sb.draw(Resources.get("game:background:mountain_grass_3"), xx, yyy, 270 * scale, h * scale);
			sb.draw(Resources.get("game:background:mountain_clouds"), xx, yyy, 270 * scale, h * scale);

		}
		
		scale /= 3;
		
		ww = (int) (w / (270 * scale));
		for (int i = -ww / 2 - 1; i < ww / 2 + 2; i++) {
			// sb.draw(Resources.get("game:background:sky_1"), -270 * scale / 2
			// + i * 270 * scale, -h / 2 - y / backgroundSpeed, 270 * scale, h *
			// scale);
			// sb.draw(Resources.get("game:background:sky_2"), -270 * scale / 2
			// + i * 270 * scale + offsetValues[0], -h / 2 - y /
			// backgroundSpeed, 270 * scale, h * scale);
			// sb.draw(Resources.get("game:background:sky_3"), -270 * scale / 2
			// + i * 270 * scale + offsetValues[1], -h / 2 - y /
			// backgroundSpeed, 270 * scale, h * scale);
			sb.draw(Resources.get("game:background:trees_back"), -270 * scale / 2 + i * 270 * scale + offsetValues[2], -h / 2 - y / backgroundSpeed, 270 * scale, h * scale);
			sb.draw(Resources.get("game:background:trees_1"), -270 * scale / 2 + i * 270 * scale + offsetValues[3], -h / 2 - y / backgroundSpeed, 270 * scale, h * scale);
			sb.draw(Resources.get("game:background:trees_2"), -270 * scale / 2 + i * 270 * scale + offsetValues[4], -h / 2 - y / backgroundSpeed, 270 * scale, h * scale);
			sb.draw(Resources.get("game:background:trees_3"), -270 * scale / 2 + i * 270 * scale + offsetValues[5], -h / 2 - y / backgroundSpeed, 270 * scale, h * scale);
		}

//		scale = 2;

		
//		System.out.println(Input.getSwipe());
		

		// Hi! I moved the bamboo code outside that for loop as
		// that for loop is only for the looping background

		// the width of the object will scale to that. so simply use the same
		// values as the texture width and height
		// cus i draw the textures so they fit. is 0,0 the bottom left then? yes
		// bottom left of the sprite but centered on the screen. 
		// now we got it centered on the screen

		sb.draw(Resources.get("game:object:bamboo_1"), -13.5f, -240 - bambooLooping, 27, 480);
		sb.draw(Resources.get("game:object:bamboo_1"), -13.5f, 240 - bambooLooping, 27, 480);

		sb.draw(Resources.get("game:object:bamboo_1"), -13.5f - SpacePanda.WIDTH * 1 / 3, -240 - bambooLooping, 27, 480);
		sb.draw(Resources.get("game:object:bamboo_1"), -13.5f - SpacePanda.WIDTH * 1 / 3, 240 - bambooLooping, 27, 480);

		sb.draw(Resources.get("game:object:bamboo_1"), -13.5f + SpacePanda.WIDTH * 1 / 3, -240 - bambooLooping, 27, 480);
		sb.draw(Resources.get("game:object:bamboo_1"), -13.5f + SpacePanda.WIDTH * 1 / 3, 240 - bambooLooping, 27, 480);

		
//		fling(float dX, dY, int arg3 ){
//			if(dX  > 2 || dY > 2){
//				//Locate panda graphic on x-coordinate of the bamboo
//			}
//		}
		
		
		sb.end();

	} 
}
