package com.core.game.entity;

import com.core.game.Game;
import com.core.game.entity.entities.obstacles.Beetle;

public class ObstacleSpawner {

	public static float BEETLE_SPAWNRATE = 2.2f;
	
	
	
	static float beetleTimer = 0;
	
	
	
	
	

	public static void update(float delta) {
		
		beetleTimer+=delta;
		if (beetleTimer >= 1f / BEETLE_SPAWNRATE) {
			beetleTimer = 0;
			
			int spot = (int) Math.round((Math.random() - 0.5) * 3);

			double d = Math.random();
			if (d > 0.5) {
				// 50%
				spot = Game.panda.spot;
			}
			

			
			EntityHandler.add(new Beetle(spot));
			
		}
		
	}
	
}
