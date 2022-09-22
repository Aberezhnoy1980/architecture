package ru.aberezhnoy.strategy;

public class BubbleSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] dataset) {
        System.out.println("Sorting using bubble sort");
        int in, out;
        for (out = dataset.length - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (dataset[in] > dataset[in + 1]) {
                    int temp = dataset[in];
                    dataset[in] = dataset[in + 1];
                    dataset[in + 1] = temp;
                }
            }
        }
    }
}
