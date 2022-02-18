package com.mycompany.any;

public class Channel {
    static final int MIN_ID = 0;
    static final int MAX_ID = 511;
    static final int MIN_VAL = 0;
    static final int MAX_VAL = 255;

    private int id;
    private byte value;
    public String name;

    public Channel(int _id) {
        id = _id;
    }

    public Channel(int _id, String _name) {
        id = _id;
        name = _name;
    }

    /**
     * @param _id the id to set
     */
    public void setId(int _id) {
        if (0 <= _id && _id <= 511) {
            id = _id;
        } else {

        }
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param _value the value to set
     */
    public void setValue(byte _value) {
        this.value = _value;
    }

    /**
     * @param _value the value to set
     */
    public void setValue(int _value) {
        if (0 <= _value && _value < 256) {
            setValue((byte) _value);
        }
    }

    /**
     * @return the value
     */
    public byte getValue() {
        return value;
    }

    public void max() {
        value = (byte) MAX_VAL;
    }

    public void min() {
        value = (byte) MIN_VAL;
    }
}
