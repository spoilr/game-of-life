package life;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import life.Life.Colour;

public class Controllers {

	private Model model;
	private View display;
	private Timer t;
	private int speed;
	private int TIMER = 2000;

	public View getView () {
		return display;
	}
	
	public Model getModel() {
		return model;
	}
	
	public Controllers() {
		display = new Display(this);
		model = new Model(display);
		speed = 1;
		t = new Timer(TIMER / speed, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.step();
			}
		});
		t.setInitialDelay(0);
	}

	public CellListener createCellListener() {
		return new CellListener();
	}

	public ControlListener createControlListener() {
		return new ControlListener();
	}

	public ChangeValue createChangeValue() {
		return new ChangeValue();
	}

	public BoxListener createBoxListener() {
		return new BoxListener();
	}

	class ControlListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton buttonPressed = (JButton) e.getSource();
			String text = buttonPressed.getText();
			if (text.equals("Clear")) {
				model.clear();
			} else if (text.equals("Step")) {
				model.step();
			} else if (text.equals("Run")) {
				display.getButton(text).setText("Pause");
				display.disableCellButtons();
				t.start();
			} else if (text.equals("Pause")) {
				display.getButton(text).setText("Run");
				t.stop();
				display.enableCellButtons();
			}
		}

	}

	class BoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox box = (JComboBox) e.getSource();
			int x= box.getSelectedIndex();
			model.clear();
			model.addGrid(Patterns.generateBoard(x));
		}
	}

	class CellListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			Cell button = (Cell) event.getSource();

			int x = button.getXCoord();
			int y = button.getYCoord();

			if (button.isEnabled()) {
				if (SwingUtilities.isLeftMouseButton(event)) {
					model.resurrect(x, y, Colour.RED);
				} else if (SwingUtilities.isRightMouseButton(event)) {
					model.resurrect(x, y, Colour.GREEN);
				} else {
					model.resurrect(x, y, Colour.GREY);
				}
			}
		}
	}

	class ChangeValue implements ChangeListener {

		public void stateChanged(ChangeEvent event) {
			JSlider source = (JSlider) event.getSource();
			if (!source.getValueIsAdjusting()) {
				speed = (int) source.getValue();
				// t.setInitialDelay(TIMER/speed);
				if (t.isRunning()) {
					t.stop();
					t.setDelay(TIMER / speed);
					t.restart();
				} else {
					t.setInitialDelay(TIMER / speed);
					t.setDelay(TIMER / speed);
				}
			}

		}
	}

}
