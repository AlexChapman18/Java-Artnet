package com.mycompany.any.FixturePackage;

public class Channel {
    static final int MIN_ADDRESS = 0;
    static final int MAX_ADDRESS = 511;
    static final int MIN_VAL = 0;
    static final int MAX_VAL = 255;

    private int address;
    private byte value;
    public channelTypes name;

    public Channel(int _address) {
        address = _address;
    }

    public Channel(int _address, channelTypes _name) {
        address = _address;
        name = _name;
    }

    /**
     * @param _address the id to set
     */
    public void setAddress(int _address) {
        if (0 <= _address && _address <= 511) {
            address = _address;
        } else {

        }
    }

    /**
     * @return the id
     */
    public int getAddress() {
        return address;
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
        if (0 <= _value && _value <= 255) {
            setValue((byte) _value);
        }
    }

    /**
     * @return the value
     */
    public byte getValue() {
        return (byte) (value);
    }

    public void max() {
        value = (byte) MAX_VAL;
    }

    public void min() {
        value = (byte) MIN_VAL;
    }
}
