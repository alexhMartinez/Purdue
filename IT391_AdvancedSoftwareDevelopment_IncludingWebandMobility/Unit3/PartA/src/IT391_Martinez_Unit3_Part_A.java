import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class IT391_Martinez_Unit3_Part_A {
	
	private static void Section1() {
	//*********************************************************
	//****Assignment 3, Part A, Section 1
	//*********************************************************
		String[] professions = {
				"Software Engineer",
				"Programmer",
				"Database Admin",
				"Network Admin",
				"Web Developer",
				"Program Manager"
		};
		
		//linked hash set required to maintain original list order 'HashSet' will order
		Set<String> set = new LinkedHashSet<String>();
			Collections.addAll(set, professions);
		
		SortedSet<String> sortedSet = new TreeSet<String>();
			sortedSet.addAll(set);
			
		System.out.println("*********** Section: 1 ***********");
		System.out.println();
		
		System.out.println("Original List:");
		System.out.println(set);
		System.out.println();
		
		System.out.println("Sorted List:");
		System.out.println(sortedSet);
		System.out.println();
	}
	
	private static void Section2() {
	//*********************************************************
	//****Assignment 3, Part A, Section 2
	//*********************************************************
		String[] bookList = {
				"To Kill a Mockingbird",
				"Huckleberry Finn",
				"Pride and Prejudice",
				"Brave New World",
				"Lord of the flies",
				"Alice in Wonderland",
				"The Old Man and the Sea",
				"Atlas Shrugged"
		};
		
		LinkedList<String> books = new LinkedList<String>();
			Collections.addAll(books, bookList);
		
		System.out.println();
		System.out.println("*********** Section: 2 ***********");
		System.out.println();
		
		System.out.println("Original Book List:");
		System.out.println(books);
		System.out.println();
		
		Collections.sort(books);
		System.out.println("Sorted Book List:");
		System.out.println(books);
		System.out.println();
		
		//remove second element in list --index starts at 0
		int index = 1;
		
		books.remove(index);
		books.remove();
		
		//reverse ordering to remove first element
		Collections.sort(books, Collections.reverseOrder());
		books.remove();
		//reverse back to original state
		Collections.sort(books);
		
		System.out.println("Book List After Deletions:");
		System.out.println(books);
		System.out.println();
		
		System.out.println("The number of items in my book list is:");
		int listSize = books.size();
		System.out.println(listSize);
		System.out.println();
		
		boolean listContains = books.contains("Brave New World");
		
		if(listContains) {
			System.out.println("The final book list contains 'Brave New World'");
		} 
		else {
			System.out.println("The final book list does not contain 'Brave New World'");
		}
		
	}
	
	private static void Section3() {
	//*********************************************************
	//****Assignment 3, Part A, Section 3
	//*********************************************************
		
		BinaryTree bt = new BinaryTree();
		bt.insert(50);
		bt.insert(30);
		bt.insert(45);
		bt.insert(12);
		bt.insert(29);
		
		System.out.println();
		System.out.println("*********** Section: 3 ***********");
		System.out.println();
		System.out.println("The contents of the binary tree are: ");
		bt.inOrder(bt.root);
	}

	public static void main(String[] args) {
		
		Section1();
		Section2();
		Section3();
	}
}