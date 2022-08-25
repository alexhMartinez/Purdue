
public class Recursion {
	
	private static int sequenceFib(int x) {
		if(x == 0) {
			return 0;
		}
		if(x == 1 || x == 2) {
			return 1;
		}
		return sequenceFib(x - 2) + sequenceFib(x - 1);
	}
	
	private static int factoral(int y) {
		if(y < 1) {
			return 1;
		}
		return y * factoral(y - 1);
		
	}
	
	public static void main(String[] args) {
		
		/*
		 * Section Inputs
		 */
		
		int fibNum = 10;
		int factoralMin = 1;
		int factoralMax = 4;
		
		//*********************************************************
		//****Assignment 1, Section 1
		//*********************************************************
		
		System.out.println();
		System.out.println("********** Section 1 **********");
		System.out.println();
		
		System.out.print("Recursive fibonacci " + fibNum + " number series: ");
		for(int i = 0; i <= fibNum; i++) {
			System.out.print(sequenceFib(i) + ",");
		}
		System.out.println();
		System.out.println();
		System.out.println("The fibonacci number for " + fibNum + " is: " +sequenceFib(fibNum));
		
		//*********************************************************
		//****Assignment 1, Section 2
		//*********************************************************
		
		System.out.println();
		System.out.println("********** Section 2 **********");
		System.out.println();
		
		System.out.print("Factoral values from 1-4: ");
		for(int i = factoralMin; i <= factoralMax; i++) {
			System.out.print(i + "!=" + factoral(i) + "  ");
		}
		
	}

}
