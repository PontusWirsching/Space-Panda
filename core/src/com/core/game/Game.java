package com.core.game;

import com.badlogic.gdx.graphics.Texture;
import com.core.SpacePanda;
import com.core.graphics.Screen;
import com.core.resources.Resources;

public class Game extends Screen {

	public Game() {
		super("GAME");

		Resources.loadSheet("background");

	}

	Texture t = new Texture("badlogic.jpg");

	float[] offsetValues = new float[6];

	float runtime = 0;
	
	float y = 0;
	
	@Override
	public void render(float delta) {
		super.render(delta);
		runtime+=delta;

		sb.begin();

		float w = camera.viewportWidth;
		float h = camera.viewportHeight;

		float speedDevider = 5;

//		offsetValues[0] += delta * 10 / speedDevider;
//		offsetValues[1] += delta * 20 / speedDevider;
//		offsetValues[2] += delta * 25 / speedDevider;
//		offsetValues[3] += delta * 30 / speedDevider;
//		offsetValues[4] += delta * 40 / speedDevider;
//		offsetValues[5] += delta * 50 / speedDevider;
		
		y -= delta * 10;

		float treesSize = 4 - runtime / 10;

		int ww = (int) (w / (270 * treesSize));

		for (int i = 0; i < offsetValues.length; i++) {
			if (offsetValues[i] > 270 * treesSize)
				offsetValues[i] = 0;
		}

		for (int i = -ww / 2 - 1; i < ww / 2 + 2; i++) {
			sb.draw(Resources.get("game:background:sky_1"), -270 * treesSize / 2 + i * 270 * treesSize, -h / 2 + y, 270 * treesSize, h* treesSize);
			sb.draw(Resources.get("game:background:sky_2"), -270 * treesSize / 2 + i * 270 * treesSize + offsetValues[0], -h / 2 + y, 270 * treesSize, h* treesSize);
			sb.draw(Resources.get("game:background:sky_3"), -270 * treesSize / 2 + i * 270 * treesSize + offsetValues[1], -h / 2 + y, 270 * treesSize, h* treesSize);
			sb.draw(Resources.get("game:background:trees_back"), -270 * treesSize / 2 + i * 270 * treesSize + offsetValues[2], -h / 2 + y, 270 * treesSize, h* treesSize);
			sb.draw(Resources.get("game:background:trees_1"), -270 * treesSize / 2 + i * 270 * treesSize + offsetValues[3], -h / 2 + y, 270 * treesSize, h* treesSize);
			sb.draw(Resources.get("game:background:trees_2"), -270 * treesSize / 2 + i * 270 * treesSize + offsetValues[4], -h / 2 + y, 270 * treesSize, h* treesSize);
			sb.draw(Resources.get("game:background:trees_3"), -270 * treesSize / 2 + i * 270 * treesSize + offsetValues[5], -h / 2 + y, 270 * treesSize, h* treesSize);
			//the width of the object will scale to that. so simply use the same values as the texture width and height
			// cus i draw the textures so they fit. is 0,0 the bottom left then?  yes bottom left of the sprite but centered on the screen.
			//now we got it centered on the screen
			sb.draw(Resources.get("game:object:bamboo_1"), 0, -240, 27, 480);
			sb.draw(Resources.get("game:object:bamboo_1"), -13.5f - SpacePanda.WIDTH * 1 / 3, -240, 27, 480);
			sb.draw(Resources.get("game:object:bamboo_1"), -13.5f + SpacePanda.WIDTH * 1 / 3, -240, 27, 480);

			//sb.draw(Resources.get("game:object:bamboo_2"), -100, speedDevider, 0, 0, 10, 10, 5, 5, 0);
			//sb.draw(Resources.get("game:object:bamboo_3"), 20, speedDevider, 0, 0, 10, 10, 5, 5, 0);
			
		}

		sb.end();

	}

}
