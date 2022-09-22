package ru.aberezhnoy.iterator;

import java.util.Iterator;

public class LessonApp {
    public static void main(String[] args) {
        Iterable<String> strings = new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<>() {

                    String[] arr = {"first", "second", "third"};

                    int current = 0;

                    @Override
                    public boolean hasNext() {
                        return current < arr.length;
                    }

                    @Override
                    public String next() {
                        return arr[current++];
                    }
                };
            }
        };

        for (String str : strings) {
            System.out.println(str);
        }

        for (String str : strings) {
            System.out.println(str);
        }
    }
}