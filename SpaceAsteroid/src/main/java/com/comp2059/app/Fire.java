package com.comp2059.app;

import static com.comp2059.app.gameStageF2A.W;
import static com.comp2059.app.gameStageF2A.weapons;

public class Fire {
    //This method causes the laser beam to move vertically upwards
    public void fire(int deltas) {
        for (int i = 0; i < weapons.size(); i++) {
            if (weapons.get(i).getLayoutX() < W) {
                weapons.get(i).relocate(weapons.get(i).getLayoutX(), weapons.get(i).getLayoutY() - deltas);
            } else weapons.remove(i);
        }
    }
}


