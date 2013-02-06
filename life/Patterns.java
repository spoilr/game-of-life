package life;

import java.util.Random;

import life.Life.Colour;

public class Patterns {

	private static int SIZE = 30;

	public static Board simple() {
		Board board = new Grid();
		Colour[][] grid = board.getGrid();
		board.setGrid(grid);
		return board;
	}

	public static Board generateBoard(int x) {
		Board board = new Grid();
		Colour[][] grid = board.getGrid();
		switch (x) {
			case 0: {break;}
			case 1 : {board = still(); break;}
			case 2 : {board = oscillator(); break;}
			case 3 : {random(grid); break;}
			case 4 : {soonpulsar(grid); break;}
			case 5 : {pentadecathlon(grid); break;}
			case 6 : {puftrain(grid); break;}
			case 7 : {spaceship(grid); break;}
			case 8 : {baker(grid); break;}
			case 9 : {bentkeys(grid); break;}
			case 10 : {washingmachine(grid); break;}
			case 11 : {bloom(grid); break;}
			case 12 : {bottle(grid); break;}
		}
		
		return board;
	}
	
	public static Board still() {
		Board board = new Grid();
		Colour[][] grid = board.getGrid();
		block(grid);
		beehive(grid);
		loaf(grid);
		boat(grid);
		tub(grid);
		barge(grid);
		return board;
	}
	
	public static Board oscillator() {
		Board board = new Grid();
		Colour[][] grid = board.getGrid();
		blinker(grid);
		toad(grid);
		beacon(grid);
		pulsar(grid);
		return board;
	}
	
	public static Board randomBoard() {
		Board board = new Grid();
		Colour[][] grid = board.getGrid();
		random(grid);
		return board;
	}
	
	private static void random(Colour[][] grid) {
		Random r = new Random();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				grid[i][j] = Colour.values()[r.nextInt(3)];
			}
		}
	}
	
	private static void bottle(Colour[][] grid) {
		grid[5][10] = Colour.RED;
		grid[5][11] = Colour.RED;
		grid[5][18] = Colour.RED;
		grid[5][19] = Colour.GREEN;
		grid[6][9] = Colour.RED;
		grid[6][12] = Colour.RED;
		grid[6][17] = Colour.RED;
		grid[6][20] = Colour.GREEN;
		grid[7][9] = Colour.GREEN;
		grid[7][11] = Colour.RED;
		grid[7][18] = Colour.RED;
		grid[7][20] = Colour.RED;
		grid[8][7] = Colour.RED;
		grid[8][8] = Colour.GREEN;
		grid[8][11] = Colour.RED;
		grid[8][12] = Colour.RED;
		grid[8][13] = Colour.RED;
		grid[8][16] = Colour.RED;
		grid[8][17] = Colour.RED;
		grid[8][18] = Colour.RED;
		grid[8][21] = Colour.GREEN;
		grid[8][22] = Colour.GREEN;
		grid[9][6] = Colour.RED;
		grid[9][13] = Colour.RED;
		grid[9][16] = Colour.GREEN;
		grid[9][23] = Colour.GREEN;
		grid[10][6] = Colour.RED;
		grid[10][8] = Colour.RED;
		grid[10][9] = Colour.RED;
		grid[10][20] = Colour.RED;
		grid[10][21] = Colour.RED;
		grid[10][23] = Colour.GREEN;
		grid[11][7] = Colour.RED;
		grid[11][9] = Colour.RED;
		grid[11][20] = Colour.RED;
		grid[11][22] = Colour.RED;
		grid[12][9] = Colour.RED;
		grid[12][10] = Colour.RED;
		grid[12][19] = Colour.RED;
		grid[12][20] = Colour.RED;
		
		grid[15][9] = Colour.GREEN;
		grid[15][10] = Colour.RED;
		grid[15][19] = Colour.RED;
		grid[15][20] = Colour.RED;
		grid[16][7] = Colour.RED;
		grid[16][9] = Colour.GREEN;
		grid[16][20] = Colour.RED;
		grid[16][22] = Colour.RED;
		grid[17][6] = Colour.GREEN;
		grid[17][8] = Colour.RED;
		grid[17][9] = Colour.RED;
		grid[17][20] = Colour.RED;
		grid[17][21] = Colour.RED;
		grid[17][23] = Colour.RED;
		grid[18][6] = Colour.RED;
		grid[18][13] = Colour.RED;
		grid[18][16] = Colour.RED;
		grid[18][23] = Colour.RED;
		grid[19][7] = Colour.RED;
		grid[19][8] = Colour.RED;
		grid[19][11] = Colour.RED;
		grid[19][12] = Colour.RED;
		grid[19][13] = Colour.RED;
		grid[19][16] = Colour.GREEN;
		grid[19][17] = Colour.RED;
		grid[19][18] = Colour.GREEN;
		grid[19][21] = Colour.RED;
		grid[19][22] = Colour.RED;
		grid[20][9] = Colour.GREEN;
		grid[20][11] = Colour.RED;
		grid[20][18] = Colour.RED;
		grid[20][20] = Colour.RED;
		grid[21][9] = Colour.GREEN;
		grid[21][12] = Colour.GREEN;
		grid[21][17] = Colour.RED;
		grid[21][20] = Colour.RED;
		grid[22][10] = Colour.RED;
		grid[22][11] = Colour.GREEN;
		grid[22][18] = Colour.GREEN;
		grid[22][19] = Colour.RED;
	}
	
	private static void bloom(Colour[][] grid) {
		grid[10][7] = Colour.RED;
		grid[11][8] = Colour.RED;
		grid[11][9] = Colour.RED;
		grid[11][10] = Colour.GREEN;
		grid[11][11] = Colour.RED;
		grid[12][9] = Colour.GREEN;
		grid[12][10] = Colour.RED;
		grid[14][15] = Colour.GREEN;
		grid[10][18] = Colour.RED;
		grid[11][18] = Colour.GREEN;
		grid[12][18] = Colour.RED;
		grid[13][17] = Colour.GREEN;
		grid[14][17] = Colour.RED;
	}
	
	private static void washingmachine(Colour[][] grid) {
		grid[10][10] = Colour.RED;
		grid[10][11] = Colour.GREEN;
		grid[10][13] = Colour.RED;
		grid[10][14] = Colour.GREEN;
		grid[11][9] = Colour.RED;
		grid[11][11] = Colour.GREEN;
		grid[11][12] = Colour.RED;
		grid[11][15] = Colour.GREEN;
		grid[12][9] = Colour.RED;
		grid[12][10] = Colour.GREEN;
		grid[12][15] = Colour.RED;
		grid[13][10] = Colour.GREEN;
		grid[13][14] = Colour.RED;
		grid[14][9] = Colour.GREEN;
		grid[14][14] = Colour.RED;
		grid[14][15] = Colour.GREEN;
		grid[15][9] = Colour.RED;
		grid[15][12] = Colour.GREEN;
		grid[15][13] = Colour.RED;
		grid[15][15] = Colour.GREEN;
		grid[16][10] = Colour.RED;
		grid[16][11] = Colour.GREEN;
		grid[16][13] = Colour.RED;
		grid[16][14] = Colour.GREEN;
	}
	
	private static void bentkeys(Colour[][] grid) {
		grid[15][13] = Colour.RED;
		grid[15][22] = Colour.GREEN;
		grid[16][12] = Colour.RED;
		grid[16][14] = Colour.RED;
		grid[16][21] = Colour.GREEN;
		grid[16][23] = Colour.GREEN;
		grid[17][13] = Colour.RED;
		grid[17][22] = Colour.GREEN;
		grid[17][15] = Colour.RED;
		grid[17][16] = Colour.RED;
		grid[18][16] = Colour.RED;
		grid[19][16] = Colour.RED;
		grid[17][19] = Colour.GREEN;
		grid[17][20] = Colour.GREEN;
		grid[18][19] = Colour.GREEN;
		grid[19][19] = Colour.GREEN;
	}
	
	private static void baker(Colour[][] grid) {
		grid[3][25] = Colour.RED;
		grid[3][26] = Colour.RED;
		grid[4][24] = Colour.GREEN;
		grid[4][26] = Colour.RED;
		grid[5][23] = Colour.RED;
		grid[6][22] = Colour.GREEN;
		grid[7][21] = Colour.GREEN;
		grid[8][20] = Colour.RED;
		grid[9][19] = Colour.RED;
		grid[10][18] = Colour.GREEN;
		grid[11][17] = Colour.GREEN;
		grid[12][16] = Colour.GREEN;
		grid[13][15] = Colour.RED;
		grid[14][14] = Colour.RED;
		grid[13][11] = Colour.GREEN;
		grid[13][12] = Colour.RED;
		grid[13][13] = Colour.GREEN;
		grid[12][12] = Colour.RED;
	}
	
	private static void spaceship(Colour[][] grid) {
		grid[16][16] = Colour.RED;
		grid[16][19] = Colour.RED;
		grid[17][20] = Colour.GREEN;
		grid[18][16] = Colour.RED;
		grid[18][20] = Colour.GREEN;
		grid[19][17] = Colour.RED;
		grid[19][18] = Colour.GREEN;
		grid[19][19] = Colour.GREEN;
		grid[19][20] = Colour.RED;
	}
	
	private static void block(Colour[][] grid) {
		grid[5][5] = Colour.RED;
		grid[5][6] = Colour.RED;
		grid[6][5] = Colour.RED;
		grid[6][6] = Colour.RED;
	}

	private static void beehive(Colour[][] grid) {
		grid[16][16] = Colour.GREEN;
		grid[16][17] = Colour.RED;
		grid[17][15] = Colour.GREEN;
		grid[17][18] = Colour.GREEN;
		grid[18][16] = Colour.RED;
		grid[18][17] = Colour.RED;
	}
	
	private static void loaf(Colour[][] grid) {
		grid[11][27] = Colour.GREEN;
		grid[11][28] = Colour.GREEN;
		grid[12][26] = Colour.RED;
		grid[12][29] = Colour.RED;
		grid[13][27] = Colour.GREEN;
		grid[13][29] = Colour.RED;
		grid[14][28] = Colour.RED;
	}

	private static void boat(Colour[][] grid) {
		grid[27][15] = Colour.RED;
		grid[27][16] = Colour.RED;
		grid[28][15] = Colour.GREEN;
		grid[28][17] = Colour.RED;
		grid[29][16] = Colour.RED;
	}
	
	private static void tub(Colour[][] grid) {
		grid[2][23] = Colour.GREEN;
		grid[3][22] = Colour.GREEN;
		grid[3][24] = Colour.GREEN;
		grid[4][23] = Colour.GREEN;
	}
	
	private static void barge(Colour[][] grid) {
		grid[12][7] = Colour.RED;
		grid[13][6] = Colour.GREEN;
		grid[13][8] = Colour.GREEN;
		grid[14][7] = Colour.RED;
		grid[14][9] = Colour.RED;
		grid[15][8] = Colour.GREEN;
	}
	
	private static void blinker(Colour[][] grid) {
		grid[5][5] = Colour.RED;
		grid[5][6] = Colour.GREEN;
		grid[5][7] = Colour.RED;
	}
	
	private static void toad(Colour[][] grid) {
		grid[4][24] = Colour.RED;
		grid[4][25] = Colour.RED;
		grid[4][26] = Colour.GREEN;
		grid[5][23] = Colour.GREEN;
		grid[5][24] = Colour.GREEN;
		grid[5][25] = Colour.RED;
	}
	
	private static void beacon(Colour[][] grid) {
		grid[9][20] = Colour.GREEN;
		grid[9][21] = Colour.RED;
		grid[10][20] = Colour.RED;
		grid[10][21] = Colour.GREEN;
		grid[11][22] = Colour.RED;
		grid[11][23] = Colour.GREEN;
		grid[12][22] = Colour.RED;
		grid[12][23] = Colour.GREEN;
	}
	
	private static void pulsar(Colour[][] grid) {
		grid[14][5] = Colour.RED;
		grid[14][6] = Colour.RED;
		grid[14][7] = Colour.GREEN;
		grid[16][3] = Colour.GREEN;
		grid[17][3] = Colour.RED;
		grid[18][3] = Colour.RED;
		grid[19][5] = Colour.RED;
		grid[19][6] = Colour.GREEN;
		grid[19][7] = Colour.GREEN;
		grid[16][8] = Colour.RED;
		grid[17][8] = Colour.RED;
		grid[18][8] = Colour.GREEN;
		
		grid[14][11] = Colour.RED;
		grid[14][12] = Colour.RED;
		grid[14][13] = Colour.GREEN;
		grid[16][15] = Colour.RED;
		grid[17][15] = Colour.GREEN;
		grid[18][15] = Colour.RED;
		grid[19][11] = Colour.GREEN;
		grid[19][12] = Colour.GREEN;
		grid[19][13] = Colour.RED;
		grid[16][10] = Colour.GREEN;
		grid[17][10] = Colour.RED;
		grid[18][10] = Colour.GREEN;
		
		grid[26][5] = Colour.GREEN;
		grid[26][6] = Colour.GREEN;
		grid[26][7] = Colour.RED;
		grid[22][3] = Colour.RED;
		grid[23][3] = Colour.RED;
		grid[24][3] = Colour.RED;
		grid[21][5] = Colour.GREEN;
		grid[21][6] = Colour.RED;
		grid[21][7] = Colour.RED;
		grid[22][8] = Colour.GREEN;
		grid[23][8] = Colour.RED;
		grid[24][8] = Colour.GREEN;
		
		grid[26][11] = Colour.RED;
		grid[26][12] = Colour.GREEN;
		grid[26][13] = Colour.RED;
		grid[22][15] = Colour.RED;
		grid[23][15] = Colour.GREEN;
		grid[24][15] = Colour.GREEN;
		grid[21][11] = Colour.RED;
		grid[21][12] = Colour.RED;
		grid[21][13] = Colour.GREEN;
		grid[22][10] = Colour.GREEN;
		grid[23][10] = Colour.RED;
		grid[24][10] = Colour.RED;
	}
	
	private static void soonpulsar(Colour[][] grid) {
		grid[15][15] = Colour.GREEN;
		grid[16][14] = Colour.RED;
		grid[16][15] = Colour.GREEN;
		grid[16][16] = Colour.RED;
		grid[17][14] = Colour.RED;
		grid[17][16] = Colour.RED;
		grid[18][14] = Colour.GREEN;
		grid[18][15] = Colour.RED;
		grid[18][16] = Colour.RED;
		grid[19][15] = Colour.GREEN;
	}

	private static void pentadecathlon(Colour[][] grid) {
		grid[15][10] = Colour.RED;
		grid[15][11] = Colour.RED;
		grid[15][12] = Colour.GREEN;
		grid[15][13] = Colour.GREEN;
		grid[15][14] = Colour.RED;
		grid[15][15] = Colour.RED;
		grid[15][16] = Colour.GREEN;
		grid[15][17] = Colour.GREEN;
		grid[15][18] = Colour.GREEN;
		grid[15][19] = Colour.RED;
	}

	private static void puftrain(Colour[][] grid) {
		grid[10][16] = Colour.GREEN;
		grid[11][17] = Colour.RED;
		grid[12][13] = Colour.RED;
		grid[12][17] = Colour.GREEN;
		grid[13][14] = Colour.RED;
		grid[13][15] = Colour.RED;
		grid[13][16] = Colour.RED;
		grid[13][17] = Colour.GREEN;
		
		grid[17][13] = Colour.RED;
		grid[18][14] = Colour.GREEN;
		grid[18][15] = Colour.RED;
		grid[19][15] = Colour.GREEN;
		grid[20][15] = Colour.RED;
		grid[21][14] = Colour.GREEN;
		
		grid[24][16] = Colour.GREEN;
		grid[25][17] = Colour.GREEN;
		grid[26][13] = Colour.RED;
		grid[26][17] = Colour.GREEN;
		grid[27][14] = Colour.GREEN;
		grid[27][15] = Colour.RED;
		grid[27][16] = Colour.GREEN;
		grid[27][17] = Colour.GREEN;
	}
	
}
