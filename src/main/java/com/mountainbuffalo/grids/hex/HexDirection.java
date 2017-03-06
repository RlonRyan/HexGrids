/*
 */
package com.mountainbuffalo.grids.hex;

/**
 *
 * @author Ryan
 */
public enum HexDirection {

	TOP			( 0,  0,  0, /**/ 0,  1, -1),
	TOP_RIGHT	( 1,  0, -1, /**/ 1,  0, -1),
	RIGHT		( 1, -1,  0, /**/ 0,  0,  0),
	BOTTOM_RIGHT( 0, -1,  1, /**/ 1, -1,  0),
	BOTTOM		( 0,  0,  0, /**/ 0, -1,  1),
	BOTTOM_LEFT (-1,  0,  1, /**/-1,  0,  1),
	LEFT		(-1,  1,  0, /**/ 0,  0,  0),
	TOP_LEFT	( 0,  1, -1, /**/-1,  1,  0);
	
	public static float theta = 60f;
	
	private final HexPoint[] unitVectors;

	private HexDirection(int pX, int pY, int pZ, int fX, int fY, int fZ) {
		this.unitVectors = new HexPoint[] {
			new HexPoint(fX, fY, fZ),
			new HexPoint(fX, fY, fZ)
		};
	}
	
	public static final HexDirection[] inverses = new HexDirection[]{
		BOTTOM,
		BOTTOM_LEFT,
		LEFT,
		TOP_LEFT,
		TOP,
		TOP_RIGHT,
		RIGHT,
		BOTTOM_RIGHT
	};

	public static final HexDirection[] pointyDirections = new HexDirection[]{
		TOP_RIGHT,
		RIGHT,
		BOTTOM_RIGHT,
		BOTTOM_LEFT,
		LEFT,
		TOP_LEFT
	};
	
	public static final HexDirection[] flatDirections = new HexDirection[] {
		TOP,
		TOP_RIGHT,
		BOTTOM_RIGHT,
		BOTTOM,
		BOTTOM_LEFT,
		TOP_LEFT
	};
	
	public static final HexDirection[][] directions = new HexDirection[][] {
		pointyDirections,
		flatDirections
	};

	public static HexDirection getDirection(HexOrientation orientation, float angle) {
		return directions[orientation.ordinal()][(int) Math.floor(angle / theta) % 6];
	}
	
	public HexDirection getInverse() {
		return inverses[ordinal()];
	}
	
	public void next(HexPoint point, HexOrientation orientation) {
		point.add(unitVectors[orientation.ordinal()]);
	}

}
