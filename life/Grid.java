package life;

import life.Life.Colour;

public class Grid extends Board {

	

	public Grid() {
		super();
	}
	
	private FutureCell neighboursAndColour(int x, int y) {
		int neighbours = 0;
		int red = 0;
		int green = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i != x || j != y) {
					if (isCellAlive(i, j)) {
						neighbours++;
					}
					Colour c = getColourCell(i, j);
					if (c == Colour.RED) {
						red++;
					} else if (c == Colour.GREEN) {
						green++;
					}
				}
			}
		}
		Colour majColour = red >= green ? Colour.RED : Colour.GREEN;
		return new FutureCell(neighbours, majColour);
	}

	
	public Colour getColourCell(int x, int y) {
		int wrapX = (x + 30) % 30;
		int wrapY = (y + 30) % 30;
		return grid[wrapX][wrapY];
	}

	private boolean isCellAlive(int x, int y) {
		Colour c = getColourCell(x, y);
		return c == Colour.RED || c == Colour.GREEN;
	}
	
	private boolean isCellDead(int x, int y) {
		return getColourCell(x, y) == Colour.GREY;
	}
	
	public void oneStepUpdate() {
		FutureCell[][] futureCell = new FutureCell[SIZE][SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				futureCell[i][j] = neighboursAndColour(i, j);
			}
		}
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (isCellDead(i, j) && futureCell[i][j].getNeighbours() == 3) {
					setColourCell(i, j, futureCell[i][j].getMajorityColour());
				} else if (isCellAlive(i, j)
						&& (futureCell[i][j].getNeighbours() < 2 || futureCell[i][j].getNeighbours() > 3)) {
					setColourCell(i, j, Colour.GREY);
				}
			}
		}
	}

	public int liveCells() {
		int alive = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if(isCellAlive(i, j)) {
					alive++;
				}
			}
		}
		return alive;
	}
	
}
