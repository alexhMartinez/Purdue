import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class IT391_Martinez_Unit3_PartB {
	
	private static void Section1() {
	//*********************************************************
	//****Assignment 3, Part B, Section 1
	//*********************************************************
		ArrayList<String> mammals = new ArrayList<String>();
			mammals.add("Bears");
			mammals.add("Gorilla");
			mammals.add("Tiger");
			mammals.add("Polar Bear");
			mammals.add("Lion");
			mammals.add("Monkey");
			
		HashSet<String> setMammals = new HashSet<String>(mammals);
	
		System.out.println("*********** Section: 1 ***********");
		System.out.println("Contents of the set are: ");
		System.out.println(setMammals);
	
		TreeSet<String> ts = new TreeSet<>();
	
			ts.addAll(setMammals);
			
		System.out.println("Contents of teh sorted set are: ");
		System.out.println(ts);
		System.out.println();
		
		System.out.println("The first item in the set is: ");
		System.out.println(ts.first());
		System.out.println();
		
		System.out.println("The last item in the set is: ");
		System.out.println(ts.last());	
	}
	
	private static void Section2() {
	//*********************************************************
	//****Assignment 3, Part B, Section 2
	//*********************************************************
		LinkedList<String> myFriends = new LinkedList<String>();
		
			myFriends.add("Fred 602-299-3300");
			myFriends.add("Ann 602-555-4949");
			myFriends.add("Grace 520-544-9898");
			myFriends.add("Sam 602-343-8723");
			myFriends.add("Dorothy 520-689-9745");
			myFriends.add("Susan 520-981-8745");
			myFriends.add("Bill 520-456-9823");
			myFriends.add("Mary 520-788-3457");
			
		System.out.println();
		System.out.println("*********** Section: 2 ***********");
		System.out.println();
		
		System.out.println("The contents of my friends list: ");
		System.out.println();
		for(String item: myFriends) {
			System.out.println(item);
		}
		System.out.println();
		
			myFriends.remove("Bill 520-456-9823");
			Collections.sort(myFriends);
			myFriends.remove();
			myFriends.removeLast();
			myFriends.set(myFriends.indexOf("Mary 520-788-3457"), "Mary 520-897-4567");
			
		System.out.println("The updated contents of my friends list: ");
		System.out.println();
		for(String item: myFriends) {
			System.out.println(item);
		}
		System.out.println();
		
		System.out.println("The number of friends in my list is: ");
		System.out.println();
		System.out.println(myFriends.size());
		System.out.println();
		
		boolean fredCheck = myFriends.contains("Fred 602-299-3300");
		
		if(fredCheck) {
			System.out.println("Fred is still in the list");
		}
		else {
			System.out.println("Fred is not still on the list");
		}
	}
	
	private static void Section3() {
	//*********************************************************
	//****Assignment 3, Part B, Section 3
	//*********************************************************
		BinaryTree bt = new BinaryTree();
			bt.insert(50);
			bt.insert(30);
			bt.insert(45);
			bt.insert(12);
			bt.insert(29);
		
		System.out.println();
		System.out.println("********** Section 3 **********");
		System.out.println();
		
		System.out.println("Traversing the binary tree in order: ");
		System.out.println();
		bt.inOrder(bt.root);
		System.out.println();
		
		System.out.println("Traversing the binary tree in pre-order: ");
		System.out.println();
		bt.preOrder(bt.root);
		System.out.println();
		
		System.out.println("Traversing the binary tree in post-order: ");
		System.out.println();
		bt.postOrder(bt.root);
		System.out.println();
		
	}

	public static void main(String[] args) {
		
		Section1();
		Section2();
		Section3();

	}

}
