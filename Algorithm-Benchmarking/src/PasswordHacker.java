/**
 * Implements and executes different algorithmic approaches to unlock a target LockBox.
 * @author Bill Lee
 */
public class PasswordHacker {
	private LockBox toPick;
	private int passwordLength;

	/**
	 * Initializes the hacking suite against a new lockbox of a specified complexity.
	 * @param passwordLength the length of the passcode for the target lockbox.
	 */
	public PasswordHacker(int passwordLength) {
		this.passwordLength = passwordLength;
		toPick = new LockBox(passwordLength);
	}

	/** * Executes a direct-access exploit to unlock the box.
	 * Algorithmic Complexity: O(1) 
	 */
	public void hack() {
		toPick.reset();
		toPick.authenticate(toPick.hackMe());
	}

	/** * Executes an exhaustive search, guessing every possible combination sequentially.
	 * Algorithmic Complexity: O(10^N) 
	 */
	public void bruteForce() {
		toPick.reset();
		for (int i = 0; !(toPick.isOpen()); i++) {
			toPick.authenticate(generateGuess(i));
		}
	}

	/**
	 * Generates a formatted numeric string guess based on an iteration count.
	 * @param count the current iteration index of the brute-force algorithm.
	 * @return a zero-padded string matching the required password length.
	 */
	public String generateGuess(int count) {
		String guess = "";
		for (int i = 0; i < passwordLength; i++) {
			guess = (count % 10) + guess;
			count = count / 10;
		}
		return guess;
	}
}