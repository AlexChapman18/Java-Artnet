package com.mycompany.any.Fixture;

public class Channel {
    //  Constants
    static final int MIN_ADDRESS = 0;
    static final int MAX_ADDRESS = 511;
    static final int MIN_VAL = 0;
    static final int MAX_VAL = 255;

    //  Variables
    private int address;
    private byte value;
    public channelTypes name;

    // Constructor(s)
    /**
     * Channel constructor with starting address and name
     * @param _address the starting address
     * @param _name the channel name enum
     */
    public Channel(int _address, channelTypes _name) {
        this.setAddress(_address);
        this.setName(_name);
    }


    // ---Set and get methods---
    // Address
    /**
     * @param _address the id to set
     */
    public void setAddress(int _address) {
        if (0 <= _address && _address <= 511) {
            address = _address;
        } else {
            System.out.println("Error converting" + _address + "to Byte");
        }
    }

    /**
     * @return the id
     */
    public int getAddress() {
        return this.address;
    }


    // Value
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
        return this.value;
    }


    // Name
    /**
     * Set the channel name
     * @param _name Channel name enum
     */
    public void setName(channelTypes _name){
        this.name = _name;
    }

    /**
     * Get the channel name
     * @return channel name enum
     */
    public channelTypes getName(){
        return this.name;
    }


    /**
     * set value to maximum
     */
    public void setMax() {
       setValue((byte) MAX_VAL);
    }

    /**
     * set value to minimum
     */
    public void setMin() {
        setValue((byte) MIN_VAL);
    }
}
