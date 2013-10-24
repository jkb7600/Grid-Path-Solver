/**
 * Main Class used to test and execute the Grid Path Solver.
 * 
 * @author jkb7600
 * 
 */
public class Main {
	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Controller(new Grid(2, 2));// 1 Path
		new Controller(new Grid(3, 3));// 2 Paths
		new Controller(new Grid(4, 3));// 0 Paths
		// new Controller(new Grid(3,4));

	}
}