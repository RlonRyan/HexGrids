/*
 */
package com.mountainbuffalo.grids.hex;

/**
 *
 * @author Ryan
 */
public class HexHexGrid {

	private final int radius;
	private final float cellSize;
	private final HexCell[] cells;
	private final HexOrientation orientation;

	public HexHexGrid(int radius, float cellSize, HexOrientation orientation) {
		this.radius = radius;
		this.cellSize = cellSize;
		this.cells = new HexCell[calculateSize(radius)];
		this.orientation = orientation;
	}

	public static int calculateSize(int radius) {
		return (3 * radius) * (radius - 1) + 1;
	}

	public static int rowGroup(int radius, int row) {
		return Math.abs(row - radius + 1);
	}

	public static int rowLength(int radius, int row) {
		return (2 * radius) - 1 - rowGroup(radius, row);
	}

	public static int rowCount(int radius) {
		return (2 * radius) - 1;
	}

	public static int elementSum(int radius, int row) {
		if (row >= rowCount(radius)) {
			throw new IndexOutOfBoundsException("Attempted to access row " + row + " of Hex grid with " + rowCount(radius) + " rows!");
		} else if (radius < 1) {
			throw new IllegalArgumentException("The radius of a hex grid cannot be less than 1! Given: " + radius);
		} else if (radius == 1) {
			return radius;
		} else if (row > radius - 1) {
			return calculateSize(radius) - elementSum(radius, 2 * radius - row - 2);
		} else {
			final int k = rowLength(radius, row);
			return ((k) * (k + 1) - (radius) * (radius + 1)) / 2;
		}
	}

	public static int elementSum(int radius, int row, int offset) {
		if (row >= rowCount(radius)) {
			throw new IndexOutOfBoundsException("Attempted to access row " + row + " of Hex grid with " + rowCount(radius) + " rows!");
		} else if (offset >= rowLength(radius, row)) {
			throw new IndexOutOfBoundsException("Attempted to access offset " + offset + " of row " + row + " which has length of " + rowLength(radius, row) + "!");
		}
		return elementSum(radius, row - 1) + offset;
	}

	public int getRadius() {
		return radius;
	}

	public HexOrientation getOrientation() {
		return orientation;
	}

	public float getCellSize() {
		return cellSize;
	}
	
	public boolean has(int q, int r) {
		return cells[elementSum(radius, r, q) - 1] == null;
	}
	
	public HexCell get(int q, int r) {
		return cells[elementSum(radius, r, q) - 1];
	}
	
	public HexCell put(HexCell cell) {
		final int index = elementSum(radius, cell.getR(), cell.getQ());
		final HexCell result = cells[index];
		cells[index] = cell;
		return cell;
	}

}
