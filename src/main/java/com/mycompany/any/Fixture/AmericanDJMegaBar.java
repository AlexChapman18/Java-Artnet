package com.mycompany.any.Fixture;

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


    public void setValues(int[] _values){
        for (Channel channel : channels) {
            if (channel.name == channelTypes.RED && _values[0] != -1) {
                channel.setValue(_values[0]);
            }
            if (channel.name == channelTypes.GREEN && _values[1] != -1) {
                channel.setValue(_values[1]);
            }
            if (channel.name == channelTypes.BLUE && _values[2] != -1) {
                channel.setValue(_values[2]);
            }
            if (channel.name == channelTypes.STROBE && _values[9] != -1) {
                channel.setValue(_values[9]);
            }
            if (channel.name == channelTypes.DIMMER && _values[9] != -1) {
                channel.setValue(_values[10]);
            }
            
        }
    }


    public void setValues(int _redValue1, int _greenValue1, int _blueValue1,int _redValue2, int _greenValue2, int _blueValue2,int _redValue3, int _greenValue3, int _blueValue3, int _strobeValue, int _dimmerValue){
        channels[0].setValue(_redValue1);
        channels[1].setValue(_greenValue1);
        channels[2].setValue(_blueValue1);
        channels[3].setValue(_redValue2);
        channels[4].setValue(_greenValue2);
        channels[5].setValue(_blueValue2);
        channels[6].setValue(_redValue3);
        channels[7].setValue(_greenValue3);
        channels[8].setValue(_blueValue3);
        channels[9].setValue(_strobeValue);
        channels[10].setValue(_dimmerValue);
    }

    @Override
    public void testFixture(Universe _universe) {

        // Sets all the red channels to 255
        this.channels[0].setValue(255);
        this.channels[10].setValue(255);
        _universe.commitFixture(this, true);
        new Sleep(2000);
        this.setValues(new int[]{255, 0, 0, 0, 255});
        _universe.commitFixture(this, true);
        new Sleep(2000);
        this.setValues(new int[]{255, 255, 0, 100, 255});
        _universe.commitFixture(this, true);
        new Sleep(2000);
        _universe.commit0Frame();
        this.setValues(new int[]{0, 0, 0, 0, 0});
        _universe.commitFixture(this, true);

    }        
}
