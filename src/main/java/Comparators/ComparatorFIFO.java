package main.java.Comparators;

import main.java.Event.Event;

import java.util.Comparator;

public class ComparatorFIFO implements Comparator<Event> {
    @Override
    public int compare(Event event, Event t1) {
        if(event.getTimeClock()<t1.getTimeClock()){
            return -1;
        }
        return 1;
    }
}