package ru.aberezhnoy.ohers;

public class SumImpl extends AbstractSum {

    public SumImpl(int a, int b) {
        super(a, b);
    }

    @Override
    public int sum() {
        return a + b;
    }
}
