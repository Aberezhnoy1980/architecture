package ru.aberezhnoy.iterator;

import java.util.Iterator;

public class IteratorApp {
    public static void main(String[] args) {

        StationList stationList = new StationList(10);

        stationList.addStation(new RadioStation(11f));
        stationList.addStation(new RadioStation(12f));
        stationList.addStation(new RadioStation(13f));
        stationList.addStation(new RadioStation(14f));
        stationList.addStation(new RadioStation(15f));
        stationList.addStation(new RadioStation(16f));
        stationList.addStation(new RadioStation(17f));
        stationList.addStation(new RadioStation(18f));
        stationList.addStation(new RadioStation(19f));
        stationList.addStation(new RadioStation(20f));

        System.out.println(stationList.count());
        stationList.simpleDisplay();

        System.out.println("\nCounter on index: " + stationList.key());

        System.out.println(stationList.current());


        System.out.println(stationList.iterator().hasNext());

//        stationList.removeStation(new RadioStation(15));
//        stationList.removeStation(new RadioStation(11));
//        stationList.removeStation(new RadioStation(17));
//        stationList.removeStation(new RadioStation(12));
//        stationList.removeStation(new RadioStation(19));

        stationList.removeStationByFreq(15);
        stationList.removeStationByFreq(11);
        stationList.removeStationByFreq(17);
        stationList.removeStationByFreq(12);
        stationList.removeStationByFreq(19);

//        stationList.arrayLengthCut(5);

        for (RadioStation rs : stationList) {
            System.out.print(rs.getFrequency() + " | ");
        }

        System.out.println("\nCounter on index: " + stationList.key());

        stationList.rewind();

//        stationList.addStation(new RadioStation(11));
//
//        stationList.simpleDisplay();
    }
}
