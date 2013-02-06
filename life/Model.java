package life;

import life.Life.Colour;

public class Model {

	private int turns;
	private Board grid;
	private View display;
	private int alive;

	public Model(View display) {
		grid = new Grid();
		turns = 0;
		alive = 0;
		this.display = display;
	}

	public void addGrid(Board grid) {
		this.grid = grid;
		display.update(this);
	}
	
	public void addDisplay(View display) {
		this.display = display;
	}
	
	public int gridSize() {
		return grid.getGridSize();
	}

	public Colour[][] getGrid() {
		return grid.getGrid();
	}

	public Colour readCell(int x, int y) {
		return grid.getGrid()[x][y];
	}

	public int readTurn() {
		return turns;
	}

	public void kill(int x, int y) {
		grid.setColourCell(x, y, Colour.GREY);
		alive--;
		display.update(this);
	}

	public void resurrect(int x, int y, Colour c) {
		if (c == Colour.GREY && readCell(x, y) != Colour.GREY){
			alive--;
		} else if (c != Colour.GREY && readCell(x, y) == Colour.GREY) {
			alive++;
		}
		grid.setColourCell(x, y, c);
		display.update(this);
	}

	public void clear() {
		turns = 0;
		alive = 0;
		grid.resetGrid();
		display.update(this);
	}

	public void step() {
		turns++;
		grid.oneStepUpdate();
		alive = grid.liveCells();
		display.update(this);
	}

	public int liveCells() {
		int nr = 0;
		for (int i = 0; i < gridSize(); i++) {
			for (int j = 0; j < gridSize(); j++) {
				if (grid.getColourCell(i, j) != Colour.GREY) {
					nr++;
				}
			}
		}
		return nr;
	}
	
	public void resetTurns() {
		turns = 0;
	}
	
}
