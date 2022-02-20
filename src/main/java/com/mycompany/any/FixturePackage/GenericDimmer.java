package com.mycompany.any.FixturePackage;

public class GenericDimmer extends Fixture {
    final public static String name = "Generic Dimmer";
    final public int width = 1;
    public int startAddress;

    public GenericDimmer(int _startAddress){
        startAddress = _startAddress;
        channels[0] = new Channel(startAddress, channelTypes.DIMMER); 
    }
}