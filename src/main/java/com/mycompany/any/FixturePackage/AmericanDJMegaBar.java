package com.mycompany.any.FixturePackage;

import com.mycompany.any.Sleep;
import com.mycompany.any.Universe;

public class AmericanDJMegaBar extends Fixture {
    final public static String name = "AmericanDJMegaBar";
    final public int width = 11;

    public AmericanDJMegaBar(int _startAddress) {
        startAddress = _startAddress;
        channels = new Channel[width];

        for (int i = 0; i < 9; i += 3) {
            channels[i] = new Channel(i, channelTypes.RED);
            channels[i + 1] = new Channel(i + 1, channelTypes.GREEN);
            channels[i + 2] = new Channel(i + 2, channelTypes.BLUE);
        }
        channels[9] = new Channel(9, channelTypes.STROBE);
        channels[10] = new Channel(10, channelTypes.DIMMER);
    }
 
    public void setValues(int _redValue, int _greenValue, int _blueValue, int _strobeValue, int _dimmerValue){
        for (Channel channel : channels) {
            if (channel.name == channelTypes.RED && _redValue != -1) {
                channel.setValue(_redValue);
            }
            if (channel.name == channelTypes.GREEN && _greenValue != -1) {
                channel.setValue(_greenValue);
            }
            if (channel.name == channelTypes.BLUE && _greenValue != -1) {
                channel.setValue(_blueValue);
            }
            if (channel.name == channelTypes.STROBE && _greenValue != -1) {
                channel.setValue(_strobeValue);
            }
            if (channel.name == channelTypes.DIMMER && _greenValue != -1) {
                channel.setValue(_dimmerValue);
            }
            
        }
    }

    @Override
    public void testFixture(Universe _universe) {

        // Sets all the red channels to 255
        this.channels[0].setValue(255);
        this.channels[10].setValue(255);
        _universe.commitFixture(this, true);
        new Sleep(2000);
        this.setValues(255, 0, 0, 0, 255);
        _universe.commitFixture(this, true);
        new Sleep(2000);
        this.setValues(255, 255, 0, 100, 255);
        _universe.commitFixture(this, true);
        new Sleep(2000);
        _universe.commit0Frame();
        this.setValues(0, 0, 0, 0, 0);
        _universe.commitFixture(this, true);

    }        
}
