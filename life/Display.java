package life;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import life.Controllers.BoxListener;
import life.Controllers.CellListener;
import life.Controllers.ChangeValue;
import life.Controllers.ControlListener;
import life.Life.Colour;

public class Display implements View {

	private JPanel panel;
	
	private Cell gridButtons[][];
	private JLabel label;
	private JLabel alive;
	private JButton clear;
	private JButton step;
	private JButton runpause;

	private Controllers controller;
	
	private ControlListener controlListener;
	private CellListener cellListener;
	
	private BoxListener boxListener;

	private int turns;
	private int SIZE = 30;
	private int liveCells;
	
	private JComboBox options;
	
	public Display(Controllers controler) {
		
		panel = new JPanel();
		this.controller = controler;
		
		controlListener = controller.createControlListener();
		cellListener = controller.createCellListener();
		boxListener = controler.createBoxListener();
		
		panel.setLayout(new BorderLayout());

		createSlider();
		createGameButtons();
		createControlButtons();
		addLabel();
		panel.setVisible(true);
	}
	
	@Override
	public JPanel getPanel() {
		return panel;
	}

	private void addLabel() {
		JPanel labels = new JPanel(new GridLayout(1, 2));
		label = new JLabel("turns:" + turns, SwingConstants.CENTER);
		alive = new JLabel("alive:" + liveCells, SwingConstants.CENTER);
		labels.add(label);
		labels.add(alive);
		panel.add(labels, BorderLayout.NORTH);
	}

	private void createGameButtons() {

		JPanel gameButtons = new JPanel();
		
		gameButtons.setBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3));
		gameButtons.setLayout(new GridLayout(SIZE, SIZE));

		gridButtons = new Cell[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				gridButtons[i][j] = new Cell(i, j);
				gridButtons[i][j].addMouseListener(cellListener);
				gridButtons[i][j].setBackground(Color.GRAY);
				gameButtons.add(gridButtons[i][j]);
			}
		}
		panel.add(gameButtons, BorderLayout.CENTER);
	}

	private void createControlButtons() {

		JPanel controlButtons = new JPanel();
		
		controlButtons.setLayout(new FlowLayout(FlowLayout.LEFT));

		clear = new JButton("Clear");
		clear.addActionListener(controlListener);
		step = new JButton("Step");
		step.addActionListener(controlListener);
		runpause = new JButton("Run");
		runpause.addActionListener(controlListener);
		controlButtons.add(clear);
		controlButtons.add(step);
		controlButtons.add(runpause);
		
		String[] optionsArray = { "","Still", "Oscillator", "Random", 
				"SoonPulsar", "Pentadecathlon", "PufTrain", "Spaceship",
				"Baker", "BentKeys", "WashingMachine", "Bloom", "Bottle"};

		options = new JComboBox(optionsArray);
		options.addActionListener(boxListener);
		controlButtons.add(options, BorderLayout.SOUTH);
		
		panel.add(controlButtons, BorderLayout.SOUTH);
	}

	
	private void createSlider() {
		JSlider slider = new JSlider(JSlider.VERTICAL, 1, 10, 1);
		slider.addChangeListener(controller.createChangeValue());
		
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		panel.add(slider, BorderLayout.EAST);
	}

	@Override
	public void update(Model model) {
		Colour[][] grid = model.getGrid();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				Colour c = model.readCell(i, j);
				gridButtons[i][j].setBackground(showColour(c));
			}
		}
		label.setText(String.valueOf("turns:" + model.readTurn()));
		alive.setText(String.valueOf("alive:" + model.liveCells()));
	}
	
	private Color showColour(Colour c) {
		switch (c) {
		case RED:
			return Color.RED;

		case GREEN:
			return Color.GREEN;

		case GREY:
			return Color.GRAY;

		}
		return null;
	}

	@Override
	public JButton getButton(String text) {
		if (text.equals("Clear")) {
			return clear;
		} else if (text.equals("Step")) { 
			return step;
		} else {
			return runpause;
		}
	}
	
	public Cell getCell(int x, int y) {
		return gridButtons[x][y];
	}
	
	@Override
	public void disableCellButtons() {
		clear.removeActionListener(controlListener);
		step.removeActionListener(controlListener);
		options.removeActionListener(boxListener);
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				gridButtons[i][j].removeMouseListener(cellListener);
			}
		}
	}
	
	@Override
	public void enableCellButtons() {
		clear.addActionListener(controlListener);
		step.addActionListener(controlListener);
		options.addActionListener(boxListener);
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				gridButtons[i][j].addMouseListener(cellListener);
			}
		}
	}
	
}
