public class SelectionSort {

    public static void selectionSort(int[] list2) {
        for (int i = 0; i < list2.length - 1; i++) {
            int currentMin = list2[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list2.length; j++) {
                if (currentMin > list2[j]) {
                    currentMin = list2[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                list2[currentMinIndex] = list2[i];
                list2[i] = currentMin;
            }
        }
    }
}
