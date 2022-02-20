package com.mycompany.FixtureTest;

import com.mycompany.any.Universe;
import ch.bildspur.artnet.ArtNetClient;
import com.mycompany.any.Sleep;

public class AllChannelsTest {
    public static void main(String[] args){
        Universe universeOne = new Universe(new ArtNetClient(), "2.39.2.10", 0, 0);
        universeOne.commit255Frame(true);
        new Sleep(5000);
        universeOne.commit0Frame(true);
    }
}

