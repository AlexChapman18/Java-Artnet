package com.mycompany.any.Fixture;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class PatchFixtures {
    private final int maxFixtures;
    public Fixture[] Fixtures;
    
    // Used to initialise empty array
    public PatchFixtures(int _maxFixtures){
        maxFixtures = _maxFixtures;
        Fixtures = new Fixture[maxFixtures];
    }

    public void setFixture(Fixture _newFixture){
        boolean patched = false;
        for(int i = 0; i<Fixtures.length && !patched; i++) {
            if(Fixtures[i] == null){
                Fixtures[i] = _newFixture;
                patched = true;
            }
        }
    }

    public Fixture getFixture(int index){
        return Fixtures[index];
    }

    // Used to patch from a file
    public PatchFixtures(String _fileName){
        LinkedList<String> readFixtures = new LinkedList<>();
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
        Fixtures = new Fixture[maxFixtures];

        for (String _fixture : readFixtures) {
            String[] splitFixture = _fixture.split(",");
            switch (splitFixture[0]) {
                case ("AmericanDJMegaBar"):
                    setFixture(new AmericanDJMegaBar(Integer.parseInt(splitFixture[1].trim())));
                case ("MartinRush5x5"):
                    setFixture(new MartinRush5x5(Integer.parseInt(splitFixture[1].trim())));
                case ("GenericDimmer"):
                    setFixture(new GenericDimmer(Integer.parseInt(splitFixture[1].trim())));
                case ("GenericRGB"):
                    setFixture(new GenericRGB(Integer.parseInt(splitFixture[1].trim())));
            }
        }
    }
}
