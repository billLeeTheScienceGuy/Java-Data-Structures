import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * A Singly-Linked Stack implementation designed for LIFO tile management.
 * @author Bill Lee
 */
public class TileStack implements Iterable<Tile>, StackADT<Tile> {
	private Node top;
	private int size;

	public TileStack() {
		top = null;
		size = 0;
	}

	@Override
	public void push(Tile element) {
		if (element == null) {
			throw new IllegalArgumentException("Cannot push a null element.");
		}
		Node node = new Node(element);
		if (size == 0) {
			top = node;
		} else {
			node.setNext(top);
			top = node;
		}
		size++;
	}

	@Override
	public Tile pop() {
		if (top == null) {
			throw new EmptyStackException();
		} else {
			Tile temp = top.getTile();
			top = top.getNext();
			size--;
			return temp;
		}
	}

	@Override
	public Tile peek() throws EmptyStackException {
		if (top == null) {
			throw new EmptyStackException();
		}
		return top.getTile();
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<Tile> iterator() {
		return new TileListIterator(top);
	}
}