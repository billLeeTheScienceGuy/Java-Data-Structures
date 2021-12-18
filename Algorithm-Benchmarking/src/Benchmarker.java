/**
 * A profiling utility to measure and compare the CPU execution time of different algorithms.
 * @author Bill Lee
 */
public class Benchmarker {
	
	/**
	 * Measures the execution time required for the brute-force algorithm to complete.
	 * @param ph the target PasswordHacker instance.
	 * @return the execution time in milliseconds.
	 */
	public static long timeBruteForce(PasswordHacker ph) {
		long startTime = System.currentTimeMillis();
		ph.bruteForce();
		return (System.currentTimeMillis() - startTime);
	}

	/**
	 * Measures the execution time required for the direct-access hack algorithm to complete.
	 * @param ph the target PasswordHacker instance.
	 * @return the execution time in milliseconds.
	 */
	public static long timeHack(PasswordHacker ph) {
		long startTime = System.currentTimeMillis();
		ph.hack();
		return (System.currentTimeMillis() - startTime);
	}

	/**
	 * Executes a comparative race between algorithms over a specified number of runs to calculate an average execution time.
	 * @param passwordLength the length of the passcode for the testing objects.
	 * @param numRuns the number of iterations to run the race for averaging purposes.
	 * @return a formatted string detailing the average execution times in milliseconds.
	 */
	public static String race(int passwordLength, int numRuns) {
		long bruteForceTime = 0;
		long hackTime = 0;

		for (int i = 0; i < numRuns; i++) {
			PasswordHacker lockBox = new PasswordHacker(passwordLength);
			bruteForceTime += timeBruteForce(lockBox);
			hackTime += timeHack(lockBox);
		}
		
		return "Brute force " + passwordLength + ": " + (bruteForceTime / numRuns) + "\nHack " + passwordLength + ": "
				+ (hackTime / numRuns);
	}

	public static void main(String[] args) {
		System.out.println(race(8, 1));
	}
}