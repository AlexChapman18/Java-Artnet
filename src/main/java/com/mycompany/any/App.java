package com.mycompany.any;

import ch.bildspur.artnet.ArtNetClient;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ArtNetClient artnet = new ArtNetClient();
        
        Universe universe = new Universe(artnet, "2.39.2.10", 0, 0);

        byte[] frame = new byte[512];
        universe.sendFrame(frame);
    }
}
