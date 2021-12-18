/**
 * Models a distinct game tile containing a specific color attribute.
 * @author Bill Lee
 */
public class Tile {
	private Color color; 

	/**
	 * Creates a Tile with a specific color.
	 * @param color color to be assigned to this tile
	 */
	public Tile(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return color.name();
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Tile) {
			if (color.toString().equals(other.toString())) {
				return true;
			}
		}
		return false; 
	}
}