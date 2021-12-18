/**
 * A custom Singly Linked List implementation specifically designed to manage Book objects.
 * Features in-place insertion sorting based on dynamic attributes.
 * @author Bill Lee
 */
public class LinkedBookshelf {
	private LinkedNode<Book> front;
	private LinkedNode<Book> back;
	private int size;
	private Attribute sortedBy;

	/**
	 * Initializes an empty bookshelf structure.
	 */
	public LinkedBookshelf() {
		this.front = null;
		this.back = null;
		this.size = 0;
		this.sortedBy = Attribute.ID;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() { 
		String bookShelf = sortedBy.toString();
		LinkedNode<Book> currNode = front;
		while (currNode != null) {
			bookShelf += "\n" + currNode.toString();
			currNode = currNode.getNext();
		}
		return bookShelf;
	}

	/**
	 * Retrieves the LinkedNode at the given index.
	 * @param index the target position
	 * @return the LinkedNode at the specified index
	 * @throws IndexOutOfBoundsException if the index is out of valid bounds
	 */
	public LinkedNode<Book> getNode(int index) {
		if (!(index >= 0 && index <= (size - 1)))
			throw new IndexOutOfBoundsException("invalid index");

		int count = 0;
		LinkedNode<Book> curr = front;

		while (curr != null && count < index) {
			count++;
			curr = curr.getNext();
		}
		return curr;
	}

	public Book get(int index) { 
		if (!(index >= 0 && index <= (size - 1)))
			throw new IndexOutOfBoundsException("invalid index");

		int count = 0;
		LinkedNode<Book> curr = front;
		
		while (curr != null && count < index) {
			count++;
			curr = curr.getNext();
		}
		return curr.getData();
	}

	public Book getFirst() {
		if (isEmpty())
			return null;
		return this.front.getData();
	}

	public Book getLast() {
		if (isEmpty())
			return null;
		return this.back.getData();
	}

	public void clear() {
		this.front = null;
		this.back = null;
		this.size = 0;
	}

	/**
	 * Appends a Book object to the end of the linked list without sorting.
	 * @param toAdd the book object to append
	 */
	public void appendBook(Book toAdd) {
		LinkedNode<Book> addBook = new LinkedNode<Book>(toAdd);
		if (front == null && back == null) {
			front = addBook;
			back = addBook;
		} else {
			back.setNext(addBook);
			back = addBook;
		}
		size++;
	}

	/**
	 * Inserts a Book object into the correct sorted position in the linked list.
	 * @param toAdd the book object to insert
	 */
	public void insertBook(Book toAdd) {
		LinkedNode<Book> addBook = new LinkedNode<Book>(toAdd);

		for (int i = 0; i < size; i++) {
			if (get(i).compareTo(toAdd, sortedBy) < 0) {
				LinkedNode<Book> curr = new LinkedNode<Book>(get(i));
				if (get(i) == getLast())
					appendBook(toAdd);
				else {
					LinkedNode<Book> nextNode = new LinkedNode<Book>(get(i + 1)); 
					curr.setNext(addBook);
					addBook.setNext(nextNode);
				}
			}
		}
	}

	/**
	 * Executes an insertion sort algorithm on the bookshelf instance based on a specified attribute.
	 * @param b the bookshelf to sort
	 * @param sortedBy the Attribute to sort the bookshelf by
	 */
	public static void sort(LinkedBookshelf b, Attribute sortedBy) {
		if (!(b.size == 0 || b.size == 1)) {
			int i;
			for (i = 1; i < b.size; i++) {
				b.insertBook(b.get(i));
			}
		}
	}
}