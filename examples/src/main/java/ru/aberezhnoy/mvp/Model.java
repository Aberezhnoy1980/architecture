package ru.aberezhnoy.mvp;

/**
 * A minimsl class to maintain some state
 */
public class Model {

    private int count;

    public void addOneToCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
