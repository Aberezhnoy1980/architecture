package ru.aberezhnoy.iterator;

import java.util.Iterator;

public class StationList implements Iterable<RadioStation> {

    private RadioStation[] stations;
    private int counter = 0;
    private int size;

    public StationList(int size) {
        this.size = size;
        this.stations = new RadioStation[size];
    }

    public void addStation(RadioStation station) {
        if (this.counter < this.size - 1) {
            this.stations[this.counter++] = station;
        } else if (this.counter == size - 1) {
            this.stations[this.counter] = station;
        } else throw new ArrayIndexOutOfBoundsException("List of station is full");
    }

    public void removeStation(RadioStation stationToRemove) {
        float toRemoveFrequency = stationToRemove.getFrequency();
        int i;
        for (i = 0; i < size; i++) {
            if (stations[i].getFrequency() == toRemoveFrequency) break;
        }
        for (int j = i; j < size - 1; j++) {
            stations[j] = stations[j + 1];
        }
        size--;
        counter--;
    }

    public void removeStationByFreq(float frequency) {
        int i;
        for (i = 0; i < size; i++) {
            if (stations[i].getFrequency() == frequency) break;
        }
        for (int j = i; j < size - 1; j++) {
            stations[j] = stations[j + 1];
        }
        size--;
        counter--;
    }

    public void arrayLengthCut(int value) {
        StationList.this.size -= value;
    }

    public int count() {
        return this.stations.length;
    }

    public RadioStation current() {
        return this.stations[counter];
    }

    public int key() {
        return this.counter;
    }

    public void rewind() {
        this.counter = 0;
    }

//    public boolean valid() {
//        return ??(this.stations[this.counter]);
//    } // это аналог hasNext?

    public void simpleDisplay() {
        for (int i = 0; i < size; i++) {
            System.out.print(stations[i].getFrequency() + " | ");
        }
        System.out.println();
    }

    @Override
    public Iterator<RadioStation> iterator() {
        return new Iterator<>() {

            int current = 0;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public RadioStation next() {
                return stations[current++];
            }
        };
    }
}