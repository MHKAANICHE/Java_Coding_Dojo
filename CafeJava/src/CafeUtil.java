import java.util.ArrayList;
import java.io.Console;
import java.util.Scanner;

public class CafeUtil {
	// requirements : implement four methods.
	
	/*	
	 * Cafe Java wants to implement a reward system for customers who always buy more drinks than they did the week before. To calculate how many drinks they need after 10 weeks, write a method that sums together every consecutive integer from 1 to 10 and returns the sum. In other words, add 1 + 2 + 3.. and so on up to 10 and return the result.
	 * Test your code before moving on! Don't forget to make an instance of your CafeUtil class to use in the test file. The number printed should be 55.
	 * 	Ninja Bonus: Add a parameter, numWeeks so that an admin can change the number from 10 to whatever they want.
	*/
	int getStreakGoal() {
		int sum = 0 ;
		for ( int i = 0; i<=10 ; i++) {
			sum += i ;
		}
		return sum ;
	};
	//	Ninja Bonus:
	int getStreakGoal(int numWeeks) {
		int sum = 0 ;
		for ( int i = 0; i<=numWeeks ; i++) {
			sum += i ;
		}
		return sum ;
	}
	
	/*	Given an array of item prices from an order, sum all of the prices in the array and return the total.
	 * Don't forget to test your code! Find the lines of test code for this method in TestCafe.java and uncomment it before you compile and run.
	 */
	double getOrderTotal(double[] prices) {
		double sum = 0 ; 
		for (double price : prices) {
			sum += price ;
		}
		return sum ;
	};
	
	/*
	 * Given an ArrayList of menu items (strings), print out each index and menu item.
	 * Sample output given an ArrayList with the items "drip coffee", "cappuccino", "latte" and "mocha"
	 * 0 drip coffee
	 * 1 cappuccino
	 * 2 latte
	 * 3 mochacopy
	 * Re-cap of ArrayList Syntax:
	 * String name = myArray.get(0); // to access an element in an ArrayList using an index
	 */
	void displayMenu(ArrayList<String> menuItems) {
		for (int count = 0; count < menuItems.size(); count++) {
			String message = count + " " + menuItems.get(count);
			System.out.println(message);
		}
		
	};
	
	
	/*
	 * Inside this method:
	 * Print this string to the console: "Please enter your name:"
	 * Then add this line of code to get user input from the terminal and store it in the variable userName:
	 * String userName = System.console().readLine();
	 * Next print the userName to the console, saying "Hello, [user name here]!"
	 * Next print "There are ___ people in front of you" using the number for how many people are ahead of them (how many items already in the array)
	 * Then, add the customer's name to the given customers list. And print the list.
	 * No need to return anything.
	 * myArray.add("Heidi"); // to add an item to an ArrayList
	 */
	void addCustomer(ArrayList<String> customers) {
		System.out.println("Please enter your name:");
		/* Console expection due to the Spring Boot IDE
		*String userName = System.console().readLine();
		* solution proposed by ChatGPT :
		* To handle input in a Spring Boot application, especially during development in an IDE, you can use the Scanner class or other input methods.
		*/
		Scanner scanner = new Scanner(System.in);
		String userName = scanner.nextLine();
		System.out.printf("Hello, %s%n", userName);
		System.out.printf("There are %d people in front of you%n",customers.size());
		customers.add(userName);
		System.out.println("Order ------  Customer Name%") ;
		for (int count = 0; count<customers.size();count++) {
			System.out.printf("%d 	------  %s%n",count,customers.get(count)) ;
		}
		System.out.printf("------------------------%n") ;		
	};
}
