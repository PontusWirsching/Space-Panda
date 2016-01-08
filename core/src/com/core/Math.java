package com.core;

/**
 * A custom math class from my engine.
 * 
 * @author Pontus Wirsching
 *
 */
public class Math {
	
	public static float sin(float angle) {
		return (float) java.lang.Math.sin((double) toRadians(angle));
	}

	public static float cos(float angle) {
		return (float) java.lang.Math.cos((double) toRadians(angle));
	}

	public static float toRadians(float angle) {
		return (float) java.lang.Math.toRadians((double) angle);
	}

	public static float sqrt(float f) {
		return (float) java.lang.Math.sqrt((float) f);
	}
	
	public static float abs(float f) {
		return (float) java.lang.Math.abs((float) f);
	}
	
	public static float toDegrees(float angle) {
		return (float) java.lang.Math.toDegrees((double) angle);
	}
	
	public static float getDistance(float x1, float y1, float x2, float y2) {
		return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	
	public static float getAngle(float x1, float y1, float x2, float y2) {
		float angle = toDegrees((float) java.lang.Math.atan2(x2 - x1,y2 - y1));
		angle -= 90;
	    if(angle < 0){
	        angle += 360.0f;
	    }
	    return -angle + 90;
	}

}
