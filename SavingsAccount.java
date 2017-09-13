/**
 * A savings account that accumulates interest monthly
 * @author Dylan Decker
 *
 */
public class SavingsAccount extends BankAccount {
	
	
	static double hold;
	static double interestRate = 6;
	

	public SavingsAccount(String name, int accountNumber) {
		super(name, accountNumber);
	
	}
	
	public static double returnMinimum(double num1, double num2) {
		double hold = 0;
		 for (int i = 0; i < 2; i++) {
			hold = num1;
			if (num2 < num1) {
				hold = num2;
			} else if (num1 == 0){
				hold = num2;
			} else {
				hold = num1;
			}
		 }
		return hold;
	 
	}

	public static double computeInterest(double minimum) {
		double value = (minimum * interestRate) / 100;
		return value;
	
}

	
	
	public void monthEnd() {
		
	}
}