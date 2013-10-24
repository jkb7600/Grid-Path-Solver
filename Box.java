/**
 * 
 * Class generates a box object that contains three boolean attributes.
 * 
 * @author jkb7600
 * 
 */
public class Box {
	protected boolean checked;
	protected boolean end;
	protected boolean start;

	/**
	 * Constructor.
	 */
	public Box() {
		checked = false;
		end = false;
		start = false;
	}

	/**
	 * Provides a deep copy of the box by creating a new Box and setting the
	 * values to match.
	 * 
	 * @return Box clone.
	 */
	public Box Clone() {
		Box tmp = new Box();
		tmp.checked = checked;
		tmp.end = end;
		tmp.start = start;
		return tmp;
	}

}// end class