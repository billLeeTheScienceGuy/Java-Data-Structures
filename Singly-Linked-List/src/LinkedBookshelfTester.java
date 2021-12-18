/**
 * Unit testing suite to verify generic node allocation, memory management, 
 * and insertion sort algorithms within the LinkedBookshelf class.
 * @author Bill Lee
 */
public class LinkedBookshelfTester {

	public static boolean testLinkedNode() {
		LinkedNode<String> a;

		a = new LinkedNode<String>("i don't like this");
		if (a.getData() != "i don't like this" && a.getNext() != null) {
			return false;
		}

		LinkedNode<String> expected = new LinkedNode<String>("tail");
		a = new LinkedNode<String>("whatever", expected);
		if (a.getNext() != expected)
			return false;

		expected = new LinkedNode<String>("tail");
		a = new LinkedNode<String>("whatever");
		a.setNext(expected);
		if (a.getNext() != expected)
			return false;

		return true;
	}

	public static boolean testClear() {
		try {
			LinkedBookshelf e = new LinkedBookshelf();
			Book b1 = new Book("50 Shades of Grey", 400, "Grey", "Barry");
			Book b2 = new Book("Got Nothing", 300, "Leo", "Jr");
			e.appendBook(b1);
			e.appendBook(b2);
			e.clear();
			if (e.getFirst() != null && e.getLast() != null && e.size() != 0)
				return false;

			e = new LinkedBookshelf();
			e.clear();
			if (e.getFirst() != null && e.getLast() != null && e.size() != 0)
				return false;
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
			return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean testAddBooks() {
		LinkedBookshelf e = new LinkedBookshelf();
		Book b1 = new Book("50 Shades of Grey", 400, "Grey", "Barry");
		Book b2 = new Book("Got Nothing", 300, "Leo", "Jr");
		Book b3 = new Book("Animals gone wild", 500, "McDonold", "Mickey");
		e.appendBook(b1);
		e.appendBook(b2);
		e.appendBook(b3);

		if (!(e.size() != 3 && b1 != e.getFirst() && b3 != e.getLast()))
			return false;

		return true;
	}

	public static boolean testSortBooks() {
		LinkedBookshelf e = new LinkedBookshelf();
		Book b1 = new Book("50 Shades of Grey", 400, "Grey", "Barry");
		Book b2 = new Book("Got Nothing", 300, "Leo", "Jr");
		Book b3 = new Book("Animals gone wild", 500, "McDonold", "Mickey");
		e.appendBook(b1);
		e.appendBook(b2);
		e.appendBook(b3);

		LinkedBookshelf.sort(e, Attribute.PAGECOUNT);

		if (e.getFirst() != b2 && e.getLast() != b3) {
			return false;
		}
		return true;
	}

	public static boolean runAllTests() {
		if (!testLinkedNode()) {
			System.out.println("Error in LinkedNode Class");
			return false;
		}
		if (!testClear()) {
			System.out.println("Error in clear method");
			return false;
		}
		if (!testAddBooks()) {
			System.out.println("Error in add books method");
			return false;
		}
		if (!testSortBooks()) {
			System.out.println("Error in sort books method");
			return false;
		}
		System.out.println("All tests passed");
		return true;
	}

	public static void main(String[] args) {
		runAllTests();
	}
}