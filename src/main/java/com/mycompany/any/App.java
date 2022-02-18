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

        while (true) {
            for (int j = 0; j < 100; j++) {
                for (int i = 0; i < dmxData.length; i++) {
                    dmxData[i] = (byte) j;
                }

                dmxData[9] = (byte) 0;

                // send data to localhost
                artnet.unicastDmx("2.39.2.10", 0, 0, dmxData);

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            for (int j = 100; j >= 0; j--) {
                for (int i = 0; i < dmxData.length; i++) {
                    dmxData[i] = (byte) j;
                }

                dmxData[9] = (byte) 0;

                // send data to localhost
                artnet.unicastDmx("2.39.2.10", 0, 0, dmxData);

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
}
