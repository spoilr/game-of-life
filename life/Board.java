package life;

import life.Life.Colour;


public abstract class Board {

	protected static int SIZE = 30;
	protected Colour[][] grid;

	public Board() {
		grid = new Colour[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				grid[i][j] = Colour.GREY;
			}
		}
	}

	public void setGrid(Colour[][] grid) {
		this.grid = grid;
	}
	
	public int getGridSize() {
		return SIZE;
	}
	
	
	public void resetGrid() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				grid[i][j] = Colour.GREY;
			}
		}
	}

	public Colour[][] getGrid() {
		return grid;
	}
	
	public Colour getColourCell(int x, int y) {
		return grid[x][y];
	}
	
	public void setColourCell(int x, int y, Colour c) {
		grid[x][y] = c;
	}
	
	public void oneStepUpdate() {
		
	}
	
	public abstract int liveCells();
	
}
