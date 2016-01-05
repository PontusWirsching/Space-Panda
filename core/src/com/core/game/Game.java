package com.core.game;

import com.badlogic.gdx.graphics.Texture;
import com.core.graphics.Screen;

public class Game extends Screen {

	public Game() {
		super("GAME");
	}
	
	Texture t = new Texture("badlogic.jpg");
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		sb.begin();
		
		sb.draw(t, -75, -75, 150, 150);
		
		sb.end();
		
	}

}
