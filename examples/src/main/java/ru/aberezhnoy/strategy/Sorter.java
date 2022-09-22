package ru.aberezhnoy.strategy;

public class Sorter {
    private SortStrategy sorter;

    public Sorter(SortStrategy sorter) {
        this.sorter = sorter;
    }

    public void sort(int[] dataset) {
        sorter.sort(dataset);
    }
}
