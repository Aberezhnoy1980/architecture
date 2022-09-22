package ru.aberezhnoy.iterator.homework;

import java.util.Iterator;
import java.util.Random;

public class Randomizer implements Iterable<Integer> {

    Random rnd = new Random();

    private final int[] randArr;
    private int size = (int) (Math.random() * 15);

    public Randomizer() {
        this.randArr = new int[size];
        for (int i = 0; i < size; i++) {
//            randArr[i] = (int) (Math.random() * 100);
            randArr[i] = rnd.nextInt(101);
        }
    }

    public static void main(String[] args) {
        Randomizer randomizer = new Randomizer();
        randomizer.simpleDisplay();

//        for (Integer e : randomizer) {
//            if (e > 25) randomizer.remove(e);
//        }

        for (int i = 0; i < randomizer.size; i++) {
            if (randomizer.randArr[i] > 25) {
                randomizer.remove(randomizer.randArr[i]);
                i--;
            }
        }
        System.out.println();

        randomizer.simpleDisplay();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            int current = 0;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public Integer next() {
                return randArr[current++];
            }
        };
    }

    public void simpleDisplay() {
        for (int i = 0; i < size; i++) {
            System.out.print(randArr[i] + " | ");
        }
    }

    public void remove(int value) {
        int i;
        for (i = 0; i < size; i++)
            if (randArr[i] == value) break;
        for (int j = i; j < size - 1; j++) {
            randArr[j] = randArr[j + 1];
        }
        size--;
    }

    public void forceRemove(int value) {
        int i;
        for (i = 0; i < size; i++)
            if (randArr[i] == value) {
                if (size - 1 - i >= 0) System.arraycopy(randArr, i + 1, randArr, i, size - 1 - i);
            }
        size--;
    }
}
