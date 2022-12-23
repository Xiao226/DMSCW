package com.comp2059.app;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import static com.comp2059.app.SpaceAsteroidApplication.*;

public class rankingController {
    @FXML
    public void onClickMoveToStartPage(MouseEvent mouseEvent) throws IOException {
        ruleNameStage.close();
        rankingStage.close();
        startStage.show();
    }
}
