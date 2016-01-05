package com.core.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.core.SpacePanda;
import com.core.SpacePanda.OS;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1080 / 3;
		config.height = 1920 / 3;
//		config.width = 1920;
//		config.height = 1080;
		config.resizable = true;
//		config.fullscreen = true;
		SpacePanda.currentOS = OS.WINDOWS;
		new LwjglApplication(new SpacePanda(), config);
	}
}
