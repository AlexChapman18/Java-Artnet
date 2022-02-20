package com.mycompany.any;

import ch.bildspur.artnet.ArtNetClient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UniverseTest {

    Universe _universeOne;
    byte[] testFrame = new byte[512];

    @BeforeAll
    public void setup(){
        ArtNetClient artnet = new ArtNetClient();
        Universe _universeOne = new Universe(artnet, "2.39.2.10", 0, 0);
    }

    @Test
    void commit255Frame() {
        _universeOne.commit255Frame();
        Arrays.fill(testFrame, (byte) 255);
        assertArrayEquals(testFrame, _universeOne.frameValues);
    }

    @Test
    void commit0Frame() {
        _universeOne.commit255Frame();
        Arrays.fill(testFrame, (byte) 0);
        assertArrayEquals(testFrame, _universeOne.frameValues);
    }

    @Test
    void commitAllFixtures() {
    }

    @Test
    void commitFixture() {
    }

    @Test
    void pushFrame() {
    }
}