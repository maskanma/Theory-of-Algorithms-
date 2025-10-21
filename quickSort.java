public static void main(String[] args) {
    int[] arr = {53, 100, 44, 74, 53, 38, 82, 65, 28};
    System.out.print("Оригінальний список: ");
    printArray(arr);

    quickSort(arr, 0, arr.length-1);

    System.out.print("Відсортований список: ");
    printArray(arr);

    System.out.println("Загальна кількість порівнянь: " + comparisons);
    System.out.println("Загальна кількість присвоювань: " + assignments);
    System.out.println("Загальна кількість рекурсивних викликів: " + recursiveCalls);
}

    private static int comparisons = 0;
    private static int assignments = 0;
    private static int recursiveCalls = 0;


public static void quickSort(int[] a, int l, int r) {

    if (l < r) {
        recursiveCalls++;
        int q = partition(a, l, r);
        quickSort(a, l, q);
        quickSort(a, q + 1, r);
    }
}

public static int partition(int[] a, int l, int r) {
    int pivot = a[l];
    int i = l - 1;
    int j = r + 1;
    assignments += 3;

    while (true) {
        do {
            i++;
            assignments++;
            comparisons++;
        } while (a[i] < pivot);

        do {
            j--;
            assignments++;
            comparisons++;
        } while (a[j] > pivot);

        comparisons++;
        if (i >= j) {
            return j;
        }

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        assignments += 3;
    }
}

private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
