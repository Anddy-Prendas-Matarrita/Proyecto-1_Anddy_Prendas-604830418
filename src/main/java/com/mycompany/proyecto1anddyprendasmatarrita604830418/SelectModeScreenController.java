package com.mycompany.proyecto1anddyprendasmatarrita604830418;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class SelectModeScreenController {
    private Player player1=new Player(); //Creamos el jugador uno y dos, de momento no importa si son dos jugadores o un jugador contra computadora.
    private Player player2=new Player();
    public Match theMatch;
    public static SelectModeScreenController infoContainer;
    @FXML
    private Label noNameError;
    
    
    @FXML
    private TextField putName1; //Inyectamos los cuadros para que el usuario escriba su nombre
    @FXML
    private TextField putName2;
    //Esta función, mediante un botón, accede a la pantalla de juego multijugador
    public void initialize() {
        infoContainer=this;
    }
    public String getPlayer1Name(){
        return player1.getName();
    }
    public String getPlayer2Name(){
        return player2.getName();
    }
    @FXML
    private void selectPlayerVsPlayer() throws IOException {
        theMatch=new Match(4,player1,player2);
        player1.setName(putName1.getText());
        player2.setName(putName2.getText());
        if (player1.getName().isEmpty() || player2.getName().isEmpty()){
            noNameError.setVisible(true);
            return;
        }
       App.setRoot("MultiplayerMatchScreen");
    }
    //Con esta función se toca un botón y se accede a la pantalla de selección de dificultad
     @FXML
    private void selectPlayerVsComputer() throws IOException {
        player1.setName(putName1.getText());
         player2.setName("PC");
         if (player1.getName().isEmpty() || player2.getName().isEmpty()){
            noNameError.setVisible(true);
            return;
        }
      App.setRoot("SelectDifficultyScreen");
    }
    //Con esta función se toca un botón y se regresa a la pantalla de inicio
    @FXML
    private void returnToMain() throws IOException {
       App.setRoot("MenuScreen");
    }
    public Match getMatch(){
        return this.theMatch;
    }
    public Player getPlayer1(){
        return this.player1;
    }
    public Player getPlayer2(){
        return this.player2;
    }
    public Board getPlayerBoard1(){
        return this.player1.getBoard();
    }
    public Board getPlayerBoard2(){
        return this.player2.getBoard();
    }
    public Vessel getPlayerVessel1(int num){
        return this.player1.getBoard().getVessel(num);
    }
    public Vessel getPlayerVessel2(int num){
        return this.player2.getBoard().getVessel(num);
    }
    
}
