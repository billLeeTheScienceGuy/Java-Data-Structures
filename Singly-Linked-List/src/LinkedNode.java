/**
 * A generic node class used to build dynamically allocated linked list structures.
 * @param <T> the data type contained within the node
 * @author Bill Lee
 */
public class LinkedNode<T> {
	private T data;
	private LinkedNode<T> next;

	/**
	 * Initializes the node with data, leaving the next reference null.
	 * @param data the generic data to store
	 */
	public LinkedNode(T data) {
		this.data = data;
		this.next = null;
	}

	/**
	 * Initializes the node with data and a reference to the next node.
	 * @param data the generic data to store
	 * @param next the next node in the sequence
	 */
	public LinkedNode(T data, LinkedNode<T> next) {
		this.data = data;
		this.next = next;
	}

	public LinkedNode<T> getNext() {
		return this.next;
	}

	public T getData() {
		return this.data;
	}

	@Override
	public String toString() {
		return data.toString();
	}

	public void setNext(LinkedNode<T> next) {
		this.next = next;
	}
}