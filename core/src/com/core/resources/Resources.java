package com.core.resources;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

/**
 * Main class for resources. <br>
 * 
 * @author Pontus Wirsching
 * @since 2016-01-05
 */
public class Resources {

	/**
	 * Mostly unused as we load all assets through .xml files. <br>
	 * Though in here you can put stuff like loadAnimation() and other load
	 * methods. <br>
	 * This method is called from the SpacePanda create() method. <br>
	 * 
	 * @author Pontus Wirsching
	 * @since 2016-01-05
	 */
	public static void load() {
	}

	/**
	 * This is a HashMap containing all loaded Textures. <br>
	 * This should not really be accessed directly as there's utility methods
	 * for <br>
	 * receiving Textures. <br>
	 *
	 * @author Pontus Wirsching
	 * @since 2016-01-05
	 */
	public static HashMap<String, TextureRegion> textures = new HashMap<String, TextureRegion>();

	/**
	 * @param key
	 *            - Name of the texture.
	 * @return A TextureRegion based on its name. <br>
	 * 
	 * @author Pontus Wirsching
	 * @since 2016-01-05
	 */
	public static TextureRegion get(String key) {
		return textures.get(key);
	}

	/**
	 * When loading a Sprite Sheet you use the relative path <br>
	 * relative to the assets folder. <br>
	 * Don't use any file extensions in your path. <br>
	 * The image file (.png) and the data file (.xml) must have the same name <br>
	 * and be placed in the same folder. <br>
	 * <br>
	 * 
	 * <pre>
	 * So as an example: <br>
	 * assets
	 *   |
	 *   |- Textures
	 *   	   | 
	 *   	   |- textures.png <-- "Image file" (must be .png)
	 *   	   |- textures.xml <-- "Data file" (must be .xml)
	 * </pre>
	 * 
	 * So to load the "textures" sheet you would use the path: <br>
	 * "Textures/textures", notice that there's no extension here. <br>
	 * <br>
	 * Once a texture sheet is loaded it will put all of the loaded texture <br>
	 * regions in the textures HashMap. <br>
	 * 
	 * @author Pontus Wirsching
	 * @since 2016-01-05
	 * 
	 * @param path
	 *            - Relative path of the texture sheet. <br>
	 */
	public static void loadSheet(String path) {
		try {
			String image = path + ".png";
			String data = path + ".xml";

			Texture texture = new Texture(image);

			XmlReader reader = new XmlReader();
			Element root = reader.parse(Gdx.files.internal(data));

			Array<Element> items = root.getChildrenByName("Sprite");

			for (Element e : items) {
				String name = e.get("name");
				int x = Integer.parseInt(e.get("x"));
				int y = Integer.parseInt(e.get("y"));
				int width = Integer.parseInt(e.get("width"));
				int height = Integer.parseInt(e.get("height"));
				put(name, new TextureRegion(texture, x, y, width, height));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads a spritesheet using tile width and height. Useful for animations.
	 * 
	 * @param path
	 *            - Path to the .png file (file extension is not needed)
	 * @param tileWidth
	 *            - how big each tile is.
	 * @param tileHeight
	 *            - how big each tile is.
	 */
	public static TextureRegion[] loadSheet(String path, int tileWidth, int tileHeight) {
		path = path.replace(".png", "");
		String image = path + ".png";
		Texture t = new Texture(image);

		int w = t.getWidth() / tileWidth;
		int h = t.getHeight() / tileHeight;

		TextureRegion[] tiles = new TextureRegion[w * h];

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				tiles[x + y * w] = new TextureRegion(t, x * tileWidth, y * tileHeight, tileWidth, tileHeight);
			}
		}

		return tiles;
	}

	/**
	 * Places a texture in the textures HashMap. <br>
	 * 
	 * @param key
	 *            - The Name of the texture, this is later used to retrieve the
	 *            texture.
	 * @param texture
	 *            - The TextureRegion to put in the HashMap.
	 * 
	 * @author Pontus Wirsching
	 * @since 2016-01-05
	 */
	public static void put(String key, TextureRegion texture) {
		textures.put(key, texture);
	}

	/**
	 * Places a texture in the textures HashMap. <br>
	 * This method also loads the texture.
	 * 
	 * @param key
	 *            - The Name of the texture, this is later used to retrieve the
	 *            texture.
	 * @param path
	 *            - The relative path to the texture.
	 * 
	 * @author Pontus Wirsching
	 * @since 2016-01-05
	 */
	public static void put(String key, String path) {
		textures.put(key, new TextureRegion(new Texture(path)));
	}
}
