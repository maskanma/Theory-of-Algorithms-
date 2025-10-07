public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {69, 52, 97, 27, 10, 88, 29, 1, 24};

        System.out.println("Before sort:");
        show(arr);

        selection(arr);

        System.out.println("After sort:");
        show(arr);
    }

    private static void selection(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int smallest = i;
            for (int k = i + 1; k < n; k++) {
                if (arr[k] < arr[smallest]) {
                    smallest = k;
                }
            }
            if (smallest != i) {
                int temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = temp;
            }
        }
    }

    private static void show(int[] arr) {
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }
}
