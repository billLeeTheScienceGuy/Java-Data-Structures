import java.util.NoSuchElementException;

/**
 * Tester class verifying the min-heap invariants and queue logic of the AssignmentQueue.
 * @author Bill Lee
 */
public class AssignmentQueueTester {
	
	public static boolean testConstructor() {
		try {
			AssignmentQueue test = new AssignmentQueue(-1);
			return false;
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			return false;
		}

		try {
			AssignmentQueue test = new AssignmentQueue(5);
			if (test.isEmpty() != true || test.size() != 0) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true; 
	}

	public static boolean testEnqueue() {
		try {
			AssignmentQueue tester = new AssignmentQueue(5);
			Assignment P1 = new Assignment("P1", 4, 1, 10);
			Assignment P2 = new Assignment("P2", 5, 1, 10);
			tester.enqueue(P1);
			if (tester.size() != 1 || tester.isEmpty() != false) {
				return false;
			}
			tester.enqueue(P2);
			if (tester.peek().equals(P1) == false) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true; 
	}

	public static boolean testDequeuePeek() {
		try {
			AssignmentQueue tester = new AssignmentQueue(6);
			Assignment P1 = new Assignment("P1", 4, 1, 10);
			Assignment P2 = new Assignment("P2", 5, 1, 10);
			tester.enqueue(P1);
			tester.enqueue(P2);

			if (tester.dequeue() != P1 || tester.size() != 1) {
				return false;
			}
			if (tester.peek() != P2) {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean testClear() {
		try {
			AssignmentQueue tester = new AssignmentQueue(6);
			Assignment P1 = new Assignment("P1", 4, 1, 10);
			Assignment P2 = new Assignment("P2", 5, 1, 10);
			tester.enqueue(P1);
			tester.enqueue(P2);
			tester.clear();
			
			if (tester.isEmpty() != true || tester.size() != 0) {
				return false;
			}
			try {
				tester.peek();
				return false;
			} catch (NoSuchElementException e) {
			}
		} catch (Exception e) {
		}
		return true; 
	}

	public static boolean runAllTests() {
		boolean passed = true;
		if (!testConstructor()) {
			System.out.println("testConstructor Failed");
			passed = false;
		}
		if (!testEnqueue()) {
			System.out.println("testEnqueue Failed");
			passed = false;
		}
		if (!testDequeuePeek()) {
			System.out.println("testDequeuePeek Failed");
			passed = false;
		}
		if (!testClear()) {
			System.out.println("testClear Failed");
			passed = false;
		}
		return passed;
	}

	public static void main(String[] args) {
		System.out.println("All Tests Passed: " + runAllTests());
	}
}