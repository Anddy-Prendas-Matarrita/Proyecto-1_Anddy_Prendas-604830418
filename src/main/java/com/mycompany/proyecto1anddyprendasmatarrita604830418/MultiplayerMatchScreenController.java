package com.mycompany.proyecto1anddyprendasmatarrita604830418;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class MultiplayerMatchScreenController {
    //Aquí se inyectan los GridPane creados en el scene builder al controlador para que puedan ser manipulados
    @FXML
    private GridPane player1Board;
    @FXML
    private GridPane player2Board;
    @FXML
    private Label player1NameL;
    @FXML
    private Label player2NameL;
    //Esta función, mediante un botón, inicializa los dos tableros
    @FXML
    private void initialize () {
      setPlayerBoard(player1Board);
      setPlayerBoard(player2Board);
      player1NameL.setText(SelectModeScreenController.infoContainer.getPlayer1Name());
      player2NameL.setText(SelectModeScreenController.infoContainer.getPlayer2Name());

    }
    //Esta función inicializa el tablero que se le introduzca por parametro y lo llena con imagenes de agua 
    public void setPlayerBoard(GridPane playerGrid){  
        for(int f=0;f<11;f++){ // for para recorrer el tablero entero
        for(int c=0;c<11;c++){
            Button button=new Button(); // Se le asigna un botón a cada casilla 
            button.setPrefSize(174, 129); // Se le asigna un tamaño a cada botón
            button.setStyle("-fx-background-image: url('images/Water.jpeg');-fx-border-color:black");
            playerGrid.add(button, f, c); //Aquí el botón es introducido al Grid
        }
    }
   }
}