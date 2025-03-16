package com.mycompany.proyecto1anddyprendasmatarrita604830418;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CreditsController {
//Con esta función se toca un botón y se regresa a la pantalla de inicio
    @FXML
    private void selectReturn() throws IOException {
        App.setRoot("MenuScreen");
    }
}
             