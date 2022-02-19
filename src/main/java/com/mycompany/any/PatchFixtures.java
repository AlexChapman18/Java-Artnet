package com.mycompany.any;

import com.mycompany.any.FixturePackage.Fixture;

public class PatchFixtures {
    private int maxFixtures;
    public Fixture[] patchedFixtures;
    
    public PatchFixtures(int _maxFixtures){
        maxFixtures = _maxFixtures;
        patchedFixtures = new Fixture[maxFixtures];

    }
    
    public void setFixture(Fixture _newFixture){
        boolean patched = false;
        for(int i = 0; i<patchedFixtures.length && !patched; i++) {
            if(patchedFixtures[i] == null){
                patchedFixtures[i] = _newFixture;
                patched = true;
            }
        }
    }

    public Fixture getFixture(int index){
        return patchedFixtures[index];
    }
}
