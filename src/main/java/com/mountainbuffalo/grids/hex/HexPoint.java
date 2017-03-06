/*
 */
package com.mountainbuffalo.grids.hex;

/**
 *
 * @author Ryan
 */
public class HexPoint {
	
	public int x;
	public int y;
	public int z;

	public HexPoint(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public void set(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void add(int x, int y, int z) {
		this.x += x;
		this.y += y;
		this.z += z;
	}
	
	public void add(HexPoint other) {
		this.x += other.x;
		this.y += other.y;
		this.z += other.z;
	}
	
	public void rotateRight() {
		int temp = -this.x;
		this.x = -this.z;
		this.z = -this.y;
		this.y = temp;
	}
	
	public void rotateLeft() {
		int temp = -this.x;
		this.x = -this.y;
		this.y = -this.z;
		this.z = temp;
	}
	
	public HexPoint copy() {
		return new HexPoint(x, y, z);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HexPoint) {
			final HexPoint other = (HexPoint)obj;
			return (this.x == other.x) && (this.y == other.y) && (this.z == other.z);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 23 * hash + this.x;
		hash = 23 * hash + this.y;
		hash = 23 * hash + this.z;
		return hash;
	}
	
	@Override
	public String toString() {
		return new StringBuilder("HexPoint{ ")
				.append("x=").append(x).append(", ")
				.append("y=").append(y).append(", ")
				.append("z=").append(z)
				.append(" }")
				.toString();
	}
	
}
