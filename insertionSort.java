public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {69, 52, 97, 27, 10, 88, 29, 1, 24};

        System.out.println("Before sort:");
        printArray(arr);

        sort(arr);

        System.out.println("After sort:");
        printArray(arr);
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1] > current; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = current;
        }
    }

    private static void printArray(int[] arr) {
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }
}
