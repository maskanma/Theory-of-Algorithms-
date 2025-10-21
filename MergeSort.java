public static void main(String[] args) {
    int[] arr = {53, 100, 44, 74, 53, 38, 82, 65, 28};
    System.out.print("Оригінальний список: ");
    printArray(arr);

    int[] sorted = mergeSort(arr);

    System.out.print("Відсортований список: ");
    printArray(sorted);

    System.out.println("Загальна кількість порівнянь: " + comparisons);
    System.out.println("Загальна кількість присвоювань: " + assignments);
    System.out.println("Загальна кількість рекурсивних викликів: " + recursiveCalls);
}

    private static int comparisons = 0;
    private static int assignments = 0;
    private static int recursiveCalls = 0;

     static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        assignments++;

        recursiveCalls += 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
            assignments++;
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
            assignments++;
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }


    static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            comparisons++;
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
            assignments++;
        }

        while (i < left.length) {
            merged[k++] = left[i++];
            assignments++;
        }

        while (j < right.length) {
            merged[k++] = right[j++];
            assignments++;
        }

        return merged;
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
