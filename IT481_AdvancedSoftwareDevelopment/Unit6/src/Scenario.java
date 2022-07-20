import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Scenario {
	static int items;
	static int controlItemNumber;
	static int numberOfItems;
	static int totalRooms;
	static int numberOfCustomers;
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		
		System.out.print("What number of clothing items do you want? (for random number please enter 0)");
		
		controlItemNumber = in.nextInt();
		
		System.out.print("what is your number of customers?");
		numberOfCustomers = in.nextInt();
		
		System.out.println("How many dressing rooms do you require?");
		
		totalRooms = in.nextInt();
		
		in.close();
		
		dressRoom d = new dressRoom(totalRooms);
		
		for(int i = 0; i < numberOfCustomers; i++) {
		
			customers cust = new customers(controlItemNumber);
			
			numberOfItems = cust.getNumberOfItems();
			
			items += numberOfItems;
			
			d.requestRoom(numberOfItems);
		
		}
	
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	
		int averageItemsPerCustomer = items/numberOfCustomers;
		int convertTime = (int) TimeUnit.SECONDS.convert((d.getRunTime()/numberOfCustomers), TimeUnit.NANOSECONDS);
		
		System.out.println("The average number of items was: " + averageItemsPerCustomer);
	
		System.out.println("The average Run time in seconds " + convertTime);
	
		System.out.println("The average Wait time in seconds " + convertTime);
		
		System.out.println("Your total number of customers is " + numberOfCustomers);
	}
}