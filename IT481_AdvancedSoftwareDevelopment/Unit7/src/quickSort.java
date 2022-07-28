import java.util.Arrays;

public class quickSort{

	public static void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		int i = (low - 1);
	
		for(int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}
	
	public static void qSort(int[] arr, int low, int high) {
		if (low < high) {
			int part = partition(arr, low, high);
	
			qSort(arr, low, part - 1);
			qSort(arr, part + 1, high);
		}
	}
	
	public static void printArray(int[] arr, int size) {
		for(int i = 0; i < size; i++)
			
		System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void quickSortResults(int small, int medium, int large) {
		
		int[] randSmallArray = ArrayBuilder.Generate(small);
		int smallArrayLength = randSmallArray.length;
		
		int[] randMediumArray = ArrayBuilder.Generate(medium);
		int mediumArrayLength = randMediumArray.length;
		
		int[] randLargeArray = ArrayBuilder.Generate(large);
		int largeArrayLength = randLargeArray.length;
		
		/*
		 * print for small quick sort arrays
		 */
		final long qSortSmallStartTime = System.currentTimeMillis();
		System.out.println("Unsorted and sorted arrays containing random numbers, and using quick sort:");
		System.out.println();
		System.out.println("Unsorted small array - ");
		System.out.println(Arrays.toString(randSmallArray));
		quickSort.qSort(randSmallArray, 0, smallArrayLength - 1);
		System.out.println("Sorted small array - ");
		quickSort.printArray(randSmallArray, smallArrayLength);
		final long qSortSmallEndTime = System.currentTimeMillis();
		System.out.println("Total quick sort small array execution time: " + (qSortSmallEndTime - qSortSmallStartTime));
		System.out.println();
		
		/*
		 * print for medium quick sort arrays
		 */
		final long qSortMediumStartTime = System.currentTimeMillis();
		System.out.println("Unsorted medium array - ");
		System.out.println(Arrays.toString(randMediumArray));
		quickSort.qSort(randMediumArray, 0, mediumArrayLength - 1);
		System.out.println("Sorted medium array - ");
		quickSort.printArray(randMediumArray, mediumArrayLength);
		final long qSortMediumEndTime = System.currentTimeMillis();
		System.out.println("Total quick sort medium array execution time: " + (qSortMediumEndTime - qSortMediumStartTime));
		System.out.println();
		
		/*
		 * print for large quick sort arrays
		 */
		final long qSortLargeStartTime = System.currentTimeMillis();
		System.out.println("Unsorted large array - ");
		System.out.println(Arrays.toString(randLargeArray));
		quickSort.qSort(randLargeArray, 0, largeArrayLength - 1);
		System.out.println("Sorted large array - ");
		quickSort.printArray(randLargeArray, largeArrayLength);
		final long qSortLargeEndTime = System.currentTimeMillis();
		System.out.println("Total quick sort large array execution time: " + (qSortLargeEndTime - qSortLargeStartTime));
		System.out.println();
		
		System.out.println();
		System.out.println();
		System.out.println();
	}
}