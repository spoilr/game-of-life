package life;

import javax.swing.JButton;

public class Cell extends JButton {

	private int x;
	private int y;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getXCoord() {
		return x;
	}

	public int getYCoord() {
		return y;
	}

}
