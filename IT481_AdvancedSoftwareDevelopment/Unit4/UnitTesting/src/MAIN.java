import java.util.stream.IntStream;

public class MAIN {

	public static void main(String[] args) {
		
		int maxEmployeeID = 5;
		int maxCarID = 15;
		int minEmployeeID = 1;
		int minCarID = 3;
		
		int[] Array1 = IntStream.range(minEmployeeID, maxEmployeeID).toArray();
		int[] Array2 = IntStream.range(minCarID, maxCarID).toArray();
		
		System.out.println("[Module 1.1] The lowest employee id is: "
				+UnitTests.Example1(Array1));
		System.out.println("[Module 1.2] The lowest car id is: "
				+UnitTests.Example1(Array2));
		System.out.println();
		
		System.out.println("[Module 2.1] Every employee id is:");
		UnitTests.Example2(Array1);
		System.out.println("[Module 2.2] Every car id is:");
		UnitTests.Example2(Array2);
		System.out.println();
		
		System.out.println("[Module 3.1]");
		UnitTests.Example3(Array1);
		System.out.println("[Module 3.2]");
		UnitTests.Example3(Array2);
		System.out.println();
		
	}

}
