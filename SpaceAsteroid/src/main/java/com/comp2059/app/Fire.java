package com.comp2059.app;

import static com.comp2059.app.informationStore.*;

public class Fire {
    //This method causes the laser beam to move vertically upwards
    public void fire(int deltas) {
        for (int i = 0; i < weapons.size(); i++) {
            if (weapons.get(i).getLayoutY() > 0) {
                weapons.get(i).relocate(weapons.get(i).getLayoutX(), weapons.get(i).getLayoutY() - deltas);
            } else {
                if (!isBossBeaten) {
                    score -= 1;
                    txtscore.setText("Score: " + score + " + " + scoreBoss);
                }
                root.getChildren().remove(weapons.get(i));
                weapons.remove(i);
            }
        }
    }

}


