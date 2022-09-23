
public class seqSearch {
    static int seq(int arr[], int x) {
    	int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
 
    public static void search(int[] numbers, int value) {
        int result = seq(numbers, value);
        if (result == -1)
            System.out.println("Value " + value + " does not exist");
        else
            System.out.println("Value " + value + " is at index " + result);
    }
}
