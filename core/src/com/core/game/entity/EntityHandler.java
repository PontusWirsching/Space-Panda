package com.core.game.entity;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EntityHandler {

	/**
	 * An array that holds all of the entities on screen.
	 */
	protected static ArrayList<Entity> entities = new ArrayList<Entity>();

	public static void add(Entity entity) {
		getEntities().add(entity);
	}

	public static Entity get(int index) {
		return getEntities().get(index);
	}

	public static ArrayList<Entity> getEntities() {
		return entities;
	}

	public static int getNumberOfEntities() {
		return getEntities().size();
	}

	public static ArrayList<Entity> getEntitiesByType(EntityType type) {
		ArrayList<Entity> entities = new ArrayList<Entity>();
		for (Entity e : getEntities()) {
			if (e.type.equals(type)) {
				entities.add(e);
			}
		}

		

		return entities;
	}

	public static void render(SpriteBatch batch, float delta) {
		for (int i = 0; i < getNumberOfEntities(); i++) {
			if (i >= getNumberOfEntities())
				break;
			Entity e = get(i);
			if (e == null)
				continue;
			if (e.isVisible()) {
				e.render(batch, delta);
			}
		}
	}

}
