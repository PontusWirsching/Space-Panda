package com.core.game.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.core.SpacePanda;

public abstract class Entity {

	public Rectangle bounds = new Rectangle();
	
	private String id = "UNDEFINED";
	
	public EntityType type = EntityType.STATIC;

	public Entity(float x, float y, float width, float height) {
		this.bounds = new Rectangle(x, y, width, height);
	}

	public void setID(String id) {
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
	
	public boolean isVisible() {
		return bounds.overlaps(SpacePanda.screenBounds);
	}
	
	public abstract void render(SpriteBatch batch, float delta);
	
	
}
