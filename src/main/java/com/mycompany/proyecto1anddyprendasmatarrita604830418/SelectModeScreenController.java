package com.mycompany.proyecto1anddyprendasmatarrita604830418;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SelectModeScreenController {
    @FXML
    private void selectPlayerVsPlayer() throws IOException {
       App.setRoot("");
    }
     @FXML
    private void selectPlayerVsComputer() throws IOException {
       App.setRoot("SelectDifficultyScreen");
    }
    @FXML
    private void returnToMain() throws IOException {
       App.setRoot("MenuScreen");
    }
}
