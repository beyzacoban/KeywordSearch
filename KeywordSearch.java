import java.util.Scanner;
import java.util.Random;

public class KeywordSearch {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the number of rows: ");
		int rows = input.nextInt();
		System.out.print("Please enter the number of column: ");
		int columns = input.nextInt();

		char[][] grid = generateRandomGrid(rows, columns);
		printGrid(grid);

		System.out.print("Please enter the Keyword: ");
		String keyword = input.next();

		boolean found = searchKeyword(grid, keyword);

		System.out.println("Keyword \"" + keyword + "\" found: " + found);

		input.close();
	}

	private static char[][] generateRandomGrid(int rows, int columns) {
		char[][] grid = new char[rows][columns];
		Random random = new Random();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int type = random.nextInt(2);
				if (type == 0) {
					grid[i][j] = (char) (random.nextInt(26) + 'A');
				} else {
					grid[i][j] = (char) (random.nextInt(10) + '0');
				}
			}
		}
		return grid;
	}

	private static void printGrid(char[][] grid) {
		for (char[] row : grid) {
			for (char cell : row) {
				System.out.print(cell + " ");
			}
			System.out.println();
		}
	}

	private static boolean searchKeyword(char[][] grid, String keyword) {
		int rows = grid.length;
		int columns = grid[0].length;
		// Check horizontally
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j <= columns - keyword.length(); j++) {
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < keyword.length(); k++) {
					sb.append(grid[i][j + k]);
				}
				if (sb.toString().equals(keyword)) {
					return true;
				}
			}
		}
		// Check vertically
		for (int i = 0; i <= rows - keyword.length(); i++) {
			for (int j = 0; j < columns; j++) {
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < keyword.length(); k++) {
					sb.append(grid[i + k][j]);
				}
				if (sb.toString().equals(keyword)) {
					return true;
				}
			}
		}
		// Check diagonally
		for (int i = 0; i <= rows - keyword.length(); i++) {
			for (int j = 0; j <= columns - keyword.length(); j++) {
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < keyword.length(); k++) {
					sb.append(grid[i + k][j + k]);
				}
				if (sb.toString().equals(keyword)) {
					return true;
				}
			}
		}
		for (int i = 0; i <= rows - keyword.length(); i++) {
			for (int j = keyword.length() - 1; j < columns; j++) {
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < keyword.length(); k++) {
					sb.append(grid[i + k][j - k]);
				}
				if (sb.toString().equals(keyword)) {
					return true;
				}
			}
		}
		return false;
	}

}
