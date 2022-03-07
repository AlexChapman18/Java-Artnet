package com.mycompany.user;

import ch.bildspur.artnet.ArtNetClient;
import com.mycompany.console.Effects.*;
import com.mycompany.console.Sleep;
import com.mycompany.console.Universe;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Universe universeOne = new Universe(new ArtNetClient(), "2.39.2.10", 0, 0);
        universeOne.commit255Frame(true);
        int[] Values = new int[10];
        Arrays.fill(Values, 255);

        universeOne.commit0Frame(false);
        universeOne.start();
        new Sleep(3000);
        int[] addresses = {0, 1, 2, 3, 4};
        DimmerBounce DimmerBounce = new DimmerBounce(universeOne, 100, 20, addresses);
        DimmerBounce.start();

    }
}
