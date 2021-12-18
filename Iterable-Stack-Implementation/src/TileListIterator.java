import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator implementation enabling sequential traversal of the TileStack.
 * @author Bill Lee
 */
public class TileListIterator implements Iterator<Tile> {
	private Node next;

	public TileListIterator(Node head) {
		next = head;
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public Tile next() throws NoSuchElementException {
		if (next == null) {
			throw new NoSuchElementException("Iteration exceeded list bounds.");
		} else {
			Tile nextTile = next.getTile();
			next = next.getNext();
			return nextTile;
		}
	}
}