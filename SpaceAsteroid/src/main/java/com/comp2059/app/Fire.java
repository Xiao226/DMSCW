package com.comp2059.app;

import static com.comp2059.app.informationStore.W;
import static com.comp2059.app.informationStore.weapons;

public class Fire {
    //This method causes the laser beam to move vertically upwards
    public void fire(int deltas) {
        for (int i = 0; i < weapons.size(); i++) {
            if (weapons.get(i).getLayoutX() < W) {
                weapons.get(i).relocate(weapons.get(i).getLayoutX(), weapons.get(i).getLayoutY() - deltas);
            } else weapons.remove(i);
        }
    }
    //This method causes the laser beam to move vertically down
    public void bossFire(int deltas) {
        for (int i = 0; i < weapons.size(); i++) {
            if (weapons.get(i).getLayoutX() < W) {
                weapons.get(i).relocate(weapons.get(i).getLayoutX(), weapons.get(i).getLayoutY() + deltas);
            } else weapons.remove(i);
        }
    }
}


