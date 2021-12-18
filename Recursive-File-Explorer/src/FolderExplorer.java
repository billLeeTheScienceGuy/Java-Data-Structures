import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A utility class containing recursive functions to explore directories, 
 * traverse file systems, and query files based on specific attributes.
 * @author Bill Lee
 */
public class FolderExplorer {
	
	/**
	 * Returns a list of the names of all files and directories in the given folder.
	 * @param currentDirectory the directory to inspect.
	 * @return a list of file and directory names.
	 * @throws NotDirectoryException if the provided currentDirectory does not exist or is not a directory.
	 */
	public static ArrayList<String> getContents(File currentDirectory) throws NotDirectoryException {
		ArrayList<String> listNames = new ArrayList<>();
		if (!currentDirectory.isDirectory()) {
			throw new NotDirectoryException("What you have selected is not a directory");
		} else {
			for (int i = 0; i < currentDirectory.list().length; ++i) {
				listNames.add(currentDirectory.list()[i]);
			}
		}
		return listNames;
	}

	/**
	 * Recursively lists the names of all the files (excluding directories) 
	 * in the given directory and its sub-directories.
	 * @param currentDirectory the directory to begin traversal from.
	 * @return a comprehensive list of all file names within the directory tree.
	 * @throws NotDirectoryException if the provided currentDirectory does not exist or is not a directory.
	 */
	public static ArrayList<String> getDeepContents(File currentDirectory) throws NotDirectoryException {
		ArrayList<String> listNames = new ArrayList<>();
		if (!currentDirectory.isDirectory()) {
			throw new NotDirectoryException("What you have selected is not a directory");
		} else {
			for (int i = 0; i < currentDirectory.listFiles().length; ++i) {
				if (!currentDirectory.listFiles()[i].isDirectory()) {
					listNames.add(currentDirectory.list()[i]);
				} else {
					listNames.addAll(getDeepContents(currentDirectory.listFiles()[i]));
				}
			}
		}
		return listNames;
	}

	/**
	 * Searches the given directory and all of its sub-directories for an exact match to the provided fileName.
	 * @param currentDirectory the directory to begin the search from.
	 * @param fileName the exact name of the file being searched for.
	 * @return the absolute path to the file, if it exists.
	 * @throws NoSuchElementException if the search operation returns no results or if inputs are invalid.
	 */
	public static String lookupByName(File currentDirectory, String fileName) {
		if (fileName == null || !currentDirectory.isDirectory() || !currentDirectory.exists()) {
			throw new NoSuchElementException("Error: File is corrupted or isn't a directory");
		}
		
		String store = "Base";
		for (int i = 0; i < currentDirectory.listFiles().length && store.equals("Base"); ++i) {
			if (currentDirectory.listFiles()[i].isFile()
					&& currentDirectory.listFiles()[i].getName().equals(fileName)) {
				return currentDirectory.listFiles()[i].getPath();
			}
			if (currentDirectory.listFiles()[i].isDirectory()) {
				try {
					store = lookupByName(currentDirectory.listFiles()[i], fileName);
				} catch (NoSuchElementException e2) {
				}
			}
		}
		
		if (store.equals("Base")) {
			throw new NoSuchElementException("The file doesn't exist");
		}
		return store;
	}

	/**
	 * Recursively searches the given folder and its sub-directories for ALL files 
	 * that contain the given key string in their name.
	 * @param currentDirectory the directory to search within.
	 * @param key the substring keyword to match file names against.
	 * @return an ArrayList of all matching file names.
	 */
	public static ArrayList<String> lookupByKey(File currentDirectory, String key) {
		ArrayList<String> store = new ArrayList<>();
		for (int i = 0; i < currentDirectory.listFiles().length; ++i) {
			if (!currentDirectory.listFiles()[i].isFile()) {
				store.addAll(lookupByKey(currentDirectory.listFiles()[i], key));
			} else if (currentDirectory.listFiles()[i].getName().contains(key)) {
				store.add(currentDirectory.listFiles()[i].getName());
			}
		}
		return store;
	}

	/**
	 * Recursively searches the given folder and its sub-directories for ALL files 
	 * whose size is within the given min and max byte boundaries, inclusive.
	 * @param currentDirectory the directory to search within.
	 * @param sizeMin the minimum byte size threshold.
	 * @param sizeMax the maximum byte size threshold.
	 * @return an ArrayList of the names of all files falling within the size boundaries.
	 */
	public static ArrayList<String> lookupBySize(File currentDirectory, long sizeMin, long sizeMax) {
		ArrayList<String> store = new ArrayList<>();
		for (int i = 0; i < currentDirectory.listFiles().length; ++i) {
			if (!currentDirectory.listFiles()[i].isFile()) {
				store.addAll(lookupBySize(currentDirectory.listFiles()[i], sizeMin, sizeMax));
			}
			else if (currentDirectory.listFiles()[i].getTotalSpace() >= sizeMin
					&& currentDirectory.listFiles()[i].getTotalSpace() <= sizeMax) {
					store.add(currentDirectory.listFiles()[i].getName());
				}
			}
		
		return store;
	}
}