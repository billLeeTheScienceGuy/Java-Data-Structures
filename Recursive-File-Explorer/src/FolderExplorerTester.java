import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unit testing suite to verify the file traversal logic and exception handling
 * of the FolderExplorer class.
 * @author Bill Lee
 */
public class FolderExplorerTester {
	
	/**
	 * Tests the functionality of the getContents method.
	 * @param folder the testing directory.
	 * @return true if the test passes without errors.
	 */
	public static boolean testGetContents(File folder) {
		try {
			ArrayList<String> listContent = FolderExplorer.getContents(folder);
			String[] contents = new String[] { "exams preparation", "grades", "lecture notes", "programs",
					"reading notes", "syllabus.txt", "todo.txt" };
			List<String> expectedList = Arrays.asList(contents);
			
			if (listContent.size() != 7) {
				System.out.println("Problem detected: cs300 folder must contain 7 elements.");
				return false;
			}
			for (int i = 0; i < expectedList.size(); i++) {
				if (!listContent.contains(expectedList.get(i))) {
					System.out.println("Problem detected: " + expectedList.get(i)
							+ " is missing from the output of the list contents.");
					return false;
				}
			}
			
			File f = new File(folder.getPath() + File.separator + "grades");
			listContent = FolderExplorer.getContents(f);
			if (listContent.size() != 0) {
				System.out.println("Problem detected: grades folder must be empty.");
				return false;
			}
			
			f = new File(folder.getPath() + File.separator + "programs" + File.separator + "p02");
			listContent = FolderExplorer.getContents(f);
			if (listContent.size() != 1 || !listContent.contains("FishTank.java")) {
				System.out.println("Problem detected: p02 folder must contain only one file named FishTank.java.");
				return false;
			}

			f = new File(folder.getPath() + File.separator + "todo.txt");
			try {
				listContent = FolderExplorer.getContents(f);
				System.out.println("Problem detected: Must throw a NotDirectoryException if provided input is not a directory.");
				return false;
			} catch (NotDirectoryException e) { 
				// expected behavior
			}

			f = new File(folder.getPath() + File.separator + "music.txt");
			try {
				listContent = FolderExplorer.getContents(f);
				System.out.println("Problem detected: Must throw a NotDirectoryException if File does not exist.");
				return false;
			} catch (NotDirectoryException e) {
				// expected behavior
			}
		} catch (Exception e) {
			System.out.println("Problem detected: Non-expected exception thrown.");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Tests the base functionality of the getDeepContents method.
	 * @param folder the testing directory.
	 * @return true if the test passes.
	 */
	public static boolean testDeepGetContentsBaseCase(File folder) {
		try {
			File file = new File(folder.getPath() + File.separator + "reading notes");
			ArrayList<String> contents = new ArrayList<String>(FolderExplorer.getDeepContents(file));
			String[] expectedContents = new String[] { "zyBooksCh1.txt", "zyBooksCh2.txt", "zyBooksCh3.txt",
					"zyBooksCh4.txt" };
			List<String> expectedList = Arrays.asList(expectedContents);
			if (contents.size() != 4) {
				System.out.println("Problem detected: reading notes folder must contain 4 elements.");
				return false;
			}
			if (!contents.equals(expectedList)) {
				System.out.println("Error: base case of getDeepContents returning incorrectly.");
				return false;
			}
		} catch (NotDirectoryException e) {
			System.out.println(e);
			return false;
		} 
		catch (Exception e) {
			System.out.println("Error: Exception thrown.");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Tests the recursive functionality of the getDeepContents method.
	 * @param folder the testing directory.
	 * @return true if the test passes.
	 */
	public static boolean testDeepListRecursiveCase(File folder) {
		try {
			File file = new File(folder.getPath() + File.separator + "lecture notes" + File.separator + "unit1");
			ArrayList<String> contents = new ArrayList<String>(FolderExplorer.getDeepContents(file));
			String[] expectedContents = new String[] { "ExceptionHandling.txt", "proceduralProgramming.txt",
					"UsingObjects.txt" };
			List<String> expectedList = Arrays.asList(expectedContents);
			if (contents.size() != 3) {
				System.out.println("Problem detected: unit1 folder must contain 3 elements.");
				return false;
			}
			if (!contents.equals(expectedList)) {
				System.out.println("Error: recursive case of getDeepContents returning incorrectly.");
			}
		} catch (NotDirectoryException e) {
			System.out.println(e);
			return false;
		} catch (Exception e) {
			System.out.println("Error: Exception thrown.");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Tests the lookupByName method.
	 * @param folder the testing directory.
	 * @return true if the test passes.
	 */
	public static boolean testLookupByFileName(File folder) {
		String fileName = "zyBooksCh1.txt";
		String correctPath = "cs300\\reading notes\\zyBooksCh1.txt";
		if (!correctPath.equals(FolderExplorer.lookupByName(folder, fileName))) {
			System.out.println("Error: Output of lookupByName does not match expected output.");
			return false;
		}
		return true;
	}

	/**
	 * Tests the base case of the lookupByKey method.
	 * @param folder the testing directory.
	 * @return true if the test passes.
	 */
	public static boolean testLookupByKeyBaseCase(File folder) {
		try {
			File file = new File(folder.getPath() + File.separator + "exams preparation" + File.separator + "exam1");
			ArrayList<String> contents = new ArrayList<String>(FolderExplorer.lookupByKey(file, ".java"));
			String[] expectedContents = new String[] { "codeSamples.java" };
			List<String> expectedList = Arrays.asList(expectedContents);
			if (contents.size() != 1) {
				System.out.println("Problem detected: should be only one .java file in folder.");
				return false;
			}
			if (!contents.equals(expectedList)) {
				System.out.println("Error: base case of lookupByKey returning incorrectly.");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error: Exception thrown.");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Executes the entire test suite.
	 * @param folder the testing directory.
	 * @return true if all tests pass.
	 */
	public static boolean runAllTests(File folder) {
		if (testGetContents(folder) == false) {
			System.out.println("Error: testGetContents is returning false");
			return false;
		}
		if (testDeepGetContentsBaseCase(folder) == false) {
			System.out.println("Error: testDeepGetContentsBaseCase is returning false");
			return false;
		}
		if (testDeepListRecursiveCase(folder) == false) {
			System.out.println("Error: testDeepListRecursiveCase is returning false");
			return false;
		}
		if (testLookupByFileName(folder) == false) {
			System.out.println("Error: testLookupByFileName is returning false");
			return false;
		}
		if (testLookupByKeyBaseCase(folder) == false) {
			System.out.println("Error: testLookupByKeyBaseCase is returning false");
			return false;
		} else {
			System.out.println("All tests passed");
			return true;
		}
	}

	public static void main(String[] args) {
		System.out.println(runAllTests(new File("cs300")));
	}
}