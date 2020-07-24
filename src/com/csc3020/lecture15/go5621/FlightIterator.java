package com.csc3020.lecture15.go5261;

import java.util.Iterator;

public class FlightIterator implements Iterator<Person> {
    private CrewMember[] crew;
    private Passenger[] roster;
    private int index;

    public FlightIterator(CrewMember[] crew, Passenger[] roster) {
        this.crew = crew;
        this.roster = roster;
    }

    @Override
    public boolean hasNext() {
        return index < (crew.length + roster.length);
    }

    @Override
    public Person next() {
        Person person = (index < crew.length) ?
                crew[index] : roster[index-crew.length];
        index++;
        return person;
    }
}
