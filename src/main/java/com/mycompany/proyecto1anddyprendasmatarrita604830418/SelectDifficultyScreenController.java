package com.mycompany.proyecto1anddyprendasmatarrita604830418;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SelectDifficultyScreenController {

    @FXML
    private void selectEasy() throws IOException {
        App.setRoot("EasyMatchScreen");
    }
     @FXML
    private void selectNormal() throws IOException {
        
    }
     @FXML
    private void selectHard() throws IOException {
        
    }
     @FXML
    private void returnToMainMenu() throws IOException {
        App.setRoot("selectModeScreen");
    }
}
                            