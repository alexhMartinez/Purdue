
public class sortArrayDescQS {
	static int part(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low;
        for (int j=low + 1; j<=high; j++) {
            if (arr[j] > pivot) {
                i= i + 1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
 
        return i;
    }

    static void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = part(arr, low, high);
 
            sort(arr, low, pi);
            sort(arr, pi+1, high);
        }
    }
 
    static void printArr(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
        System.out.print(arr[i]+",");
        System.out.println();
    }
}