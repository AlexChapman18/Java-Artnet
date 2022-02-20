package com.mycompany.any;

import java.util.Arrays;
import com.mycompany.any.FixturePackage.Channel;
import com.mycompany.any.FixturePackage.Fixture;
import ch.bildspur.artnet.ArtNetClient;

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
