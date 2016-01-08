package com.core.game.entity.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.core.Input;
import com.core.SpacePanda;
import com.core.SwipeInterface;
import com.core.game.entity.Entity;
import com.core.resources.Resources;

public class Panda extends Entity {
	TextureRegion[] t;

	public int spot = 0;
	float targetX = 0;
	float speed = 50;

	public Panda(float x, float y, float width, float height) {
		super(x, y, width, height);


		t = Resources.loadSheet("Entities/Panda/climb.png", 404, 404);
		// climb = new Animation(1f / 120f, t);
	}

	int currentFrame = 0;
	int fps = 2;
	int frames = 0;
	float time = 0;

	Animation climb;

	float stateTime = 0f;

	@Override
	public void render(SpriteBatch batch, float delta) {

		;
		speed = 425;

		bounds.width = (404 / 4);
		bounds.height = (404 / 4);

		targetX = -bounds.width / 2 + (SpacePanda.WIDTH * 1 / 3) * spot;
		bounds.y = -bounds.height / 2;

		if (targetX < bounds.x) {
			bounds.x -= speed * delta;
		} else {
			bounds.x += speed * delta;
		}

		if (Math.abs(targetX - bounds.x) < (speed * delta) * 2) {
			bounds.x = targetX;
		}
		
		fps = 60;

		stateTime += delta * fps;

		frames = t.length;
		
		if (stateTime >= 1) {
			currentFrame++;
			if (currentFrame >= frames) {
				currentFrame = 0;
			}
			stateTime = 0;
		}
		
		// batch.draw(climb.getKeyFrame(stateTime, true), bounds.x, bounds.y,
		// bounds.width, bounds.height);
		batch.draw(t[currentFrame], bounds.x, bounds.y, bounds.width, bounds.height);

	}

}
