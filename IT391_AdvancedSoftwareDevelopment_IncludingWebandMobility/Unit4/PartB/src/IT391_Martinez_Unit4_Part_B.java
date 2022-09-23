import java.util.Arrays;

public class IT391_Martinez_Unit4_Part_B {
	
	static void printArray(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; ++i)
        System.out.print(arr[i] + ",");
        System.out.println();
    }
	
	static int[] studentGrades = new int[] {65,95,75,55,56,90,98,88,97,78};
	static int[] origGrades = Arrays.copyOf(studentGrades,studentGrades.length);

	public static void main(String[] args) {
		
		//*********************************************************
		//****Assignment 4, Part B, Section 1
		//*********************************************************
		
		System.out.println("********** Section 1 – Bubble Sort **********");
		System.out.println();
		
		System.out.println("The unsorted list of grades is,");
		printArray(studentGrades);
		System.out.println();
		
		System.out.println("The grades in descending order are,");
		sortArrayDescBS.sort(studentGrades);
		System.out.println();
		
		System.out.println("The grades in ascending order are,");
		sortArrayAscBS.sort(studentGrades);
		System.out.println();
		
		//*********************************************************
		//****Assignment 4, Part B, Section 2
		//*********************************************************
		System.out.println();
		System.out.println("********** Section 2 – Quick Sort **********");
		System.out.println();
		
		System.out.println("The unsorted list of grades is,");
		printArray(origGrades);
		System.out.println();
		
		System.out.println("The grades in descending order are,");
		sortArrayDescQS.sort(origGrades,0,origGrades.length - 1);
		sortArrayDescQS.printArr(origGrades);
		System.out.println();
		
		System.out.println("The grades in ascending order are,");
		sortArrayAscQS.sort(origGrades,0,origGrades.length - 1);
		sortArrayAscQS.printArr(origGrades);
		System.out.println();
		
		//*********************************************************
		//****Assignment 4, Part B, Section 3
		//*********************************************************
		System.out.println();
		System.out.println("********** Section 3 – Sequential Search **********");
		System.out.println();
		
		System.out.println("The contents of the grade array are,");
		printArray(origGrades);
		System.out.println();
		seqSearch.search(origGrades, 75);
		System.out.println();
		seqSearch.search(origGrades, 60);
		System.out.println();
		
		//*********************************************************
		//****Assignment 4, Part B, Section 4
		//*********************************************************
		System.out.println();
		System.out.println("********** Section 4 – Binary Search **********");
		System.out.println();
		
		System.out.println("The contents of the grade array are,");
		printArray(origGrades);
		System.out.println();
		binarySearch.search(origGrades, 56);
		System.out.println();
		binarySearch.search(origGrades, 50);
		System.out.println();
	}

}
