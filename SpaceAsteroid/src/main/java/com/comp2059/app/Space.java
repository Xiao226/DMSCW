package com.comp2059.app;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.comp2059.app.gameStageF2A.*;
import static com.comp2059.app.controller.appearanceController.backgroundFinal;

public class Space {
    // This classes will add the background image to the stage
    Image background = backgroundFinal;
    ImageView imgbackground = new ImageView(background);

    public void Create() {
        root.getChildren().add(imgbackground);
    }
}
