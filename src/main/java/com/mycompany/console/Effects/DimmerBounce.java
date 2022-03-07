package com.mycompany.console.Effects;

import com.mycompany.console.Universe;


/**
 * Used to bounce the intensity of Generic fixtures, back and forth
 */
public class DimmerBounce extends Effect{
    // Declaring values
    int size = 0;
    double speed = 0;

    //  Constructor
    public DimmerBounce(Universe _universe, int _size, int _speed, int[] _address){
        this.universe = _universe;
        this.size = (int)((_size / 100.0) * 255);
        this.speed = _speed / 100.0;
        this.address = _address;
    }

    //  Starts the effect
    public void run(){
        int waitTime = (int)((1/speed) * 20);

        while(true) {
            for (int i = 0; i < address.length; i++) {

                if (i == 0){
                    universe.commitIndexFrame(0, address[address.length-1]);
                }
                else{
                    universe.commitIndexFrame(0, i-1);
                }
                universe.commitIndexFrame(size, address[i]);

                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException ignored) {}
            }

            for (int i = (address.length - 1); i >= 0; i--) {

                if (i == (address.length - 1)){
                    universe.commitIndexFrame(0, address[address.length-1]);
                }
                else{
                    universe.commitIndexFrame(0, i+1);
                }
                universe.commitIndexFrame(size, address[i]);

                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException ignored) {}
            }
        }
    }
}
