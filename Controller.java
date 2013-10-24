/**
 * Controller class generates a Grid and returns the number of unique paths
 * starting in the upper left and ending in the lower left.
 * 
 * @author jkb7600
 * 
 */
public class Controller {
	private int paths;

	/**
	 * Constructor
	 * 
	 * @param grid
	 */
	public Controller(Grid grid) {
		paths = 0;
		run(grid);
	}

	/**
	 * Starts the traversing and outputs the number of paths when complete.
	 * 
	 * @param grid
	 */
	public void run(Grid grid) {
		move(0, 0, grid);
		System.out.println("There are " + paths + " paths");
	}

	/**
	 * Checks the current location and attempts all moves from box if available
	 * recursively traverses them.
	 * 
	 * @param x
	 * @param y
	 * @param grid
	 */
	public void move(int x, int y, Grid grid) {
		// if the box is already checked return.
		if (grid.boxes[x][y].checked == true) {
			return;
		} else {
			// check box and see if you have reached the end.
			grid.boxes[x][y].checked = true;
			grid.checkedCount++;
			// printGrid(grid);

			if (grid.boxes[x][y].end) {
				// System.out.println("AT END");
				if (grid.checkedCount == grid.size) {
					// System.out.println("PATH FOUND!");
					paths++;
				} else {
					return;
				}
			}
		}

		if (!grid.stop) {
			// Continue to generate paths
			Grid mUp = grid.Clone();
			Grid mDown = grid.Clone();
			Grid mLeft = grid.Clone();
			Grid mRight = grid.Clone();

			moveRight(x, y, mRight);
			moveLeft(x, y, mLeft);
			moveUp(x, y, mUp);
			moveDown(x, y, mDown);
		}

	}

	/**
	 * Traverses one Box to the Right if within bounds.
	 * 
	 * @param x
	 * @param y
	 * @param grid
	 */
	public void moveRight(int x, int y, Grid grid) {
		y++;
		if ((y) >= grid.getWidth()) {
			grid.stop = true;
			return;
		}
		move(x, y, grid);
	}

	/**
	 * Traverses one Box to the left if within bounds.
	 * 
	 * @param x
	 * @param y
	 * @param grid
	 */
	public void moveLeft(int x, int y, Grid grid) {
		y--;
		if (y < 0) {
			grid.stop = true;
			return;
		}
		move(x, y, grid);
	}

	/**
	 * Traverses one Box up if within bounds.
	 * 
	 * @param x
	 * @param y
	 * @param grid
	 */
	public void moveUp(int x, int y, Grid grid) {
		x--;
		if (x < 0) {
			grid.stop = true;
			return;
		}

		move(x, y, grid);

	}

	/**
	 * Traverses one Box down if within bounds.
	 * 
	 * @param x
	 * @param y
	 * @param grid
	 */
	public void moveDown(int x, int y, Grid grid) {
		x++;
		if ((x) >= grid.getHeight()) {
			grid.stop = true;
			return;
		}
		move(x, y, grid);
	}

	/**
	 * Prints the grid. Used for testing.
	 * 
	 * @param grid
	 */
	public void printGrid(Grid grid) {
		for (int i = 0; i < grid.getHeight(); i++) {
			for (int k = 0; k < grid.getWidth(); k++) {
				if (grid.boxes[i][k].checked) {
					System.out.print("X");
				} else {
					System.out.print("O");
				}
				if (grid.boxes[i][k].start) {
					System.out.print("(S)");
				}
				if (grid.boxes[i][k].end) {
					System.out.print("(E)");
				}
			}// end width
			System.out.println();
		}// end height
	}
}