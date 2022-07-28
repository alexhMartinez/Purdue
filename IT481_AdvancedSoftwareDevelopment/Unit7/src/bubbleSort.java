import java.util.Arrays;

public class bubbleSort {
	public static void bSort(int arr[]) {
		
        int arrayLength = arr.length;
        
        for (int i = 0; i < arrayLength - 1; i++)
            for (int j = 0; j < arrayLength - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
	
    public static void printArray(int arr[]) {
    	
        int arrayLength = arr.length;
        
        for (int i = 0; i < arrayLength; ++i)
        System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public static void bubbleSortResults(int small, int medium, int large) {
    	
    	int[] randSmallArray = ArrayBuilder.Generate(small);
		
		int[] randMediumArray = ArrayBuilder.Generate(medium);
		
		int[] randLargeArray = ArrayBuilder.Generate(large);
		
		/*
		 * print for small bubble sort arrays
		 */
		final long bSortSmallStartTime = System.currentTimeMillis();
		System.out.println("Unsorted and sorted arrays containing random numbers, and using bubble sort:");
		System.out.println();
		System.out.println("Unsorted small array - ");
		System.out.println(Arrays.toString(randSmallArray));
		bubbleSort.bSort(randSmallArray);
		System.out.println("Sorted small array - ");
		bubbleSort.printArray(randSmallArray);
		final long bSortSmallEndTime = System.currentTimeMillis();
		System.out.println("Total bubble sort small array execution time: " + (bSortSmallEndTime - bSortSmallStartTime));
		System.out.println();
		
		/*
		 * print for medium bubble sort arrays
		 */
		final long bSortMediumStartTime = System.currentTimeMillis();
		System.out.println("Unsorted medium array - ");
		System.out.println(Arrays.toString(randMediumArray));
		bubbleSort.bSort(randMediumArray);
		System.out.println("Sorted Medium array - ");
		bubbleSort.printArray(randMediumArray);
		final long bSortMediumEndTime = System.currentTimeMillis();
		System.out.println("Total bubble sort medium array execution time: " + (bSortMediumEndTime - bSortMediumStartTime));
		System.out.println();
		
		/*
		 * print for large bubble sort arrays
		 */
		final long bSortLargeStartTime = System.currentTimeMillis();
		System.out.println("Unsorted large array - ");
		System.out.println(Arrays.toString(randLargeArray));
		bubbleSort.bSort(randLargeArray);
		System.out.println("Sorted large array - ");
		bubbleSort.printArray(randLargeArray);
		final long bSortLargeEndTime = System.currentTimeMillis();
		System.out.println("Total bubble sort large array execution time: " + (bSortLargeEndTime - bSortLargeStartTime));
		System.out.println();
    }

}
