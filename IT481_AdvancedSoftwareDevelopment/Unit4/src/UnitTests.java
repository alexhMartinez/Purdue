public class UnitTests {
	
	//finds min value in array of ints
	public static int Example1(int[] arrayOfInts) {
		
		int currmin = 1000;
		
		for (int i = 0; i < arrayOfInts.length; i++) {
			if (arrayOfInts[i] < currmin)
				currmin = arrayOfInts[i];
		}
		return currmin;
	}
	
	//print each value in array of ints
	public static void Example2(int[] arrayOfInts) {
		
		for (int i = 0; i < arrayOfInts.length; i++) {
			
			//not converted to delimit on string
			System.out.println(arrayOfInts[i]);
		}
	}
	
	//given two int search val if .equal() to val in the array
	public static void Example3(int[] arrayOfInts) {
		
		int a = 6;
		int b = 8;
		boolean found = false;
		
		for (int i = 0; i < arrayOfInts.length; i++) {
			if(a == arrayOfInts[i]) {
				System.out.println("The ID " + a + " was found in the array.");
				found = true;
			}
			else if (b == arrayOfInts[i]) {
				System.out.println("The ID " + b + " was found in the array.");
				found = true;
			}
		}
		if (found == false)
			System.out.println("None of the search IDs were found.");
	}
}
