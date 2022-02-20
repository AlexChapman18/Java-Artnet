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
     * @param _artnet
     * @param _address
     * @param _subnet
     * @param _universe
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
     * Commits all frames at value 255, does not push
     */
    public void commit255Frame(){
        commit255Frame(false);
    }

    /**
     * commits all frames at value 255, will push depending on parameter
     * @param doPush
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
     * @param doPush
     */
    public void commit0Frame(boolean doPush){
        Arrays.fill(frameValues, (byte) 0);
        if (doPush)
            pushFrame();
    }


    /**
     * commits all fixtures, does not push
     * @param _fixtures
     */
    public void commitAllFixtures(Fixture[] _fixtures){
        commitAllFixtures(_fixtures, false);
    }

    /**
     * commits all fixtures, will push depending on parameter
     * @param _fixtures
     * @param _doPush
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
     * @param _fixture
     */
    public void commitFixture(Fixture _fixture){
        commitFixture(_fixture, false);
    }
    
    /**
     * commits fixture, will push depending on parameter
     * @param _fixture
     * @param _doPush
     */
    public void commitFixture(Fixture _fixture, boolean _doPush){
        for (Channel _channel : _fixture.channels){
            frameValues[_fixture.startAddress + _channel.getAddress()] = _channel.getValue();
        }
        if (_doPush)
            pushFrame();
    }


    /**
     * Outputs frameValues to artnet node
     */
    public void pushFrame(){
        artnet.unicastDmx(address, subnet, universe, frameValues);
    }
}
