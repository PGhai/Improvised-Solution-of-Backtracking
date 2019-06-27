import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class solution {

	static int n = 13;
	static int m = 8;



	static void printSolution(String sol[][]) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 13; j++) {
				System.out.print(" " + sol[j][i] + " ");
			}
			System.out.println("");
		}
	}

	static boolean isSafe(String[][] maze, int x, int y, String[][] sol) {
		// if (x, y outside maze) return false
		if (x >= 0 && x < n && y >= 0 && y < m && maze[x][y].equals("-") && !(sol[x][y].equals("x"))) {
			return true;
		} else {
			return false;

		}
	}

	static boolean solveMaze(String[][] maze) {
		String sol[][] = new String[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sol[j][i] = "0";

			}

		}

		if (solveMazeUtil(maze, 0, 0, sol) == false) {
			System.out.print("Solution doesn't exist");
			return false;
		}
		printSolution(sol);
		return true;
	}

	private static boolean solveMazeUtil(String[][] maze, int x, int y, String[][] sol) {
		// TODO Auto-generated method stub\
		// if (x, y is goal) return true
		if (y >= 0 && x >= 0 && y < 8 && x < 13 && maze[x][y].equals("@")) {
			System.out.println("found");
			return true;

		} else if ((isSafe(maze, x, y, sol)) == true) {
			sol[x][y] = "x";
			if (solveMazeUtil(maze, x + 1, y, sol) == true) {

				return true;
			} else if (solveMazeUtil(maze, x, y + 1, sol) == true) {

				return true;
			} else if (solveMazeUtil(maze, x, y - 1, sol) == true) {

				return true;
			} else if (solveMazeUtil(maze, x - 1, y, sol) == true) {

				return true;
			}
			sol[x][y] = "!";
			return false;
		}

		return false;

	}

	public static void main(String args[]) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		String maze[][] = new String[13][8];

		File file = new File("map.txt");
		Scanner sc = new Scanner(file);
		int j = 0;
		while (sc.hasNext()) {

			while (j < 8) {
				String line = sc.nextLine();
				for (int i = 0; i < line.length(); i++) {
					maze[i][j] = "" + line.charAt(i);

				}
				j++;

			}

		}
		solveMaze(maze);

	}

}
