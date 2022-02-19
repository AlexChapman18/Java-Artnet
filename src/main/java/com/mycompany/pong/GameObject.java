package com.mycompany.pong;

import com.mycompany.any.Universe;
import java.util.Vector;

public class GameObject {
    Vector<Double> position = new Vector<>(2);
    Vector<Double> size = new Vector<>(2);
    Vector<Double> velocity = new Vector<>(2);

    Vector<Double> calculateNextPos() {
        Vector<Double> nextPos = new Vector<>(2);
        nextPos.set(0, position.get(0) + velocity.get(0));
        nextPos.set(1, position.get(1) + velocity.get(1));
        return nextPos;
    }

    void setNextPos(Vector<Double> nextPos) {
        position = nextPos;
    } 
}
