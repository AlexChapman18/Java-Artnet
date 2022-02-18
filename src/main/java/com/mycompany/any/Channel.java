package com.mycompany.any;

public class Channel {
    static final int MIN_ID = 0;
    static final int MAX_ID = 511;
    static final int MIN_VAL = 0;
    static final int MAX_VAL = 255;

    public int id;
    public byte value;
    public String name;

    public Channel(int _id) {
        id = _id;
    }

    public Channel(int _id, String _name) {
        id = _id;
        name = _name;
    }

    public void max() {
        value = (byte) MAX_VAL;
    }

    public void min() {
        value = (byte) MIN_VAL;
    }
}
