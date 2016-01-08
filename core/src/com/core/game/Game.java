package com.core.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.core.Input;
import com.core.SpacePanda;
import com.core.game.entity.EntityHandler;
import com.core.game.entity.entities.Panda;
import com.core.graphics.Screen;
import com.core.resources.Resources;

public class Game extends Screen {

	public static Panda panda;
	
	public Game() {
		super("GAME");

		Resources.loadSheet("background");

		EntityHandler.add(panda = new Panda(0, 0, 214, 328));

	}

	float[] offsetValues = new float[6];

	// score/////////////////
	float score = 0;
	BitmapFont bitFont = new BitmapFont();
	// ///////////////////////

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
		bambooLooping += 125 * delta;

		if (bambooLooping > SpacePanda.HEIGHT)
			bambooLooping = 0;

		float scale = 4 - (runtime / (1000));
		runtime += ((delta / 10 + 1) * scale);


		score += delta * 10;
		// runtime += delta * 30;

		// System.out.println(scale + " . " + ((delta / 10 + 1) * scale));
		// scale = 1;

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
			bitFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);

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

		// scale = 2;

		// sb.draw(Resources.get("game:object:bamboo_1"), Input.startPos.x,
		// Input.startPos.y, 50, 50);
		// sb.draw(Resources.get("game:object:bamboo_1"), Input.endPos.x,
		// Input.endPos.y, 50, 50);

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

		panda.spot = 0;
		if (Input.isTouched()) {
			if (Input.getX() > 0) {
				panda.spot = 1;
			} else {
				panda.spot = -1;
			}
		}

		// if (Input.isTouched() && !b) {
		// b = true;
		// if (Input.getX() > 0) {
		// if (panda.spot < 1)
		// panda.spot++;
		// } else {
		// if (panda.spot > -1)
		// panda.spot--;
		// }
		// } else if (!Input.isTouched() && b) {
		// b = false;
		// }

		String s = "" + (int) score;
		l.setText(bitFont, s);
		bitFont.getData().setScale(2);
		bitFont.setColor(Color.YELLOW);
		bitFont.draw(sb, s, 0 - l.width / 2, 230 - 10);

		EntityHandler.render(sb, delta);

		sb.end();

	}

	// Boolean to toggle the touch.
	boolean b = false;

	GlyphLayout l = new GlyphLayout();

}
