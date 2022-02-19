package com.mycompany.any;

public class MartinRush5x5 extends Fixture {
    final public String name = "MartinRush5x5";
    final public int width = 29;
    public int startAddress;

    public MartinRush5x5(int _startAddress){
        startAddress = _startAddress;
    }

    // How many channels we are using and 
    protected Channel[] channels = new Channel[width];

}
