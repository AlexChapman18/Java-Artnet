package com.mycompany.any;

public class AmericanDJMegaBar extends Fixture {
    final public String name = "AmericanDJMegaBar";
    final public int width = 9;
    public int startAddress;

    public AmericanDJMegaBar(int _startAddress){
        startAddress = _startAddress;
    }

    // How many channels we are using and 
    protected Channel[] channels;

}
