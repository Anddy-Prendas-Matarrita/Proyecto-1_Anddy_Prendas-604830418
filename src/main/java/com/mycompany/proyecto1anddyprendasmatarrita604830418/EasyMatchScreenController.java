package com.mycompany.proyecto1anddyprendasmatarrita604830418;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class EasyMatchScreenController {
    @FXML
    private GridPane player1Board;
    @FXML
    private GridPane player2Board;
    
    @FXML
    private void generateBoards() throws IOException {
      setPlayerBoard(player1Board);
      setPlayerBoard(player2Board);
    }
    
    public void setPlayerBoard(GridPane playerGrid){
        for(int f=0;f<8;f++){
        for(int c=0;c<8;c++){
            Button button=new Button();
            button.setPrefSize(174, 129);
            button.setStyle("-fx-background-image: url('images/Water.jpeg');");
            playerGrid.add(button, f, c);
        }
    }

   }
}
