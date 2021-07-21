
import java.util.Scanner;

import com.example.DAO.AccountsDAO;
import com.example.DAO.AccountsDB;
import com.example.DAO.UserDB;
import com.example.DAO.UserDao;
import com.example.Logging.Logging;
import com.example.Models.Account;
import com.example.Models.User;
import com.example.Services.AccountServices;
import com.example.Services.UserServices;

public class BDriver {

	private static UserDao uDao = new UserDB();
	private static AccountsDAO aDao = new AccountsDB();
	private static UserServices uServ = new UserServices(uDao);
	private static AccountServices aServ = new AccountServices(aDao);

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		User isEmp = new User();
		isEmp.setEmployee(false);
		boolean done = false;

		User u = null;
		Account a = new Account();

		while (!done) {
			if (u == null) {
				boolean login = false;
				System.out.println("Login or Signup? Press 1 to Login, Press 2 to Signup");
				int choice = Integer.parseInt(in.nextLine());
				if (choice == 1) {
					System.out.print("Please enter your username: ");
					String username = in.nextLine();
					System.out.print("Please enter your password: ");
					String password = in.nextLine();
					try {
						u = uServ.signIn(username, password);
						System.out.println("Welcome " + u.getFirstName() + "!");
						login = true;
					} catch (Exception e) {
						System.out.println("Username or password was incorrect. Goodbye");
						done = true;
					}
					if (login) {
						System.out.println("What would you like to do?");
						System.out.println(
								"1. View account balance \n2. Create a new account\n3. Deposit\n4. Withdraw\n5. Quit");
						choice = Integer.parseInt(in.nextLine());
						if (choice == 1) {
							System.out.println("Your current balance is: $" + aDao.getAccountByUser(u).getBal());
							done = true;
						} else if (choice == 2) {
							System.out.println(
									"Please enter the type of account you would like to create, 1 for checking, 2 for savings:");
							choice = Integer.parseInt(in.nextLine());
							if (choice == 1) {
								String type = "checking";
								System.out.println("Please enter the amount you'd like to deposit initially:");
								double amount = Double.parseDouble(in.nextLine());
								try {
									a = aServ.makeNewBankAccount(amount, u, type);
									System.out.println("Your " + a.getType().toLowerCase()
											+ " account with account number " + a.getAccNum() + "has been created.");
									done = true;

								} catch (Exception e) {
									Logging.logger.error("Main: " + e);
									System.out.println("Sorry, we could not process your request.");
									System.out.println("Please try again later.");
									done = true;
								}

							} else if (choice == 2) {
								String type = "savings";
								System.out.println("Please enter the amount you'd like to deposit initially:");
								double amount = Double.parseDouble(in.nextLine());
								try {
									a = aServ.makeNewBankAccount(amount, u, type);
									System.out.println("Your " + a.getType().toLowerCase()
											+ " account with account number " + a.getAccNum() + "has been created.");
									done = true;

								} catch (Exception e) {
									System.out.println("Sorry, we could not process you request.");
									System.out.println("Please try again later.");
									done = true;
								}

							} else {
								System.out.println("Please enter a valid choice.");
								continue;
							}

						} else if (choice == 3) {
							System.out.print("Please enter the number of the account to deposit to: ");
							int accNum = in.nextInt();
							System.out.print("Please enter an amount you would like to deposit: $");
							double amount = in.nextDouble();
							aServ.makeDeposit(amount, a.getBal(), a);
							System.out
									.println("Your new account balance is: $" + aDao.getAccountByNum(accNum).getBal());
							done = true;

						} else if (choice == 4) {
							System.out.print("Please enter the account number of the account to withdraw from: ");
							System.out.print("Please enter an amount you would like to withdraw: $");
							double amount = Double.parseDouble(in.nextLine());
							aServ.makeWithdrawal(amount);

							System.out.println("Your new account balance is: $" + a.getBal());
						} else if (choice == 5) {
							System.out.println("Thanks for using the Bank of AJ!");
							done = true;
						} else {
							System.out.println("Please enter a valid choice.");
						}
					}
				} else if (choice == 2) {
					System.out.print("Please enter your first name: ");
					String first = in.nextLine();
					System.out.print("Please enter your last name: ");
					String last = in.nextLine();
					System.out.print("Please enter your email: ");
					String email = in.nextLine();
					System.out.print("Please enter a password: ");
					String password = in.nextLine();
					try {
						u = uServ.signUp(first, last, email, password, false);
						System.out.println("You may now log in with the username: " + u.getUsername());
						done = true;
					} catch (Exception e) {
						System.out.println("Sorry, we could not process your request");
						System.out.println("Please try again later");
						done = true;
					}
				}
			}
		}
		System.out.println("See ya!!!");
		in.close();

	}
}