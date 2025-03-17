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
        App.setRoot("EasyMatchScreen");
    }
     @FXML
    private void selectNormal() throws IOException {
        
    }
     @FXML
    private void selectHard() throws IOException {
        
    }
    //Con esta función se toca un botón y se regresa a la pantalla de selección de modo de juego
     @FXML
    private void returnToMainMenu() throws IOException {
        App.setRoot("selectModeScreen");
    }
    //Esta función se encargar de recibir los objetos que vienen de otro controlador
       public void setPlayers(Player player1,Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }  
}
                       