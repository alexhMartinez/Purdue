
public class binarySearch {
	int binary(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binary(arr, l, mid - 1, x);
 
            return binary(arr, mid + 1, r, x);
        }
        return -1;
    }
 
    public static void search(int[] numbers, int value) {
        binarySearch ob = new binarySearch();
        int n = numbers.length;
        int x = value;
        int result = ob.binary(numbers, 0, n - 1, x);
        if (result == -1)
            System.out.println("Value " + x + " does not exist");
        else
            System.out.println("Value " + x + " is at index " + result);
    }
}
