package com.mycompany.any.FixturePackage;

public enum channelTypes {
    PPR, DIMMER, RED, GREEN, BLUE, STROBE;

    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
