package com.mycompany.any;

import ch.bildspur.artnet.ArtNetClient;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        byte[] dmxData = new byte[512];
        ArtNetClient artnet = new ArtNetClient();
        artnet.start();

        // set data
        for (int i = 0; i < dmxData.length; i++) {
            dmxData[i] = (byte) 255;
        }

        // send data to localhost
        artnet.unicastDmx("172.16.0.1", 0, 0, dmxData);

    }
}
