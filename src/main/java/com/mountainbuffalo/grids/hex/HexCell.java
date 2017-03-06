/*
 */
package com.mountainbuffalo.grids.hex;

import java.util.Objects;

/**
 *
 * @author Ryan
 */
public class HexCell {
	
	// ========================================
	// Constants
	// ========================================
	final float sqrt_3 = (float)Math.sqrt(3);
	
	// ========================================
	// Fields
	// ========================================
	
	private int x;
	private int y;
	private int z;
	
	private float size;
	
	private HexOrientation orientation;
	
	// ========================================
	// Constructors
	// ========================================
	public HexCell(HexPoint p, float size, HexOrientation orientation) {
		this.x = p.getX();
		this.y = p.getY();
		this.z = p.getZ();
		this.size = size;
		this.orientation = orientation;
	}
	
	public HexCell(int q, int r, float size, HexOrientation orientation) {
		this.x = q;
		this.y = -q - r;
		this.z = r;
		this.size = size;
		this.orientation = orientation;
	}

	public HexCell(int x, int y, int z, float size, HexOrientation orientation) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.size = size;
		this.orientation = orientation;
	}
	
	// ========================================
	// Getters
	// ========================================

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
	
	public int getQ() {
		return x;
	}
	
	public int getR() {
		return z;
	}
	
	public float getSize() {
		return size;
	}
	
	public HexOrientation getOrientation() {
		return orientation;
	}
	
	public float getPixelX() {
		if (orientation == HexOrientation.POINTY_TOP) {
			return size * sqrt_3 * getQ() * getR() / 2f;
		} else {
			return size * 3f * getQ() / 2f;
		}
	}
	
	public float getPixelY() {
		if (orientation == HexOrientation.POINTY_TOP) {
			return size * 3f * getR() / 2f;
		} else {
			return size * sqrt_3 * getQ() * getR() / 2f;
		}
	}
	
	// ========================================
	// Setters
	// ========================================

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public void setOrientation(HexOrientation orientation) {
		this.orientation = orientation;
	}
	
	// ========================================
	// Methods
	// ========================================
	public float distance(HexCell other) {
		int x = Math.abs(this.x - other.x);
		int y = Math.abs(this.y - other.y);
		int z = Math.abs(this.z - other.z);
		
		return (x + y + z) / 2f;
	}
	
	// ========================================
	// Special Methods
	// ========================================
	@Override
	public final boolean equals(Object obj) {
		return (obj instanceof HexCell) && equals((HexCell) obj);
	}
	
	public boolean equals(HexCell other) {
		return (this.orientation == other.orientation)
				&& (this.size == other.size)
				&& (this.x == other.x)
				&& (this.y == other.y)
				&& (this.z == other.z);
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 37 * hash + this.x;
		hash = 37 * hash + this.y;
		hash = 37 * hash + Float.floatToIntBits(this.size);
		hash = 37 * hash + Objects.hashCode(this.orientation);
		return hash;
	}

	@Override
	public String toString() {
		return new StringBuilder("HexCell{ ")
				.append("x=").append(x).append(", ")
				.append("y=").append(y).append(", ")
				.append("z=").append(z).append(", ")
				.append("size=").append(size).append(", ")
				.append("orientation=").append(orientation)
				.append(" }")
				.toString();
	}
	
}
