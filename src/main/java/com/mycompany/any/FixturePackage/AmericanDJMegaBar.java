package com.mycompany.any.FixturePackage;

import com.mycompany.any.PatchFixtures;
import com.mycompany.any.Sleep;

public class AmericanDJMegaBar extends Fixture {
    final public String name = "AmericanDJMegaBar";
    final public int width = 9;
    public int startAddress;

    public AmericanDJMegaBar(int _startAddress){
        startAddress = _startAddress;
        for (int i = 0; i < 9; i+=3){
            channels[i] = new Channel(startAddress + i, channelTypes.RED);
            channels[i+1] = new Channel(startAddress + i + 1, channelTypes.GREEN);
            channels[i+2] = new Channel(startAddress + i + 2, channelTypes.BLUE);
        }
        channels[startAddress + 8] = new Channel(28, channelTypes.PPR);
        channels[startAddress + 9] = new Channel(29, channelTypes.STROBE); 
    }

    public void testFixture(){

        


    }
}
