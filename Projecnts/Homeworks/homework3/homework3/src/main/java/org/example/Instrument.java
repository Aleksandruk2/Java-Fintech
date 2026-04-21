package org.example;


public class Instrument {
    protected String name;
    protected boolean isAcoustics;
    protected String description;
    protected String history;

    public Instrument() {
    }

    public Instrument(String name, boolean isAcoustics, String description, String history) {
        this.name = name;
        this.isAcoustics = isAcoustics;
        this.description = description;
        this.history = history;
    }
}


