package com.mycompany.console.Effects;

import com.mycompany.console.Universe;


// Designed to be run in its own thread until killed. I am not sure how to properly do this, but it seems wrong
public class Tilt extends Effect{
// Declaring values
    private int tiltMaxHeight = 150;
    double size = 0;
    double speed = 0;
    private int startingTilt = 0;

//  Constructor
    public Tilt(Universe _universe, int _size, int _speed, int _startingTilt, int[] _address){
        this.universe = _universe;
        this.size = _size / 100.0;
        setSpeed(_speed);
        this.startingTilt = _startingTilt;
        this.address = _address;
    }

    public void setSpeed(int _speed){
        if (_speed == 0){
            _speed = 1;
        }
        this.speed = (_speed / 100.0);
    }

//  Starts the effect by moving it to the maximum value
    public void run(){
        int tiltWidth = (int) (tiltMaxHeight * size);
        int waitTime = (int)((1/speed) * 20);

        for (int i = startingTilt; i < (startingTilt + tiltWidth/2); i++){
            universe.commitIndexFrame(i, address[0], false);
            try {
                Thread.sleep(waitTime/2);
            } catch (InterruptedException ignored) {}
        }

//      Starts panning from startingPan + tiltWidth/2, to startingPan - tiltWidth/2. (Full width of pan) and then pans
//      back again
        while(true){
            for (int i = (startingTilt + tiltWidth/2); i > (startingTilt - tiltWidth/2); i--){
                universe.commitIndexFrame(i, address[0], false);
                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException ignored) {}
            }

            for (int i = (startingTilt - tiltWidth/2); i < (startingTilt + tiltWidth/2); i++){
                universe.commitIndexFrame(i, address[0], false);
                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException ignored) {}
            }
        }
    }
}
