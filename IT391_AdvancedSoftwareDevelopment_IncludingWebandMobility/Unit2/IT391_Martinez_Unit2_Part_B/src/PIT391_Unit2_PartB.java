import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PIT391_Unit2_PartB {
	
	public static void Section1() {
	//*********************************************************
	//****Assignment 2, Part B, Section 1
	//*********************************************************
		System.out.println("********** Section 1 **********");
		System.out.println();
		
		String BankLine = "Jim,Bob,Susan,Liz,Alex";
		
		String[] words = BankLine.split(",");
	    Queue<String> str_queue = new LinkedList<>();
	    str_queue.addAll(Arrays.asList(words));

	    int queueSize = str_queue.size();
	    String queuePeek = str_queue.peek();
	    
	    System.out.println("The number of people in line at the bank is, " + queueSize);
	    System.out.println("The names of those in line at the bank are: " + str_queue);
	    System.out.println("The first customer in line is " + queuePeek);
	    
	    str_queue.remove(str_queue.peek());
	    str_queue.add("Andy");
	    str_queue.add("Rhonda");
	    
	    System.out.println("The number of customers in the line now is, " + str_queue.size());
	    
	    str_queue.remove(str_queue.peek());
	    str_queue.remove(str_queue.peek());
	    str_queue.remove(str_queue.peek());
	    
	    System.out.println("The number of customers in the line now is, " + str_queue.size());
	}
	
	@SuppressWarnings("resource")
	public static void Section2() {
		//*********************************************************
		//****Assignment 2, Part B, Section 2
		//*********************************************************
		Stack<String>stack = new Stack<>();
		
		System.out.println();
		System.out.println("*********** Section: 2 ***********");
		System.out.println();
		
		Scanner inputSentence = new Scanner(System.in);
		System.out.println("Please enter a sentence:");
		String s = inputSentence.nextLine();
		System.out.println();
		
		String[] words = s.split(" ");
		stack.addAll(Arrays.asList(words));
		
		Collections.reverse(stack);
		stack.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		
		while(true) {
			@SuppressWarnings("resource")
			Scanner inputCont = new Scanner(System.in);
			
			System.out.println("Would you like to begin unit 2 assignment part B? (y/n)");
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
