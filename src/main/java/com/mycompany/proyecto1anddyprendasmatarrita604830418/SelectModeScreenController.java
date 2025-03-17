package com.mycompany.proyecto1anddyprendasmatarrita604830418;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class SelectModeScreenController {
    private Player player1=new Player(); //Creamos el jugador uno y dos, de momento no importa si son dos jugadores o un jugador contra computadora.
    private Player player2=new Player();
    @FXML
    private TextField putName1; //Inyectamos los cuadros para que el usuario escriba su nombre
    @FXML
    private TextField putName2;
    //Esta función, mediante un botón, accede a la pantalla de juego multijugador
    @FXML
    private void selectPlayerVsPlayer() throws IOException {
        player1.setName(putName1.getText());
        player2.setName(putName2.getText());
       App.setRoot("MultiplayerMatchScreen");
    }
    //Con esta función se toca un botón y se accede a la pantalla de selección de dificultad
     @FXML
    private void selectPlayerVsComputer() throws IOException {
        player1.setName(putName1.getText());
         player2.setName("PC");
      switchToDifficultyScreen("SelectDifficultyScreen");
    }
    //Con esta función se toca un botón y se regresa a la pantalla de inicio
    @FXML
    private void returnToMain() throws IOException {
       App.setRoot("MenuScreen");
    }
    //Esta funcion sirve para pasar objetos de un controlador a otro
      private void switchToDifficultyScreen(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent root = loader.load();
        SelectDifficultyScreenController controller = loader.getController();
        controller.setPlayers(player1,player2); //Aqui pasamos los objetos player a la siguiente pantalla
        App.setRoot("SelectDifficultyScreen");
    }
    
}
