package com.mycompany.console.Fixture;

import com.mycompany.console.Universe;

public abstract class Fixture {
    public String name;
    public Channel[] channels;
    public int startAddress;

    public void testFixture(Universe _universe) {
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public void setChannels(Channel[] _channels) {
        this.channels = _channels;
    }

    public void setValues(int[] _values) {
    }

    public void setStartAddress(int _startAddress) {
        this.startAddress = _startAddress;
    }

    public String getName() {
        return name;
    }

    public Channel[] getChannels() {
        return channels;
    }

    public int getStartAddress(){
        return startAddress;
    }
}
