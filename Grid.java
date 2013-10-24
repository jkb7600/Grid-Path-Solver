/**
 * Class generates a Grid filled with Box objects.
 * 
 * @author jkb7600
 * 
 */
public class Grid {

	private int height;
	private int width;
	protected Box[][] boxes;

	protected int checkedCount;
	protected boolean gridFull;
	protected boolean stop;
	protected int size;

	/**
	 * Constructor for Grid.
	 * 
	 * @param width
	 * @param height
	 */
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		boxes = new Box[height][width];
		checkedCount = 0;
		size = width * height;
		fillGrid();
	}

	/**
	 * Generates a deep copy of the Grid by creating a new Grid and set matching
	 * attributes.
	 * 
	 * @return Grid - Deep Copy of Grid
	 */
	public Grid Clone() {
		Grid tmp = new Grid(width, height);
		tmp.boxes = cloneBoxes();
		tmp.checkedCount = checkedCount;
		tmp.gridFull = gridFull;

		return tmp;
	}

	/**
	 * Fills the Grid with Box objects
	 */
	public void fillGrid() {

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Box box = new Box();

				// mark start
				if (x == 0 && y == 0) {
					box.start = true;
				} else if (x == 0 && y == height - 1) {
					// mark end
					box.end = true;
				}
				boxes[y][x] = box;
			}
		}
	}// end fill grid

	/**
	 * Generates a deep copy of the Box 2D array.
	 * 
	 * @return Box[][] - Deep copy.
	 */
	public Box[][] cloneBoxes() {
		Box[][] out = new Box[height][width];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				out[y][x] = boxes[y][x].Clone();
			}
		}
		return out;
	}

	/**
	 * Get Width.
	 * 
	 * @return Width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Get Height
	 * 
	 * @return Height
	 */
	public int getHeight() {
		return height;
	}

}