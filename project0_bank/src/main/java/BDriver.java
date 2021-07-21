
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
					} catch (Exception e) {
						System.out.println("Username or password was incorect. Goodbye");
						done = true;
					}
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
								System.out.println("Your " + a.getType().toLowerCase() + " account with account number "
										+ a.getAccNum() + "has been created.");
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
								System.out.println("Your " + a.getType().toLowerCase() + " account with account number "
										+ a.getAccNum() + "has been created.");
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
						System.out.println("Please enter the number of the account to deposit to: ");
						int accNum = in.nextInt();
						System.out.println("Account: " + aDao.getAccountByNum(accNum));
						System.out.println("Please enter an amount you would like to deposit: ");
						double amount = in.nextDouble();
						System.out.println("Deposit amount: $" + amount);
						aServ.makeDeposit(amount, a.getBal());

						System.out.println("Your new account balance is: $" + aDao.getAccountByNum(accNum).getBal());
						done = true;
					} else if (choice == 4) {
						System.out.println("Please enter the account number of the account to withdraw from :");
						System.out.println("Account: " + aDao.getAccountByUser(u).getAccNum());
						System.out.println("Please enter an amount you would like to withdraw:");
						double amount = Double.parseDouble(in.nextLine());

						System.out.println("Withdraw amount: $" + amount);
						aServ.makeWithdrawal(amount);

						System.out.println("Your new account balance is: $" + a.getBal());
					} else if (choice == 5) {
						System.out.println("Thanks for using the Bank of AJ!");
						done = true;
					} else {
						System.out.println("Please enter a valid choice.");
					}
				}
			} else {
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
					continue;
				} catch (Exception e) {
					System.out.println("Sorry, we could not process your request");
					System.out.println("Please try again later");
					done = true;
				}
			}
		}
		System.out.println("See ya!!!");
		in.close();

	}
}

/*
 * else { System.out.println("To view posts press 1, to create a post press 2");
 * int choice = Integer.parseInt(in.nextLine()); // If the user chooses 1, we
 * will show them the list of posts if (choice == 1) { List<PostDisplay> posts =
 * pServ.getAllPosts(); for (PostDisplay post : posts) {
 * System.out.println(post.getUsername() + ":");
 * System.out.println(post.getContent()); System.out.println(); }
 * System.out.println("Are you finished? Press 1 for yes, press 2 for no");
 * choice = Integer.parseInt(in.nextLine()); done = (choice == 1) ? true :
 * false; } else { System.out.println("Please enter your content below:");
 * String content = in.nextLine(); pServ.addPost(u.getId(), u.getId(), content);
 * System.out.
 * println("Post was received, are you finished? Press 1 for yes, press 2 for no"
 * ); choice = Integer.parseInt(in.nextLine()); done = (choice == 1) ? true :
 * false; } } }
 */