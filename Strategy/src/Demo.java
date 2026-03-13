import java.util.Arrays;

public class Demo {
    public static void demoBubbleSort() {
        int[] data = {5, 1, 4, 2, 8};
        SortingContext context = new SortingContext(new BubbleSort());
        context.performSort(data);
        System.out.println("BubbleSort: " + Arrays.toString(data));
    }

    public static void demoQuickSort() {
        int[] data = {10, 7, 8, 9, 1, 5};
        SortingContext context = new SortingContext(new QuickSort());
        context.performSort(data);
        System.out.println("QuickSort: " + Arrays.toString(data));
    }

    public static void demoMergeSort() {
        int[] data = {12, 11, 13, 5, 6, 7};
        SortingContext context = new SortingContext(new MergeSort());
        context.performSort(data);
        System.out.println("MergeSort: " + Arrays.toString(data));
    }

    public static void main(String[] args) {
        demoBubbleSort();
        demoQuickSort();
        demoMergeSort();
    }
}
