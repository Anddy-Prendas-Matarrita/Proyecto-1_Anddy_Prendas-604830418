package com.mycompany.proyecto1anddyprendasmatarrita604830418;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuScreenController {

    @FXML
    private void playAndSelectMode() throws IOException {
        App.setRoot("SelectModeScreen");
    }
     @FXML
    private void switchToCreditsScreen() throws IOException {
        App.setRoot("CreditsScreen");
    }
    @FXML
     private void exitApp() throws IOException {
     System.exit(0);
    }
}
