
public class IT391_Martinez_Unit4_Part_A {
	
	public static void main(String[] args) {
		//*********************************************************
		//****Assignment 4, Part A, Section 1
		//*********************************************************
		int[] numsSec1 = {6501,9503,7757,5535,5601,9001,9888,8801,9767,7815};
		
		System.out.println("********** Section 1 – Quick Sort **********");
		System.out.println();
			
		System.out.println("Welcome to unit 4 part A!");
		System.out.println();
			
		System.out.println();
		System.out.print("The array unsorted is, ");
		sortAsc.printArr(numsSec1);
		System.out.println();
			
		sortAsc.sort(numsSec1,0,numsSec1.length - 1);
		System.out.print("The array sorted is, ");
		sortAsc.printArr(numsSec1);
		System.out.println();
			
		int[] finSortSec1 = numsSec1;
		
		//*********************************************************
		//****Assignment 4, Part A, Section 2
		//*********************************************************
			
		System.out.println("********** Section 2 – Bubble Sort **********");
		System.out.println();
		
		int[] numsSec2 = {5,90,35,45,150,3};
		
		System.out.println("The array unsorted is, ");
		sortAsc.printArr(numsSec2);
		System.out.println();
		
		System.out.println("The array sorted is, ");
		BubbleSort.sort(numsSec2);
		
		//*********************************************************
		//****Assignment 4, Part A, Section 3
		//*********************************************************
		
		int[] numsSec3 = {6501,9503,7757,5535,5601,9001,9888,8801,9767,7815};
		
		System.out.println();
		System.out.println("********** Section 3 – Binary Search **********");
		System.out.println();
		
		BinarySearch.search(numsSec3,8801);
		System.out.println();
		BinarySearch.search(finSortSec1, 7777);
		System.out.println();
		
		}
	}