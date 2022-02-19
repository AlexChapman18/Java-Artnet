package com.mycompany.any;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import com.mycompany.any.FixturePackage.AmericanDJMegaBar;
import com.mycompany.any.FixturePackage.Fixture;
import com.mycompany.any.FixturePackage.GenericDimmer;
import com.mycompany.any.FixturePackage.GenericRGB;
import com.mycompany.any.FixturePackage.MartinRush5x5;

public class PatchFixtures {
    private int maxFixtures;
    public Fixture[] patchedFixtures;
    
    // Used to initialise empty array
    public PatchFixtures(int _maxFixtures){
        maxFixtures = _maxFixtures;
        patchedFixtures = new Fixture[maxFixtures];
    }


    // Used to patch from a file
    public PatchFixtures(String _fileName){
        LinkedList<String> readFixtures = new LinkedList<String>();
        try {
            File myObj = new File(_fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              readFixtures.add(data);
            }
            myReader.close();
        } 
        
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        maxFixtures = readFixtures.size();
        patchedFixtures = new Fixture[maxFixtures];

        for (String _fixture : readFixtures){
            String[] splitFixture = _fixture.split(",");
            if (splitFixture[0] == "AmericanDJMegaBar")
                setFixture(new AmericanDJMegaBar(Integer.parseInt(splitFixture[1])));
            else if (splitFixture[0] == "MartinRush5x5")
            setFixture(new MartinRush5x5(Integer.parseInt(splitFixture[1])));
            else if (splitFixture[0] == "GenericDimmer")
                setFixture(new GenericDimmer(Integer.parseInt(splitFixture[1])));
            else if (splitFixture[0] == "GenericDimmer")
                setFixture(new GenericRGB(Integer.parseInt(splitFixture[1])));
        }
                  
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
