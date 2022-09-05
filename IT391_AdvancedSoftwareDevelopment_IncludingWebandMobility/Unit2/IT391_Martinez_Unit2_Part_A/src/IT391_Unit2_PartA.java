import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IT391_Unit2_PartA {
	
	static void revString(String str) {
		
		String[] words = str.split(" ");
		String revString = "";
		
		for (int i = 0; i < words.length; i++) {
			
	           String word = words[i]; 
	           String revWord = "";
	           
	           for (int j = word.length()-1; j >= 0; j--) {
	        	   revWord = revWord + word.charAt(j);
	           }
	           revString = revString + revWord + " ";
		}

		System.out.println(revString.toLowerCase());
	}
	
	@SuppressWarnings("resource")
	public static void Section1() {
	//*********************************************************
	//****Assignment 2, Part A, Section 1
	//*********************************************************
		System.out.println("********** Section 1 **********");
		System.out.println();

		Scanner userWord = new Scanner(System.in);
		System.out.println("Please enter any word(s): ");
		
		String wordToReverse = userWord.nextLine();
		System.out.println();
		System.out.print("Your word(s) in reverse is: ");
		revString(wordToReverse);
	}
	
	public static void Section2() {
	//*********************************************************
	//****Assignment 2, Part A, Section 2
	//*********************************************************
		System.out.println();
		System.out.println("********** Section 2 **********");
		System.out.println();
		
		String groceryLine = "Jane,Bob,Liza,Tom,Mary";
		
		String[] words = groceryLine.split(",");
	    Queue<String> str_queue = new LinkedList<>();
	    str_queue.addAll(Arrays.asList(words));
	    
		System.out.println("The number of shoppers at the grocery store is, " + str_queue.size());
		System.out.println("The first shopper in line is, " + str_queue.peek());
		System.out.println();
		
		str_queue.remove(str_queue.peek());
		str_queue.remove(str_queue.peek());
		str_queue.remove(str_queue.peek());
		str_queue.add("Ellen");
		str_queue.add("Stephen");
		
		System.out.println("The number of shoppers now in line is, " + str_queue.size());
		System.out.println("The shopper currently first in line is, " + str_queue.peek());
	}
	
	public static void main(String[] args) {
		
		while(true) {
			@SuppressWarnings("resource")
			Scanner inputCont = new Scanner(System.in);
			
			System.out.println("Would you like to begin unit 2 assignment part A? (y/n)");
			String cont1 = inputCont.nextLine();
			
			if(cont1.equalsIgnoreCase("n")) {
				break;
			}
			
			System.out.println();
			Section1();
			System.out.println();
			System.out.println("Would you like to continue to section 2? (y/n)");
			String cont2 = inputCont.nextLine();
			
			if(cont2.equalsIgnoreCase("n")) {
				break;
			}
			
			System.out.println();
			Section2();
			
			break;
		}
	}
}