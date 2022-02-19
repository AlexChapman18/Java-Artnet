package com.mycompany.any;

public class GenericRGB extends Fixture {
    final public String name = "Generic RGB";
    final public int width = 3;
    public int startAddress;

    public GenericRGB(int _startAddress){
        startAddress = _startAddress;
        channels[0] = new Channel(1, channelTypes.RED);
        channels[1] = new Channel(2, channelTypes.GREEN);
        channels[2] = new Channel(3, channelTypes.BLUE);
    }

}