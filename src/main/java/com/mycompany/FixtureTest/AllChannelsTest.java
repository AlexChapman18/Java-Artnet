package com.mycompany.FixtureTest;

import java.util.Scanner;

import com.mycompany.any.PatchFixtures;
import com.mycompany.any.Universe;
import com.mycompany.any.FixturePackage.*;
import java.util.Arrays;
import ch.bildspur.artnet.ArtNetClient;

public class AllChannelsTest {
    public static void main(String[] args){
        Universe testUniverse = new Universe(new ArtNetClient(), "2.39.2.10", 0, 0);
        byte[] tempFrame = new byte[512];
        Arrays.fill(tempFrame, (byte) 0);
        testUniverse.sendFrame(tempFrame);
    }
}

