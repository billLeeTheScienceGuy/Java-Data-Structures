import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Unit testing suite for the Tile Matching game architecture.
 * @author Bill Lee
 */
public class TileMatchingTester {

	public static boolean tileEqualsTester() {
		try {
			Tile t1 = new Tile(Color.BLACK);
			String test1 = "test";
			if (t1.equals(test1)) return false;
			
			Tile t2 = new Tile(Color.BLACK);
			if (!(t1.equals(t2))) return false;
			
			Tile t3 = new Tile(Color.BLUE);
			if (t1.equals(t3)) return false;
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean tileListIteratorTester() {
		Node one = new Node(new Tile(Color.ORANGE));
		Node two = new Node(new Tile(Color.BLUE));
		Node three = new Node(new Tile(Color.BLACK));
		Node four = new Node(new Tile(Color.YELLOW));

		one.setNext(two);
		two.setNext(three);
		three.setNext(four);

		TileListIterator tester1 = new TileListIterator(one);
		TileListIterator tester2 = new TileListIterator(four);
		String expected = "ORANGE, BLUE, BLACK, YELLOW, ";
		String result = "";
		
		if (!tester1.hasNext()) return false;
		
		while (tester1.hasNext()) {
			result += tester1.next().toString() + ", ";
		}
		if (!result.equals(expected)) return false;
		
		try {
			tester2.next(); 
			tester2.next(); // Should trigger exception
			return false; 
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	public static boolean tileStackTester() {
		TileStack tester = new TileStack();
		if (!tester.isEmpty()) return false;
		
		Tile one = new Tile(Color.BLACK);
		Tile two = new Tile(Color.ORANGE);
		Tile three = new Tile(Color.YELLOW);
		
		tester.push(one);
		tester.push(two);
		tester.push(three);
		
		if (tester.size() != 3) return false;
		if (!tester.peek().equals(three)) return false;
		
		Tile value = tester.pop();
		if (!(value.equals(three) && tester.size() == 2)) return false;
		
		return true;
	}

	public static boolean tileMatchingGameTester() {
		TileMatchingGame tester = new TileMatchingGame(5);

		Tile tileOne = new Tile(Color.BLACK);
		Tile tileTwo = new Tile(Color.BLUE);
		Tile tileThree = new Tile(Color.ORANGE);
		Tile tileFour = new Tile(Color.YELLOW);
		
		tester.dropTile(tileOne, 1);
		tester.dropTile(tileTwo, 2);
		tester.dropTile(tileThree, 2);
		tester.dropTile(tileFour, 4);
		
		if (!tester.column(1).equals("BLACK")) return false;
		if (!tester.column(2).equals("ORANGE BLUE")) return false; 
		if (!tester.column(3).equals("")) return false;
		
		if (tester.getColumnsNumber() != 5) return false;
		
		tester.clearColumn(2);
		if (!tester.column(2).equals("")) return false;
		
		tester.restartGame();
		for (int i = 0; i < 5; i++) {
			if (!tester.column(i).equals("")) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Equals Tester: " + tileEqualsTester());
		System.out.println("Iterator Tester: " + tileListIteratorTester());
		System.out.println("Stack Tester: " + tileStackTester());
		System.out.println("Game Tester: " + tileMatchingGameTester());
	}
}