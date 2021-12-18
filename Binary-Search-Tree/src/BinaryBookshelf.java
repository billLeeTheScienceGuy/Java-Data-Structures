import java.util.ArrayList;

/**
 * A Binary Search Tree implementation designed to sort and query Book objects 
 * based on a prioritized hierarchy of Attributes.
 * @author Bill Lee
 */
public class BinaryBookshelf {
	private TreeNode<Book> root;
	private int size;
	private Attribute[] sortList;

	public BinaryBookshelf(Attribute[] sortList) {
		this.root = null;
		this.size = 0;
		this.sortList = sortList;
	}

	public void clear() {
		this.root = null;
		this.size = 0;
		this.sortList = null;
	}

	/**
	 * Searches for the input book in the bookshelf via recursive traversal.
	 * @param book the query book to search for
	 * @return true if the book is present in the shelf, false otherwise
	 */
	public boolean contains(Book book) {
		return containsHelper(book, root);
	}

	protected boolean containsHelper(Book book, TreeNode<Book> current) {
		if (current == null) {
			return false;
		}
		if (containsHelper(book, current.getLeft()) == true) {
			return true;
		}
		if (current.getData().equals(book) == true) {
			return true;
		}
		if (containsHelper(book, current.getRight()) == true) {
			return true;
		} else {
			return false;
        }
	}

	/**
	 * Retrieves a list of books in the bookshelf written by the given author.
	 * @param authorName the author name to filter on
	 * @return an ArrayList of books by the author
	 */
	public ArrayList<Book> getBooksByAuthor(String authorName) {
		return getBooksByAuthorHelper(authorName, root);
	}

	protected ArrayList<Book> getBooksByAuthorHelper(String authorName, TreeNode<Book> current) {
		ArrayList<Book> list = new ArrayList<Book>();
		if (current == null) {
			return list;
		}
		if (current.getLeft() != null) {
			getBooksByAuthorHelper(authorName, current.getLeft());
		}
		if (current.getData().getAuthor().compareTo(authorName) == 0) {
			list.add(current.getData());
		}
		if (current.getRight() != null) {
			getBooksByAuthorHelper(authorName, current.getRight());
		}
		return list;
	}

	@Override
	public String toString() {
		return toStringHelper(root);
	}

	protected String toStringHelper(TreeNode<Book> current) {
		ArrayList<Book> list = new ArrayList<Book>();
		if (current != null) {
			toStringHelper(current.getLeft());
			list.add(current.getData());
			toStringHelper(current.getRight());
		}
		return list.toString();
	}

	/**
	 * Compares two Book objects according to the prioritized sortList of attributes.
	 * @param one the first Book
	 * @param two the second Book
	 * @return a negative value if one < two, a positive value if one > two, 0 if equal
	 */
	protected int compareToHelper(Book one, Book two) {
		if (one.equals(two)) {
			return 0;
		}
		if (one.compareTo(two, Attribute.AUTHOR) != 0) {
			return one.compareTo(two, Attribute.AUTHOR);
		}
		if (one.compareTo(two, Attribute.ID) != 0) {
			return one.compareTo(two, Attribute.ID);
		}
		if (one.compareTo(two, Attribute.TITLE) != 0) {
			return one.compareTo(two, Attribute.TITLE);
		}
		if (one.compareTo(two, Attribute.PAGECOUNT) != 0) {
			return one.compareTo(two, Attribute.PAGECOUNT);
		}
		return 0;
	}

	protected TreeNode<Book> getRoot() {
		return root;
	}

	/**
	 * Adds a new Book to the BST in sorted order, relative to this BST's sortList attributes.
	 * @param book the Book object to be added to the BST.
	 * @throws IllegalArgumentException if this Book is already in the BST
	 */
	public void insertBook(Book book) {
		insertBookHelper(book, root);
	}

	protected void insertBookHelper(Book book, TreeNode<Book> current) {
		if (current == null) {
			size++;
			current = new TreeNode<Book>(book);
            return;
		}
		if (compareToHelper(book, current.getData()) == 0) {
			throw new IllegalArgumentException("The book is already in the BST");
		}
		if (compareToHelper(book, current.getData()) > 0) {
			insertBookHelper(book, current.getLeft());
		}
		if (compareToHelper(book, current.getData()) < 0) {
			insertBookHelper(book, current.getRight());
		}
	}

	public boolean isEmpty() {
		if (this.root == null || this.size == 0) {
			return true;
		}
		return false;
	}

	public String getAttributeOrder() {
		String result = "";
		for (int i = 1; i <= 4; i++) {
			result += i + ":" + sortList[i - 1].toString() + " ";
		}
		return result.trim();
	}

	public int size() {
		return this.size;
	}
}