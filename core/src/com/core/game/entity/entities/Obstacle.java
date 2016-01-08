package com.core.game.entity.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.core.SpacePanda;
import com.core.game.Game;
import com.core.game.entity.Entity;
import com.core.game.entity.EntityHandler;

public class Obstacle extends Entity {

	private int bambooSpot;

	protected TextureRegion texture;

	public Obstacle(int bambooSpot, float width, float height) {
		super(0, 0, width, height);
		this.bambooSpot = bambooSpot;

		bounds.x = -bounds.width / 2 + (SpacePanda.WIDTH * 1 / 3) * bambooSpot;
		bounds.y = Game.height / 2 + height / 2;
	}
	
	@Override
	public boolean isVisible() {
		if (bounds.y + bounds.height < -Game.height / 2) EntityHandler.getEntities().remove(this);
		return true;
	}

	@Override
	public void render(SpriteBatch batch, float delta) {
		
		bounds.y -= Game.speed * delta;
		
		if (texture != null)
			batch.draw(texture, bounds.x, bounds.y, bounds.width, bounds.height);
	}

}
