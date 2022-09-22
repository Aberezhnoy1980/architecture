package ru.aberezhnoy.strategy;

import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args) {
        int[] dataset1 = {2, 4, 6, 1, 8, 23, 56, 8, 3, 10};
        int[] dataset2 = {22, 434, 3436, 51, 238, 23, 656, 568, 63, 10};

        Sorter sorter1 = new Sorter(new BubbleSortStrategy());
        sorter1.sort(dataset1);
        System.out.println(Arrays.toString(dataset1));

        Sorter sorter2 = new Sorter(new QuickSortStrategy());
        sorter2.sort(dataset2);
        System.out.println(Arrays.toString(dataset2));
    }
}
