package com.mycompany.console.Fixture.FixtureFiles;

import com.mycompany.console.Fixture.Fixture;
import com.mycompany.console.Fixture.Channel;
import com.mycompany.console.Fixture.channelTypes;

public class MartinRush5x5 extends Fixture {
    final public static String name = "MartinRush5x5";
    final public int width = 29;
    public int startAddress;


    public MartinRush5x5(int _startAddress){
        startAddress = _startAddress;
        channels = new Channel[width];
        for (int i = 0; i < 25; i++){
            channels[i] = new Channel(startAddress + i, channelTypes.DIMMER);
        }
        for (int i = 25; i < 27; i++){
            channels[i] = new Channel(startAddress + i, channelTypes.PPR);
        }
        channels[27] = new Channel(startAddress + 27, channelTypes.DIMMER);
        channels[28] = new Channel(startAddress + 28, channelTypes.STROBE);        
    }
}
