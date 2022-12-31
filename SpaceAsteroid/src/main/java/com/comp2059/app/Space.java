package com.comp2059.app;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.comp2059.app.appearanceController.backgroundFinal;
import static com.comp2059.app.informationStore.root;

/**
 * This class add the background image to the stage.
 */
public class Space {
    /**
     * The image of background.
     */
    Image background = backgroundFinal;
    /**
     * The place of image.
     */
    ImageView imgbackground = new ImageView(background);

    /**
     * add the background to the game page.
     */
    public void Create() {
        root.getChildren().add(imgbackground);
    }
}
