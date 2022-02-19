package com.mycompany.sequenceDisplayTest;

import ch.bildspur.artnet.ArtNetClient;
import com.mycompany.any.FixturePackage.AmericanDJMegaBar;
import com.mycompany.any.FixturePackage.Channel;
import com.mycompany.any.FixturePackage.channelTypes;
import com.mycompany.any.PatchFixtures;
import com.mycompany.any.Universe;

class App {
    public static void main(String[] args) {
        ArtNetClient artnet = new ArtNetClient();
        Universe universe = new Universe(artnet, "2.39.2.10", 0, 0);

        PatchFixtures patchedFixture = new PatchFixtures(1);

        patchedFixture.setFixture(new AmericanDJMegaBar(1));

        while (true) {
            for (Channel channel : patchedFixture.getFixture(0).channels) {
                if (channel.name == channelTypes.RED || channel.name == channelTypes.DIMMER) {
                    channel.setValue(255);
                } else {
                    channel.setValue(0);
                }
            }
            universe.updateFrame(patchedFixture.patchedFixtures);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            for (Channel channel : patchedFixture.getFixture(0).channels) {
                if (channel.name == channelTypes.GREEN || channel.name == channelTypes.DIMMER) {
                    channel.setValue(255);
                } else {
                    channel.setValue(0);
                }
            }
            universe.updateFrame(patchedFixture.patchedFixtures);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            for (Channel channel : patchedFixture.getFixture(0).channels) {
                if (channel.name == channelTypes.BLUE || channel.name == channelTypes.DIMMER) {
                    channel.setValue(255);
                } else {
                    channel.setValue(0);
                }
            }
            universe.updateFrame(patchedFixture.patchedFixtures);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
