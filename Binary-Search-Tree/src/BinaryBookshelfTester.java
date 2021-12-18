/**
 * Unit testing suite to verify structural integrity, traversal logic, 
 * and insertion algorithms of the BinaryBookshelf architecture.
 * @author Bill Lee
 */
public class BinaryBookshelfTester {

	public static boolean testTreeNode() {
		try {
			TreeNode<Integer> tester1 = new TreeNode<Integer>(3);
			if (tester1.getLeft() != null || tester1.getRight() != null || (!(tester1.getData().equals(3)))
					|| (!(tester1.toString().equals("3")))) {
				return false;
			}
			
			TreeNode<Integer> tester2 = new TreeNode<Integer>(4);
			tester2.setLeft(tester1);
			if (tester2.getLeft() == null || tester2.getRight() != null) {
				return false;
			}
			
			tester2.setLeft(null);
			if (tester2.getLeft() != null || tester2.getRight() != null) {
				return false;
			}
			
			TreeNode<Integer> tester3 = new TreeNode<Integer>(5, tester1, tester2);
			if (tester3.getLeft().getData() != 3 || !tester3.getRight().toString().equals("4")) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean testEmptyTree() {
		try {
			Attribute[] att = new Attribute[4];
			BinaryBookshelf tester = new BinaryBookshelf(att);
		} catch (IllegalArgumentException e) {
		}
		
		try {
			Attribute[] att = new Attribute[4];
			att[0] = Attribute.AUTHOR;
			att[1] = Attribute.ID;
			att[2] = Attribute.PAGECOUNT;
			att[3] = Attribute.TITLE;
			BinaryBookshelf tester = new BinaryBookshelf(att);
		
			if (tester.size() != 0 || tester.getRoot() != null || tester.isEmpty() != true || tester.toString() == null
					|| (!(tester.getAttributeOrder().equals("1:AUTHOR 2:ID 3:PAGECOUNT 4:TITLE")))) {
				return false;
			}
			
			Book anything = new Book("anything", 3);
			if (tester.contains(anything) != false || tester.getBooksByAuthor("anything").size() != 0) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean testInsertBook() {
		try {
			Attribute[] att = new Attribute[4];
			att[0] = Attribute.AUTHOR;
			att[1] = Attribute.ID;
			att[2] = Attribute.PAGECOUNT;
			att[3] = Attribute.TITLE;
			BinaryBookshelf tester = new BinaryBookshelf(att);
			
			if (tester.isEmpty() == false) {
				return false;
			}
			
			Book book0 = new Book("CTITLE", 1, "CFIRST", "CLAST");
			tester.insertBook(book0);
			if (tester.isEmpty() == true) {
				return false;
			}
			
			TreeNode<Book> bookZero = new TreeNode<Book>(book0);
			if (!(tester.getRoot().getData().equals(bookZero.getData()))) {
				return false;
			}
			
			try {
				Book book1 = new Book("CTITLE", 1, "CFIRST", "ALAST");
				tester.insertBook(book1);
				TreeNode<Book> bookOne = new TreeNode<Book>(book1);
				if (!(tester.getRoot().getLeft().getData().equals(bookOne.getData()))) {
					return false;
				}
			} catch(NullPointerException e) {
			}
			
			Book book2 = new Book("CTITLE", 2, "CFIRST", "CLAST");
			tester.insertBook(book2);
			TreeNode<Book> bookTwo = new TreeNode<Book>(book2);
			if (!(tester.getRoot().getRight().getData().equals(bookTwo.getData()))) {
				return false;
			}
			
			try {
				Book book3 = new Book("CTITLE", 2, "CFIRST", "CLAST");
				tester.insertBook(book3);
			} catch (Exception e) {
			}
		
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean testContains() {
		Attribute[] att = new Attribute[4];
		att[0] = Attribute.AUTHOR;
		att[1] = Attribute.ID;
		att[2] = Attribute.PAGECOUNT;
		att[3] = Attribute.TITLE;
		BinaryBookshelf tester = new BinaryBookshelf(att);
		Book bookD = new Book("DTITLE", 1, "DFIRST", "DLAST");

		tester.insertBook(bookD);
		if (tester.contains(bookD) != true) {
			return false;
		}
		Book bookB = new Book("BTITLE", 1, "BFIRST", "BLAST");
		if (tester.contains(bookB) == true) {
			return false;
		}
		return true;
	}

	public static boolean testGetBooksByAuthor() {
		try {
			Attribute[] att = new Attribute[4];
			att[0] = Attribute.AUTHOR;
			att[1] = Attribute.ID;
			att[2] = Attribute.PAGECOUNT;
			att[3] = Attribute.TITLE;
			BinaryBookshelf tester = new BinaryBookshelf(att);
			Book bookD = new Book("DTITLE", 1, "DFIRST", "DLAST");
			tester.insertBook(bookD);
			
			if (tester.getBooksByAuthor("DLAST, DFIRST").size() != 1
					|| tester.getBooksByAuthor("CLAST, CFIRST").size() != 0) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Tree Node: " + testTreeNode());
		System.out.println("Empty Tree: " + testEmptyTree());
		System.out.println("Insert Book: " + testInsertBook());
		System.out.println("Contains: " + testContains());
		System.out.println("Get Books: " + testGetBooksByAuthor());
	}
}