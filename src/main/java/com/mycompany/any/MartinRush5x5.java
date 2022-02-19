package com.mycompany.any;

public class MartinRush5x5 extends Fixture {
    final public String name = "MartinRush5x5";
    final public int width = 29;
    public int startAddress;


    public MartinRush5x5(int _startAddress){
        startAddress = _startAddress;
        channels = new Channel[width];
        for (int i = 0; i < 25; i++){
            channels[i] = new Channel(i+1, channelTypes.DIMMER);
        }
        for (int i = 25; i < 27; i++){
            channels[i] = new Channel(i+1, channelTypes.PPR);
        }
        channels[27] = new Channel(28, channelTypes.DIMMER);
        channels[28] = new Channel(29, channelTypes.STROBE);        
    }

}
