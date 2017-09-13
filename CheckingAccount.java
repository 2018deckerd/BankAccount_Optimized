import java.util.Arrays;

/**
 * A checking account that does not accumulate any interest and offers three free withdrawals
 * @author dylandecker
 *
 */

public class CheckingAccount extends BankAccount {
	
	static int[] transactionHolder = new int[99];
	static int[] transactionCount = new int[99];
	static int transactionFee = 1;

	public CheckingAccount(String name, int accountNumber) {
		super (name, accountNumber);
	}
	

	public static double getTFee(int accountNumber) {
		if (transactionCount[accountNumber] >= 4) {
			return transactionCount[accountNumber] - 3;
		} else {
			return 0;
		}
	
}
	
	public static void transaction(int accountNumber) {
		transactionCount[accountNumber] = transactionCount[accountNumber] + 1;
	}
	
	public static void monthEnd() {
		transactionCount = new int[99];
		Arrays.fill(transactionCount, 0);
	}
	
	
	

}
