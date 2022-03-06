package com.mycompany.any.Fixture;

public class GenericRGB extends Fixture {
    final public static String name = "Generic RGB";
    final public int width = 3;
    public int startAddress;

    public GenericRGB(int _startAddress){
        startAddress = _startAddress;
        channels[0] = new Channel(startAddress, channelTypes.RED);
        channels[1] = new Channel(startAddress + 1, channelTypes.GREEN);
        channels[2] = new Channel(startAddress + 2, channelTypes.BLUE);
    }

}