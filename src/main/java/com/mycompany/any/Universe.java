package com.mycompany.any;

import ch.bildspur.artnet.ArtNetClient;
//import java.util.concurrent.LinkedBlockingQueue;

public class Universe {
    //LinkedBlockingQueue<byte[]> buffer = new LinkedBlockingQueue<byte[]>();


    public final String address;
    public final int subnet;
    public final int universe;
    public final ArtNetClient artnet;

    public Universe(ArtNetClient _artnet, String _address, int _subnet, int _universe) {
        address = _address;
        subnet = _subnet;
        universe = _universe;
        artnet = _artnet;
        
        if (!artnet.isRunning()) {
            System.out.println("Starting Artnet");
            artnet.start();
        }

        byte[] currentFrame = new byte[512];
        for (int channel = 0; channel < currentFrame.length; channel++) {
            currentFrame[channel] = 0;
        }
        sendFrame(currentFrame);

    }

    public void sendFrame(byte[] frame) {
        artnet.unicastDmx(address, subnet, universe, frame);
    }

}
