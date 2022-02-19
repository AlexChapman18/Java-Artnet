package com.mycompany.any;

public class AmericanDJMegaBar extends Fixture {
    final public String name = "AmericanDJMegaBar";
    final public int width = 9;
    public int startAddress;

    public AmericanDJMegaBar(int _startAddress){
        startAddress = _startAddress;
        for (int i = 0; i < 9; i+=3){
            channels[i] = new Channel(i+1, channelTypes.RED);
            channels[i+1] = new Channel(i+2, channelTypes.GREEN);
            channels[i+2] = new Channel(i+3, channelTypes.BLUE);
        }
        channels[9] = new Channel(28, channelTypes.PPR);
        channels[10] = new Channel(29, channelTypes.STROBE); 
    }
}
