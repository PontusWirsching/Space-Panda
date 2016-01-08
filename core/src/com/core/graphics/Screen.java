package com.core.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.core.SpacePanda;

public class Screen implements com.badlogic.gdx.Screen {

	public OrthographicCamera camera;
	
	public SpriteBatch sb;
	public ShapeRenderer sr;
	
	public String name = "UNDEFINED";
	
	public Screen(String name) {
		this.name = name;
		sb = new SpriteBatch();
		sr = new ShapeRenderer();
		
		float w = Gdx.graphics.getWidth(); // Real screen width.
		float h = Gdx.graphics.getHeight(); // Real screen height.
		
		//Initialize camera.
		camera = new OrthographicCamera(SpacePanda.WIDTH, SpacePanda.WIDTH * (h / w));
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		camera.update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sb.setProjectionMatrix(camera.combined);
		sr.setProjectionMatrix(camera.combined);
	}

	@Override
	public void resize(int width, int height) {
		float w = Gdx.graphics.getWidth(); // Real screen width.
		float h = Gdx.graphics.getHeight(); // Real screen height.
		
		//Initialize camera.
		
		System.out.println((w / h) + ", " + (SpacePanda.WIDTH / SpacePanda.HEIGHT));
		
		if (w / h > SpacePanda.WIDTH / SpacePanda.HEIGHT) {
			camera = new OrthographicCamera((SpacePanda.HEIGHT * (w / h) + 1) / 2 * 2, (SpacePanda.HEIGHT + 1) / 2 * 2);
		} else {
			camera = new OrthographicCamera((SpacePanda.WIDTH + 1) / 2 * 2, (SpacePanda.WIDTH * (h / w) + 1) / 2 * 2);
		}
		
		
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		sr.dispose();
		sb.dispose();
	}
}
