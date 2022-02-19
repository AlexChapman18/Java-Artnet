package com.mycompany.any.FixturePackage;

import com.mycompany.any.PatchFixtures;
import com.mycompany.any.Sleep;

public class AmericanDJMegaBar extends Fixture {
    final public String name = "AmericanDJMegaBar";
    final public int width = 11;
    public int startAddress;

    public AmericanDJMegaBar(int _startAddress) {
        startAddress = _startAddress - 1;
        channels = new Channel[width];

        for (int i = 0; i < 9; i += 3) {
            channels[i] = new Channel(startAddress + i, channelTypes.RED);
            channels[i + 1] = new Channel(startAddress + i + 1, channelTypes.GREEN);
            channels[i + 2] = new Channel(startAddress + i + 2, channelTypes.BLUE);
        }
        channels[9] = new Channel(startAddress + 9, channelTypes.STROBE);
        channels[10] = new Channel(startAddress + 10, channelTypes.DIMMER);
    }

    public void testFixture() {

    }
}
