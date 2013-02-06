package life;

import life.Life.Colour;

public class FutureCell {

	private int neighbours;
	private Colour majorityColour;
	
	public FutureCell(int neighbours, Colour majorityColour) {
		this.neighbours = neighbours;
		this.majorityColour = majorityColour;
	}
	
	public int getNeighbours() {
		return neighbours;
	}
	
	public Colour getMajorityColour() {
		return majorityColour;
	}
	
}
