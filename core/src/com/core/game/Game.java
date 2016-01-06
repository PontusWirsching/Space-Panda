package com.core.game;

import com.badlogic.gdx.graphics.Texture;
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
	
	@Override
	public void render(float delta) {
		super.render(delta);
		runtime+=delta;

		sb.begin();

		float w = camera.viewportWidth;
		float h = camera.viewportHeight;

		float speedDevider = 5;

		offsetValues[0] += delta * 10 / speedDevider;
		offsetValues[1] += delta * 20 / speedDevider;
		offsetValues[2] += delta * 25 / speedDevider;
		offsetValues[3] += delta * 30 / speedDevider;
		offsetValues[4] += delta * 40 / speedDevider;
		offsetValues[5] += delta * 50 / speedDevider;

		float treesSize = 4 - runtime / 20;

		int ww = (int) (w / (270 * treesSize));

		for (int i = 0; i < offsetValues.length; i++) {
			if (offsetValues[i] > 270 * treesSize)
				offsetValues[i] = 0;
		}

		for (int i = -ww / 2 - 1; i < ww / 2 + 2; i++) {
			sb.draw(Resources.get("game:background:sky_1"), -270 * treesSize / 2 + i * 270 * treesSize, -h / 2, 270 * treesSize, h* treesSize);
		}
		for (int i = -ww / 2 - 1; i < ww / 2 + 2; i++) {
			sb.draw(Resources.get("game:background:sky_2"), -270 * treesSize / 2 + i * 270 * treesSize + offsetValues[0], -h / 2, 270 * treesSize, h* treesSize);
		}
		for (int i = -ww / 2 - 1; i < ww / 2 + 2; i++) {
			sb.draw(Resources.get("game:background:sky_3"), -270 * treesSize / 2 + i * 270 * treesSize + offsetValues[1], -h / 2, 270 * treesSize, h* treesSize);
		}
		for (int i = -ww / 2 - 1; i < ww / 2 + 2; i++) {
			sb.draw(Resources.get("game:background:trees_back"), -270 * treesSize / 2 + i * 270 * treesSize + offsetValues[2], -h / 2, 270 * treesSize, h* treesSize);
		}
		for (int i = -ww / 2 - 1; i < ww / 2 + 2; i++) {
			sb.draw(Resources.get("game:background:trees_1"), -270 * treesSize / 2 + i * 270 * treesSize + offsetValues[3], -h / 2, 270 * treesSize, h* treesSize);
		}
		for (int i = -ww / 2 - 1; i < ww / 2 + 2; i++) {
			sb.draw(Resources.get("game:background:trees_2"), -270 * treesSize / 2 + i * 270 * treesSize + offsetValues[4], -h / 2, 270 * treesSize, h* treesSize);
		}
		for (int i = -ww / 2 - 1; i < ww / 2 + 2; i++) {
			sb.draw(Resources.get("game:background:trees_3"), -270 * treesSize / 2 + i * 270 * treesSize + offsetValues[5], -h / 2, 270 * treesSize, h* treesSize);
		}

		sb.end();

	}

}
