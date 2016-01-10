package com.core.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.core.Input;
import com.core.SpacePanda;
import com.core.game.entity.EntityHandler;
import com.core.game.entity.ObstacleSpawner;
import com.core.game.entity.entities.Panda;
import com.core.game.entity.entities.obstacles.Beetle;
import com.core.graphics.Screen;
import com.core.resources.Resources;

public class GameOver extends Screen {
	
	public static int width = 0;
	public static int height = 0;
	public static String end = "Game Over!";

	public GameOver(){
		super("GAMEOVER");
		

		GameOver.width = (int) camera.viewportWidth;
		GameOver.height = (int) camera.viewportHeight;
		
		
		Resources.loadSheet("background");
		
	
	}

	
	public void resize(int width, int height) {
		super.resize(width, height);
		Game.width = (int) camera.viewportWidth;
		Game.height = (int) camera.viewportHeight;
	}
	
	
	float endscore = 0;
	BitmapFont font = new BitmapFont();
	GlyphLayout l = new GlyphLayout();
	
	public void render(float delta) {
		super.render(delta);

		Gdx.input.setInputProcessor(new Input());

		sb.begin();

		float w = camera.viewportWidth;
		float h = camera.viewportHeight;
		
		sb.draw(Resources.get("game:background:sky_1"), (int) -SpacePanda.WIDTH / 2 , (int) -SpacePanda.HEIGHT / 2 , (int) SpacePanda.WIDTH, (int) SpacePanda.HEIGHT);
	
		
		endscore = Game.getScore();
//		if (Input.isTouched()) {
//			if (Input.getX() > 0) {
//				endscore = 1;
//			} else {
//				endscore = -1;
//			}
//		}
		
		endscore = Game.getScore();
		String highScore = "HIGH SCORE:" + (int) endscore;
		String s = "Score: " + (int) endscore;
		
		l.setText(font, s);
		
		
		
		font.setColor(Color.YELLOW);
		font.draw(sb, highScore, -25 - l.width / 2, 50);
		
		
		font.setColor(Color.YELLOW);
		font.draw(sb, s, 0 - l.width / 2, 20);
		//font.draw
		
		sb.end();

	}	
	
}
