package com.mycompany.any.Fixture;

public class GenericDimmer extends Fixture {
    final public static String name = "Generic Dimmer";
    final public int width = 1;
    public int startAddress;

    public void setValues(int[] _dimmerValue){
        channels[0].setValue(_dimmerValue[0]);
    }

    public GenericDimmer(int _startAddress){
        startAddress = _startAddress;
        channels[0] = new Channel(startAddress, channelTypes.DIMMER); 
    }
}