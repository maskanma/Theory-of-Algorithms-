public static void main(String[] args) {

    int[] arr = {53, 100, 44, 74, 53, 38, 82, 65, 28};
    System.out.print("Оригінальний список: ");
    printArray(arr);

    heapSort(arr);

    System.out.println("Загальна кількість порівнянь: " + comparisons);
    System.out.println("Загальна кількість присвоювань: " + assignments);
}

    private static int comparisons = 0;
    private static int assignments = 0;

    static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    assignments+=3;
}

static void sink(int[] arr, int i, int n) {
    int k = i;
    assignments++;

    while (true) {
        assignments++;
        int j = 2 * k + 1;

        comparisons++;
        if (j >= n) break;

        comparisons+=2;
        if (j + 1 < n && arr[j + 1] > arr[j]) {
            j += 1;
        }

        comparisons++;
        if (arr[k] >= arr[j]) break;

        swap(arr, k, j);

        k = j;
        assignments++;
    }
}

static void heapSort(int[] arr) {
    int n = arr.length;

    System.out.print("Початковий масив: ");
    printArray(arr);
    System.out.println("\n--- Фаза 1: Побудова максимальної купи ---");

    for (int i = n / 2 - 1; i >= 0; i--) {
        System.out.println("Занурюємо елемент з індексу " + i + ": " + arr[i]);
        sink(arr, i, n);
    }

    System.out.print("\nМасив після побудови купи: ");
    printArray(arr);
    System.out.println("\n--- Фаза 2: Сортування ---");

    for (int i = n - 1; i > 0; i--) {
        System.out.println("Міняємо місцями корінь (" + arr[0] + ") та останній елемент (" + arr[i] + ")");
        swap(arr, 0, i);

        n--;

        System.out.println("Розмір купи зменшився до " + n + ". Відновлюємо властивості купи.");
        sink(arr, 0, n);

        System.out.print("Масив на поточному кроці: ");
        printArray(arr);
        System.out.println();
    }

    System.out.print("\nВідсортований масив: ");
    printArray(arr);
}

static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
}
