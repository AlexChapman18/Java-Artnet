package com.mycompany.any;

import ch.bildspur.artnet.ArtNetClient;
import com.mycompany.any.Fixture.AmericanDJMegaBar;
import com.mycompany.any.Fixture.Fixture;
import com.mycompany.any.Fixture.GenericDimmer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UniverseTest {

    Universe _universeOne = new Universe(new ArtNetClient(), "2.39.2.10", 0, 0);;
    byte[] testFrame = new byte[512];

    @BeforeAll
    void setup(){
        this._universeOne.commit0Frame();
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
        Fixture[] Fixtures = {
                new AmericanDJMegaBar(1),
                new AmericanDJMegaBar(12),
                new GenericDimmer(13)
        };

        Fixtures[0].setValues(new int[]{255, 255, 255, 255, 255});
        Fixtures[0].setValues(new int[]{255, 255, 255, 255, 255});




    }

    @Test
    void commitFixture() {
    }

    @Test
    void pushFrame() {
    }
}