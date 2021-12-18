/**
 * Game engine managing an array of TileStacks and processing interaction logic.
 * @author Bill Lee
 */
public class TileMatchingGame {
	private TileStack[] columns;

	/**
	 * Initializes a new TileMatchingGame with a specified number of columns.
	 * @param columnCount the number of stack columns the game will contain
	 */
	public TileMatchingGame(int columnCount) {
		columns = new TileStack[columnCount];
		for (int i = 0; i < columnCount; i++) {
			columns[i] = new TileStack();
		}
	}

	public int getColumnsNumber() {
		return columns.length;
	}

	/**
	 * Returns a string representation of the stack of tiles at a given index.
	 * @param index the index of a column in this game
	 * @return a formatted string of the column contents
	 * @throws IndexOutOfBoundsException if index is out of bounds
	 */
	public String column(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= getColumnsNumber()) {
			throw new IndexOutOfBoundsException("Invalid column index.");
		}
		TileStack idxColumn = columns[index];
		String result = "";
		
		if (idxColumn != null && !idxColumn.isEmpty()) {
			for (Tile tile : idxColumn) {
				result += tile.toString() + " ";
			}
		}
		return result.trim();
	}

	public void clearColumn(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= getColumnsNumber()) {
			throw new IndexOutOfBoundsException("Invalid column index.");
		}
		columns[index] = new TileStack();
	}

	/**
	 * Drops a tile at the top of the specified column. Matches trigger removal.
	 * @param tile a tile to drop
	 * @param index the column position where the tile will be dropped
	 */
	public void dropTile(Tile tile, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= getColumnsNumber()) {
			throw new IndexOutOfBoundsException("Invalid column index.");
		}
		if (!columns[index].isEmpty() && columns[index].peek().equals(tile)) {
			columns[index].pop();
		} else {
			columns[index].push(tile);
		}
	}

	public void restartGame() {
		for (int i = 0; i < columns.length; i++) {
			columns[i] = new TileStack();
		}
	}

	@Override
	public String toString() {
		StringBuilder list = new StringBuilder("GAME COLUMNS:\n");
		for (int i = 0; i < columns.length; i++) {
			list.append(i).append(": ").append(column(i)).append("\n");
		}
		return list.toString();
	}
}