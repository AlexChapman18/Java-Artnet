package com.mycompany.FixtureTest;

import com.mycompany.any.PatchFixtures;
import com.mycompany.any.FixturePackage.*;
import ch.bildspur.artnet.ArtNetClient;
import com .mycompany.any.Universe;

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
