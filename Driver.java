import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Loops the menu
 * @author Dylan Decker
 *
 */
public class Driver {
	
	private static boolean quit = false;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the total number of accounts you have. (Defines array size)");
		int size = scanner.nextInt();
		String[] names = new String[size]; // holds array of account names
		int[] bankAccount = new int[size];
		double[] amount = new double[size];  // holds balance of checking account
		double[] amount2 = new double[size]; // holds balance of savings accounts
		double lowestBalance = 0;; // holds history of the lowest balance for calculating interest
		double first = 0;
		boolean value = false;
		String[] accountType = new String[size]; // holds account types
		for (int i = 0; i < size; i = i + 1) {
			System.out.println("Please enter the first name of account number " + (i + 1) + ".");
			names[i] = scanner.next();
		}
		for (int i = 0; i < size; i = i + 1) {
			System.out.println("What type of account does " + names[i] + " have? Default options are Checking or Savings account.");
			accountType[i] = scanner.next();
		}
		for (int i = 0; i < size; i++) {
			System.out.println("Please enter the account number for " + names[i] + "'s account.");
			bankAccount[i] = scanner.nextInt();
			System.out.println("Thank you.");
		}
		CheckingAccount ca = new CheckingAccount(CheckingAccount.getName(), CheckingAccount.getAccountNumber());
		SavingsAccount sa = new SavingsAccount(SavingsAccount.getName(), SavingsAccount.getAccountNumber());
		String accType = ""; // holds temporary account type
		while (quit != true) {
		  for (int i = 0; i < size; i++) {
			System.out.println("Please enter the name of the account you wish to edit.");
			String name = scanner.next();
			for (int j = 0; j < size; j++) {
				if (names[j].equalsIgnoreCase(name)) {
					accType = accountType[j];
				} 
			}
			if (accType.equalsIgnoreCase("Checking")) {
			BankAccount.printOut();
			String option = scanner.next();
			if (option.equalsIgnoreCase("D")) {
				System.out.println("Please enter the account number.");
				CheckingAccount.setAccountNumber(scanner.nextInt());
				for (int j = 0; j < size; j++) {
				if (bankAccount[j] == CheckingAccount.getAccountNumber()) {
						System.out.println("Please enter the amount you desire to deposit.: ");
						CheckingAccount.setAmount(Double.parseDouble(scanner.next()));
						amount[j] = amount[j] + CheckingAccount.getAmount();
						CheckingAccount.transaction(CheckingAccount.getAccountNumber());

						System.out.println("Your balance is: $" + (amount[j] - CheckingAccount.getTFee(CheckingAccount.getAccountNumber())));
					} else if (bankAccount[j] != CheckingAccount.getAccountNumber()) {
					
				}
				}
			} else if (option.equalsIgnoreCase("W")) {
				System.out.println("Please enter the account number: ");
				CheckingAccount.setAccountNumber(Integer.parseInt(scanner.next()));
				for (int j = 0; j < size; j++) {
					if (bankAccount[j] == SavingsAccount.getAccountNumber()) {
					System.out.println("Please enter the amount you desire to withdraw.: ");
					CheckingAccount.setAmount(Double.parseDouble(scanner.next()));
					amount[j] = amount[j] - CheckingAccount.getAmount();
					CheckingAccount.transaction(CheckingAccount.getAccountNumber());
					CheckingAccount.setBalance(amount[j] - CheckingAccount.getTFee(CheckingAccount.getAccountNumber()));
					System.out.println("Your balance is: $" + (amount[j]));
			}
			}
			}	else if (option.equalsIgnoreCase("M")) {
					CheckingAccount.monthEnd();
					System.out.println("Transaction count cleared.");
					for (int j = 0; j < size; j++) {
						System.out.println("The balance of " + names[j] + "'s account is: $" + (amount[j]));
				}
				
			} else if (option.equalsIgnoreCase("Q")) {
				quit = true;
				System.out.println("System terminated.");
			} else {
				System.out.println("Invalid input. Please check your spelling or input.");
			}
			}
		 
			
			if (accType.equalsIgnoreCase("Savings")) {
				BankAccount.printOut();
				String option = scanner.next();
				if (option.equalsIgnoreCase("D")) {
					System.out.println("Please enter the account number: ");
					SavingsAccount.setAccountNumber(Integer.parseInt(scanner.next()));
					for (int j = 0; j < size; j++) {
						if (bankAccount[j] == SavingsAccount.getAccountNumber()) {
							System.out.println("Please enter the amount you desire to deposit.: ");
							SavingsAccount.setAmount(Double.parseDouble(scanner.next()));
							first = amount2[j];
							amount2[j] = amount2[j] + SavingsAccount.getAmount();
							lowestBalance = SavingsAccount.returnMinimum(first, amount2[j]);
							System.out.println(first + "and" + amount2[j]);
							System.out.println("Your balance is: $" + (amount2[j]));
					}
				  }
				}else if (option.equalsIgnoreCase("W")) {
					System.out.println("Please enter the account number: ");
					CheckingAccount.setAccountNumber(Integer.parseInt(scanner.next()));
					for (int j = 0; j < size; j++) {
						if (bankAccount[j] == SavingsAccount.getAccountNumber()) {
						System.out.println("Please enter the amount you desire to withdraw.: ");
						SavingsAccount.setAmount(Double.parseDouble(scanner.next()));
						first = amount2[j];
						amount2[j] = amount2[j] - SavingsAccount.getAmount();
						lowestBalance = SavingsAccount.returnMinimum(first, amount2[j]);
						System.out.println("Your balance is: $" + amount2[j]);
					}
				  }
				} else if (option.equalsIgnoreCase("M")) {
					System.out.println("Accumulated interest computed. You accumulated " + SavingsAccount.computeInterest(lowestBalance) + " dollars.");
					for (int j = 0; j < size; j++) {
						if (bankAccount[j] == SavingsAccount.getAccountNumber()) {
							amount2[j] = amount2[j] + SavingsAccount.computeInterest(lowestBalance);
							System.out.println("Your new balance is: $" + amount2[j]);
						}
					}
				} else if (option.equalsIgnoreCase("Q")){
					quit = true;
					System.out.println("System terminated.");
				} else {
					System.out.println("Invalid input. Please check your spelling or input.");
				}
			}
		
		}
	}
  }
 
}
