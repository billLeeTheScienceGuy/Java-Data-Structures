import java.util.Random;

/**
 * Defines a secure lockbox object that manages a numeric passcode and its authentication state.
 * @author Bill Lee
 */
public class LockBox {
	protected static Random randGen;
	private String password;
	private boolean isOpen;

	/**
	 * Generates a random numeric passcode of a specified length.
	 * @param passwordLength the number of digits in the generated passcode.
	 * @throws IllegalArgumentException if the length is zero or negative.
	 */
	public LockBox(int passwordLength) {
		if (randGen == null) {
			randGen = new Random();
		}
		if (passwordLength <= 0) {
			throw new IllegalArgumentException(
					"Password length must be greater than zero.");
		} else {
			password = "";
			for (int i = 0; i < passwordLength; ++i) {
				password += Integer.toString(randGen.nextInt(10));
			}
		}
	}

	/**
	 * Compares a provided guess to the password and updates the internal state if successful.
	 * @param guess the string value to authenticate against the stored password.
	 */
	public void authenticate(String guess) {
		if (password.equals(guess)) {
			isOpen = true;
		}
	}

	/**
	 * Bypasses standard authentication to return the raw password string.
	 * @return the plaintext password.
	 */
	public String hackMe() {
		return password;
	}

	/**
	 * Checks the current authentication status of the lockbox.
	 * @return true if the lockbox is open, false otherwise.
	 */
	public boolean isOpen() {
		return isOpen;
	}

	/**
	 * Resets the authentication state, securely closing the lockbox.
	 */
	public void reset() {
		isOpen = false;
	}
}