import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array-based heap implementation of a priority queue containing Assignments.
 * Guarantees the min-heap invariant where the Assignment at the root has the earliest due date.
 * @author Bill Lee
 */
public class AssignmentQueue implements PriorityQueueADT<Assignment>, Iterable<Assignment> {
	private Assignment[] queue; 
	private int size; 

	public AssignmentQueue(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException();
		}
		this.queue = new Assignment[capacity];
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	public int capacity() {
		return queue.length;
	}

	@Override
	public void clear() {
		queue = new Assignment[capacity()];
		size = 0;
	}

	@Override
	public void enqueue(Assignment e) {
		if (e == null) {
			throw new NullPointerException();
		}
		if (size == capacity()) {
			throw new IllegalStateException();
		}
		queue[size] = e;
		size++;
		percolateUp(size - 1);
	}

	@Override
	public Assignment dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Assignment element = queue[0];
		queue[0] = queue[size - 1];
		queue[size - 1] = null;
		size--;
		percolateDown(0);
		return element;
	}

	@Override
	public Assignment peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return queue[0];
	}

	protected void percolateDown(int i) {
		int min = i;
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;

		if (leftChild < size && queue[leftChild].compareTo(queue[min]) < 0) {
			min = leftChild;
		}
		if (rightChild < size && queue[rightChild].compareTo(queue[min]) < 0) {
			min = rightChild;
		}
		if (min != i) {
			Assignment temp = queue[i];
			queue[i] = queue[min];
			queue[min] = temp;
			percolateDown(min);
		}
	}

	protected void percolateUp(int i) {
		int parentIndex = (i - 1) / 2;
		if (queue[parentIndex].compareTo(queue[i]) > 0) {
			Assignment temp = queue[i];
			queue[i] = queue[parentIndex];
			queue[parentIndex] = temp;
			percolateUp(parentIndex);
		}
	}

	public AssignmentQueue deepCopy() {
		AssignmentQueue copy = new AssignmentQueue(size);
		for (int i = 0; i < this.size(); i++) {
			copy.enqueue(queue[i]);
		}
		return copy;
	}

	@Override
	public String toString() {
		StringBuilder val = new StringBuilder();
		for (Assignment a : this) {
			val.append(a).append("\n");
		}
		return val.toString();
	}

	@Override
	public Iterator<Assignment> iterator() {
		return new AssignmentIterator(this);
	}
}