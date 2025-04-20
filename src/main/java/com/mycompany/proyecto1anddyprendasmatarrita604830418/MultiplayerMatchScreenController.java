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
   // los siguientes son los botones de cada barco de cada jugador
    @FXML
    private Button submarine11;
    @FXML
    private Button submarine12;
    @FXML
    private Button submarine13;
    @FXML
    private Button submarine14;
    @FXML
    private Button destroyer11;
     @FXML
    private Button destroyer12;
    @FXML
    private Button destroyer13;
    @FXML
    private Button cruiser11;
    @FXML
    private Button cruiser12;
    @FXML
    private Button battleship11;
    @FXML
    private Button submarine21;
    @FXML
    private Button submarine22;
    @FXML
    private Button submarine23;
    @FXML
    private Button submarine24;
    @FXML
    private Button destroyer21;
    @FXML
    private Button destroyer22;
    @FXML
    private Button destroyer23;
    @FXML
    private Button cruiser21;
    @FXML
    private Button cruiser22;
    @FXML
    private Button battleship21;
    @FXML
    private Label player1Label;
    @FXML
    private Label player2Label;
    @FXML
    private Button setPlayer1Button;
    @FXML
    private Button setPlayer2Button;
    @FXML
    private Button editOnButton; //Este es el botón para entrar en modo edición y colocar barcos a los tableros
    @FXML
    private Button editOffButton; //Este es el botón para salir del modo edición
    private int playerPlacingTurn=1; //Esta variable determina cual de los dos jugadores es el que tiene que colocar su barco
    private int horizontalOvertical=1; //Esta variable determina la posición en la que se pondrá el barco
    private int numOfBoat=0; //Esta variable determina cual de todos los barcos se seleccionó para ser colocado
     //Aquí se inyectan los GridPane creados en el scene builder al controlador para que puedan ser manipulados
    @FXML
    private GridPane player1Board;
    @FXML
    private GridPane player2Board;
    //Esta función, mediante un botón, inicializa los dos tableros
    @FXML
    private void initialize(){
      player1Label.setText(SelectModeScreenController.infoContainer.getPlayer1Name()); //Esto le coloca el nombre de cada jugador al la parte gráfica, accediendo a la indormación antes dada por el usuario
      player2Label.setText(SelectModeScreenController.infoContainer.getPlayer2Name());
      setPlayerBoard(player1Board); // Aquí se utiliza la función para llenar con agua los grid
      setPlayerBoard(player2Board);
      submarine11.setVisible(false);
             submarine12.setVisible(false);
submarine13.setVisible(false);
 submarine14.setVisible(false);
 destroyer11.setVisible(false);
  destroyer12.setVisible(false);
destroyer13.setVisible(false);
   cruiser11.setVisible(false);
 cruiser12.setVisible(false);
 battleship11.setVisible(false);
 submarine21.setVisible(false);
    submarine22.setVisible(false);
  submarine23.setVisible(false);
submarine24.setVisible(false);
destroyer21.setVisible(false);
   destroyer22.setVisible(false);
destroyer23.setVisible(false);
 cruiser21.setVisible(false);
 cruiser22.setVisible(false);
battleship21.setVisible(false);
setPlayer2Button.setVisible(false);
    }
    //Esta función inicializa el tablero que se le introduzca por parametro y lo llena con imagenes de agua 
    public void setPlayerBoard(GridPane playerGrid){  
        for(int f=0;f<8;f++){ // for para recorrer el tablero entero
        for(int c=0;c<8;c++){
            Button button=new Button(); // Se le asigna un botón a cada casilla 
            button.setPrefSize(174, 129); // Se le asigna un tamaño a cada botón
            button.setStyle("-fx-background-image: url('images/Water.jpeg');-fx-border-color:black");
            button.setOnAction(event -> {
                int row=playerGrid.getRowIndex(button);
                int column=playerGrid.getColumnIndex(button);
                placeBoatsToZone(row,column);
            });
            playerGrid.add(button, f, c); //Aquí el botón es introducido al Grid
            
        }
    }
   }
    @FXML //esta función permite ver los botones necesarios para colocar los barcos
    public void startEditing(){
        editOnButton.setVisible(false);
        editOffButton.setVisible(true);
             submarine11.setVisible(true);
             submarine12.setVisible(true);
submarine13.setVisible(true);
 submarine14.setVisible(true);
 destroyer11.setVisible(true);
  destroyer12.setVisible(true);
destroyer13.setVisible(true);
   cruiser11.setVisible(true);
 cruiser12.setVisible(true);
 battleship11.setVisible(true);
 submarine21.setVisible(true);
    submarine22.setVisible(true);
  submarine23.setVisible(true);
submarine24.setVisible(true);
destroyer21.setVisible(true);
   destroyer22.setVisible(true);
destroyer23.setVisible(true);
 cruiser21.setVisible(true);
 cruiser22.setVisible(true);
battleship21.setVisible(true);
setPlayer2Button.setVisible(true);
player2Board.setVisible(false);
    }
    //Esta función maneja mediante un botón, si el barco va posicionado en vertical y la siguiente en horizontal
    @FXML
    public void setVertical(){
        horizontalOvertical=2;
    }
    @FXML
    public void setHorizontal(){
        horizontalOvertical=1;
    }
    //Esta función define si es el turno de colocar barcos del jugador 1
    @FXML
    public void setPlayer1Placing(){
        playerPlacingTurn=1;
        setPlayer2Button.setVisible(true);
        setPlayer1Button.setVisible(false);
        player1Board.setVisible(true);
        player2Board.setVisible(false);
        
    }
    //Esta función define si es el turno de colocar barcos del jugador 2
    @FXML
    public void setPlayer2Placing(){
        playerPlacingTurn=2;
        setPlayer2Button.setVisible(false);
        setPlayer1Button.setVisible(true);
        player2Board.setVisible(true);
        player1Board.setVisible(false);
        
    }
    //Esta función la lleva cada botón que conforma el tablero de cada jugador,
    //que obtiene las coordenadas del botón en específico y las usa para recorrer el gridpane y dependiendo de cuál barco haya 
    //sido seleccionado, este tomará cierto color, rojo para submarinos, negro para destructores, azul para cruceros y verde para acorazados
    @FXML
    public void placeBoatsToZone(int x, int y){
        for(int f=0;f<8;f++){
            for(int c=0;c<8;c++){
                if(f==x){
                    if(c==y){
                        if(numOfBoat==1){ //verifica si es el barco número 1
                        if (playerPlacingTurn==1){//verifica si es el turno del jugador 1
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: red;-fx-border-color:black");
                        player1Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel1(0).setPositions(x, y, horizontalOvertical);
                        
                        }
                        else{ //o si es el turno del jugador 2
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: red;-fx-border-color:black");
                        player2Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel2(0).setPositions(x, y, horizontalOvertical); 
                        }
                      }
                        if(numOfBoat==2){
                        if (playerPlacingTurn==1){
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: red;-fx-border-color:black");
                        player1Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel1(1).setPositions(x, y, horizontalOvertical);
                        
                        }
                        else{
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: red;-fx-border-color:black");
                        player2Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel2(1).setPositions(x, y, horizontalOvertical); 
                        }
                      }
                        if(numOfBoat==3){
                        if (playerPlacingTurn==1){
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: red;-fx-border-color:black");
                        player1Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel1(2).setPositions(x, y, horizontalOvertical);
                        
                        }
                        else{
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: red;-fx-border-color:black");
                        player2Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel2(2).setPositions(x, y, horizontalOvertical); 
                        }
                      }
                        if(numOfBoat==4){
                        if (playerPlacingTurn==1){
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: red;-fx-border-color:black");
                        player1Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel1(3).setPositions(x, y, horizontalOvertical);
                        
                        }
                        else{
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: red;-fx-border-color:black");
                        player2Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel2(3).setPositions(x, y, horizontalOvertical); 
                        }
                      }
                        if(numOfBoat==5){
                        if (playerPlacingTurn==1){
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: black;-fx-border-color:black");
                        player1Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel1(4).setPositions(x, y, horizontalOvertical);
                        
                        }
                        else{
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: black;-fx-border-color:black");
                        player2Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel2(4).setPositions(x, y, horizontalOvertical); 
                        }
                      }
                        if(numOfBoat==6){
                        if (playerPlacingTurn==1){
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: black;-fx-border-color:black");
                        player1Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel1(5).setPositions(x, y, horizontalOvertical);
                        
                        }
                        else{
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: black;-fx-border-color:black");
                        player2Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel2(5).setPositions(x, y, horizontalOvertical); 
                        }
                      }
                        if(numOfBoat==7){
                        if (playerPlacingTurn==1){
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: black;-fx-border-color:black");
                        player1Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel1(6).setPositions(x, y, horizontalOvertical);
                        
                        }
                        else{
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: black;-fx-border-color:black");
                        player2Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel2(6).setPositions(x, y, horizontalOvertical); 
                        }
                      }
                        if(numOfBoat==8){
                        if (playerPlacingTurn==1){
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: blue;-fx-border-color:black");
                        player1Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel1(7).setPositions(x, y, horizontalOvertical);
                        
                        }
                        else{
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: blue;-fx-border-color:black");
                        player2Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel2(7).setPositions(x, y, horizontalOvertical); 
                        }
                      }
                        if(numOfBoat==9){
                        if (playerPlacingTurn==1){
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: blue;-fx-border-color:black");
                        player1Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel1(8).setPositions(x, y, horizontalOvertical);
                        
                        }
                        else{
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: blue;-fx-border-color:black");
                        player2Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel2(8).setPositions(x, y, horizontalOvertical); 
                        }
                      }
                        if(numOfBoat==10){
                        if (playerPlacingTurn==1){
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: green;-fx-border-color:black");
                        player1Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel1(9).setPositions(x, y, horizontalOvertical);
                        
                        }
                        else{
                        Button button=new Button(); 
                        button.setPrefSize(174, 129); 
                        button.setStyle("-fx-background-color: green;-fx-border-color:black");
                        player2Board.add(button, c, f);
                        SelectModeScreenController.infoContainer.getPlayerVessel2(9).setPositions(x, y, horizontalOvertical); 
                        }
                      }
                        if(numOfBoat==0){
                            return;
                        }
                    }
                }
            }
        }
    }
    //Las siguientes son funciones que cambian la variable para que placeBoatsToZone sepa cual barco poner
    @FXML
    public void placeSubmarinel(){
       numOfBoat=1;
    }
    @FXML
    public void placeSubmarine2(){
        numOfBoat=2;
    }
    @FXML
    public void placeSubmarine3(){
        numOfBoat=3;
    }
    @FXML
    public void placeSubmarine4(){
        numOfBoat=4;
    }
    @FXML
    public void placeDestroyerl(){
        numOfBoat=5;
    }
    @FXML
    public void placeDestroyer2(){
        numOfBoat=6;
    }
    @FXML
    public void placeDestroyer3(){
        numOfBoat=7;
    }
    @FXML
    public void placeCruiserl(){
        numOfBoat=8;
    }
    @FXML
    public void placeCruiser2(){
        numOfBoat=9;
    }
    @FXML
    public void placeBattleship(){
    numOfBoat=10;
    }
}
