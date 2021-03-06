package com.mycompany.user;

import com.mycompany.console.Fixture.*;
import ch.bildspur.artnet.ArtNetClient;
import com .mycompany.console.Universe;

public class RunTest {
    public static void main(String[] args) {
        ArtNetClient artnet = new ArtNetClient();
        Universe universeOne = new Universe(artnet, "2.39.2.10", 0, 0);
        PatchFixtures patchedFixture = new PatchFixtures("PongPatch.txt");
        for (Fixture fixture : patchedFixture.Fixtures) {
            fixture.testFixture(universeOne);
        }
    }
}
