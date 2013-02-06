package life;

import life.Life.Colour;

public class Wrapper {

	public Colour readCell(Model model, int x, int y) {
		return model.readCell(model.gridSize() - 1 - y, x);
	}

	public void kill(Model model, int x, int y) {
		model.kill(model.gridSize() - 1 - y, x);
	}

	public void resurrect(Model model, int x, int y, Colour c) {
		model.resurrect(model.gridSize() - 1 - y, x, c);
	}

}
