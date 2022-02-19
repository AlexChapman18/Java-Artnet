package com.mycompany.pong;

import java.util.Vector;

public class Ball extends GameObject {
    static final String type = "ball";
    public Ball() {
        
            velocity.set(0, 0.1);
            velocity.set(1, 0.0);
        
        
            position.set(0, 5.0);
            position.set(1, 5.0);
        
        
            size.set(0,1.0);
            size.set(1,1.0);
        
    }

    public void onUpdate(GameObject[] gameState) {
        Vector<Double> nextPos = calculateNextPos();
        if ()
        //if (nextPos.get(0) > 10.0 || nextPos.get(0) < 0.0) {
        //    velocity.set(0, (-velocity.get(0)));
        //} 
        if (nextPos.get(1) > 10.0 || nextPos.get(1) < 0.0) {
            velocity.set(1, (-velocity.get(1)));    
        }
    }
}
