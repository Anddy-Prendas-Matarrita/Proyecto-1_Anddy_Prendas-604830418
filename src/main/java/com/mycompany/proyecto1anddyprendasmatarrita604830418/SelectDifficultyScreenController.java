package com.mycompany.proyecto1anddyprendasmatarrita604830418;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SelectDifficultyScreenController {
    private Player player1=new Player(); //Creamos el jugador uno y dos, de nuevo para luego igualarlos a los de la pantalla anterior.
    private Player player2=new Player();
    private Match match;
    
//Con esta función se toca un botón y se accede a la pantalla de juego del modo fácil
    @FXML
    private void selectEasy() throws IOException {
        SelectModeScreenController.infoContainer.theMatch=new Match(1,SelectModeScreenController.infoContainer.getPlayer1(),SelectModeScreenController.infoContainer.getPlayer2());
        App.setRoot("EasyMatchScreen");
    }
     @FXML
    private void selectNormal() throws IOException {
        SelectModeScreenController.infoContainer.theMatch=new Match(2,SelectModeScreenController.infoContainer.getPlayer1(),SelectModeScreenController.infoContainer.getPlayer2());
        App.setRoot("NormalMatchScreen");
    }
     @FXML
    private void selectHard() throws IOException {
        SelectModeScreenController.infoContainer.theMatch=new Match(3,SelectModeScreenController.infoContainer.getPlayer1(),SelectModeScreenController.infoContainer.getPlayer2());
        App.setRoot("HardMatchScreen");
    }
    //Con esta función se toca un botón y se regresa a la pantalla de selección de modo de juego
     @FXML
    private void returnToMainMenu() throws IOException {
        App.setRoot("selectModeScreen");
    }
}
                       