package com.mycompany.proyecto1anddyprendasmatarrita604830418;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SelectModeScreenController {
    //Esta función aun no sirve
    @FXML
    private void selectPlayerVsPlayer() throws IOException {
       App.setRoot("");
    }
    //Con esta función se toca un botón y se accede a la pantalla de selección de dificultad
     @FXML
    private void selectPlayerVsComputer() throws IOException {
       App.setRoot("SelectDifficultyScreen");
    }
    //Con esta función se toca un botón y se regresa a la pantalla de inicio
    @FXML
    private void returnToMain() throws IOException {
       App.setRoot("MenuScreen");
    }
}
