package com.mycompany.any;

import ch.bildspur.artnet.ArtNetClient;
import com.mycompany.any.FixturePackage.Channel;
import com.mycompany.any.FixturePackage.Fixture;
import com.mycompany.any.FixturePackage.channelTypes;

class App2 {
    public static void main(String[] args) {
        ArtNetClient artnet = new ArtNetClient();
        Universe universe = new Universe(artnet, "2.39.2.10", 0, 0);

        PatchFixtures patchedFixture = new PatchFixtures("PongPatch.txt");


        for (Fixture fixture : patchedFixture.patchedFixtures) {


            for (Channel channel : fixture.channels) {
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

            for (Channel channel : fixture.channels) {
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

            for (Channel channel : fixture.channels) {
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
            for (Fixture _fixture : patchedFixture.patchedFixtures) {
                for (Channel _channel : _fixture.channels) {
                    _channel.setValue(0);
                }
            }
            universe.updateFrame(patchedFixture.patchedFixtures);
        }

    }
}
