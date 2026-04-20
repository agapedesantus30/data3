import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class BenchmarkSorts {

    public static void main(String[] args) {

        int[] n = {1000, 2000, 3000, 4000, 5000, 6000, 7000,
                8000, 9000, 10000, 20000, 40000, 60000};
		
        long start, duration;
        // TODO change SOP to PrintWriter

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("Benchmark.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);

        for (int i = 0; i < n.length; i++) {
            int[] list = buildArray(n[i]);
            int[] list2 = Arrays.copyOf(list, list.length);

            start = System.currentTimeMillis();
            InsertionSort.insertionSort(list2);
            duration = System.currentTimeMillis() - start;
            printWriter.println("InsertionSort," + n[i] + "," + duration);

            start = System.currentTimeMillis();
            SelectionSort.selectionSort(list2);
            duration = System.currentTimeMillis() - start;
            printWriter.println("SelectionSort," + n[i] + "," + duration);

            start = System.currentTimeMillis();
            BubbleSort.bubbleSort(list2);
            duration = System.currentTimeMillis() - start;
            printWriter.println("BubbleSort," + n[i] + "," + duration);

            start = System.currentTimeMillis();
            MergeSort.mergeSort(list2);
            duration = System.currentTimeMillis() - start;
            printWriter.println("MergeSort," + n[i] + "," + duration);

            int[] list3 = Arrays.copyOf(list, list.length);
            try {
                start = System.currentTimeMillis();
                QuickSort.quickSort(list3);
                duration = System.currentTimeMillis() - start;
                printWriter.println("quickSort," + n[i] + "," + duration);
                System.out.println();

            } catch (Exception soe) {
                System.out.println("quickSort," + n[i] + "," + "overflow");
            }
        }
        printWriter.flush();
        printWriter.close();

    }

    private static int[] buildArray(int n) {
        Random rand = new Random();
        int[] i = new int[n];
        for (int j = 0; j < n; j++) {
            i[j] = rand.nextInt(n);
        }
        return i;
    }
}