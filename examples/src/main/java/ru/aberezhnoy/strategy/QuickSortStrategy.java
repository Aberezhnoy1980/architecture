package ru.aberezhnoy.strategy;

public class QuickSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] dataset) {
        System.out.println("Sortingg using quick sort");
        int in, out;
        for (out = 1; out < dataset.length; out++) {
            int temp = dataset[out];
            in = out;
            while (in > 0 && dataset[in - 1] >= temp) {
                dataset[in] = dataset[in - 1];
                --in;
            }
            dataset[in] = temp;
        }
    }
}
