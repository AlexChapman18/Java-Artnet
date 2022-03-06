package com.mycompany.any;

import com.mycompany.any.Fixture.Channel;
import com.mycompany.any.Fixture.Fixture;
import ch.bildspur.artnet.ArtNetClient;
import java.util.Arrays;

public class Universe {
    public final String address;
    public final int subnet;
    public final int universe;
    public final ArtNetClient artnet;
    public byte[] frameValues = new byte[512]; 

    /**
     * Initialises the universe
     * @param _artnet The artnet client
     * @param _address The address the artnet node
     * @param _subnet The subnet of the artnet node
     * @param _universe the output universe on the node
     */
    public Universe(ArtNetClient _artnet, String _address, int _subnet, int _universe) {
        address = _address;
        subnet = _subnet;
        universe = _universe;
        artnet = _artnet;

        if (!artnet.isRunning()) {
            System.out.println("Starting Artnet");
            artnet.start();
        }

        Arrays.fill(frameValues, (byte) 0);
        pushFrame();
    }


    // -- BROKEN
//    public byte limitByte(int Value){
//        return limitByte((byte)Value);
//    }
//
//    public byte limitByte(byte Value){
//        if (Value > (byte) 250 || Value < (byte) 0){
//            return (byte)0;
//        }
//        return Value;
//    }
    // BROKEN ---


    /**
     * returns the current frame of the Universe
     * @return current Frame
     */
    public byte[] getFrame(){
        return frameValues;
    }

    /**
     * Sets the frame
     * @param _frame 512 Byte array of all DMX channel values
     */
    public void setFrame(byte[] _frame){
        this.frameValues = _frame;
    }

    
    /**
     * Commits all frames at value 255, does not push
     */
    public void commit255Frame(){
        commit255Frame(false);
    }

    /**
     * commits all frames at value 255, will push depending on parameter
     * @param doPush Boolean value to determine if commit will be pushed
     */
    public void commit255Frame(boolean doPush){
        Arrays.fill(frameValues, (byte) 255);
        if (doPush)
            pushFrame();
    }


    /**
     * commits all frames at value 0, does not push
     */
    public void commit0Frame(){
        commit0Frame(false);
    }

    /**
     * commits all frames at value 0, will push depending on parameter
     * @param doPush Boolean value to determine if commit will be pushed
     */
    public void commit0Frame(boolean doPush){
        Arrays.fill(frameValues, (byte) 0);
        if (doPush)
            pushFrame();
    }


    /**
     * Sets a value at a specific index in universe
     * @param Value Array of values 0-255
     * @param index Index in universe
     */
    public void commitIndexFrame(int Value, int index){
        commitIndexFrame(Value, index, true);
    }

    /**
     * Sets a value at a specific index in universe
     * @param Value Array of values 0-255
     * @param index Index in universe
     */
    public void commitIndexFrame(int Value, int index, boolean doPush){
        this.frameValues[index] = (byte)Value;
        if (doPush)
            pushFrame();
    }


    /**
     * Sets a group of values at a specific index in universe
     * @param Values Array of values 0-255
     * @param index Index in universe
     */
    public void commitGroupIndexFrame(int[] Values, int index){
        commitGroupIndexFrame(Values, index, true);
    }

    /**
     * Sets a group of values at a specific index in universe
     * @param Values Array of values 0-255
     * @param index Index in universe
     */
    public void commitGroupIndexFrame(int[] Values, int index, boolean doPush){
        for (int i = 0; i < Values.length; i++){
            this.frameValues[i + index] = (byte) Values[i];
        }
        if (doPush)
            pushFrame();
    }


    /**
     * Sets single value to entire universe
     * @param Value Value 0-255
     */
    public void commitXFrame(int Value){
        commitXFrame(Value, true);
    }

    /**
     * Sets single value to entire universe
     * @param Value Value 0-255
     */
    public void commitXFrame(int Value, boolean doPush){
        Arrays.fill(frameValues, (byte) Value);
        if (doPush)
            pushFrame();
    }


    /**
     * commits all fixtures, does not push
     * @param _fixtures Array of every patched fixture
     */
    public void commitAllFixtures(Fixture[] _fixtures){
        commitAllFixtures(_fixtures, false);
    }

    /**
     * commits all fixtures, will push depending on parameter
     * @param _fixtures Array of every patched fixture
     * @param _doPush Boolean value to determine if commit will be pushed
     */
    public void commitAllFixtures(Fixture[] _fixtures, boolean _doPush){
        for (Fixture _fixture : _fixtures){
            commitFixture(_fixture);
        }
        if (_doPush)
            pushFrame();
    }


    /**
     * commits fixture, will not push
     * @param _fixture The fixture object you want to push
     */
    public void commitFixture(Fixture _fixture){
        commitFixture(_fixture, false);
    }
    
    /**
     * commits fixture, will push depending on parameter
     * @param _fixture The fixture object you want to push
     * @param _doPush Boolean value to determine if commit will be pushed
     */
    public void commitFixture(Fixture _fixture, boolean _doPush){
        for (Channel _channel : _fixture.channels){
            frameValues[_fixture.startAddress + _channel.getAddress()] = _channel.getValue();
        }
        if (_doPush)
            pushFrame();
    }


    /**
     * Pushes frameValues to artnet node
     */
    public void pushFrame(){
        artnet.unicastDmx(address, subnet, universe, frameValues);
    }

}
