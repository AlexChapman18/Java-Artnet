package com.mycompany.pong;

public class Paddle extends GameObject {
    static final String type = "paddle";
    final boolean ai;

    public Paddle(int _player, boolean _ai = false) {
        ai = _ai;

        if (player == 1) {
            position.set(0, 0.0)
        } else {
            position.set(0, 10.0)
        }
        position.set(1,5.0);

        velocity.set(0,0.0);
        velocity.set(0,0.0);

        size.set(0,1);
        size.set(1,2)
    }

    public void onUpdate(GameObject[] gameState) {
        if (ai) {
            
        }
    }
}
