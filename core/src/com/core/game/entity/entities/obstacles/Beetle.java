package com.core.game.entity.entities.obstacles;

import com.core.game.entity.entities.Obstacle;
import com.core.resources.Resources;

public class Beetle extends Obstacle {

	public Beetle(int bambooSpot) {
		super(bambooSpot, 50, 50);
		texture = Resources.get("game:obstacles:beetle");
	}

	
	
}
