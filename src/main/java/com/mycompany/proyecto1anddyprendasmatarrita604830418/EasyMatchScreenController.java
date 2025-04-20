package com.mycompany.proyecto1anddyprendasmatarrita604830418;
import java.util.Random;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class EasyMatchScreenController {
    @FXML
    private Button verticalButton;
    @FXML
    private Button horizontalButton;
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
    private Label player1Label;
    @FXML
    private Label player2Label;
    @FXML
    private Button editOnButton; //Este es el botón para entrar en modo edición y colocar barcos a los tableros
    @FXML
    private Button editOffButton; //Este es el botón para salir del modo edición
    private boolean isValidToContinue=true;
    private int submarineCounter=0;
    private int destroyerCounter=0;
    private int cruiserCounter=0;
    private int battleshipCounter=0;
    private int horizontalOvertical=1; //Esta variable determina la posición en la que se pondrá el barco
    private int numOfBoat=0; //Esta variable determina cual de todos los barcos se seleccionó para ser colocado
    @FXML //Aquí se inyectan los GridPane creados en el scene builder al controlador para que puedan ser manipulados
    private GridPane player1Board;
    @FXML
    private GridPane player2Board;
    private Random random=new Random(); // Se crea una instancia de random para la generacion de numeros aleatorios
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
        horizontalButton.setVisible(true);
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
     player2Board.setVisible(false);

//aqui vamos a colocar de forma aleatoria los barcos del enemigo
  int randomX=0;
  int randomY=0;
  int aux=0;
  while(aux<4){ //bucle para colocar los submarinos
      horizontalOvertical=(random.nextInt(2))+1; //se genera un numero entre 1 y 2 aleatorio para la orientacion del barco (horizontal o vertical)
          randomX=random.nextInt(8);// se genera un numero aleatorio entre 0 y 7 para la posicion en x
          randomY=random.nextInt(8);// se genera un numero aleatorio entre 0 y 7 para la posicion en y
          placeBoatsToZoneRandom(randomX,randomY,aux+1); // se llama la funcion que se encarga de colocar los barcos en el tablero y de forma logica, usando los numeor antes creados
          if(isValidToContinue==true){ //esta verifica si el barco fue realmente colocado o si no se coloco por salirse de los limites o por que ya habia un barco en esa posicion
              aux=aux+1;//se le suma a la variable para que avance, sino se coloco el barco, se repite hasta que se coloque
          }  
  }
   while(aux<7){//bucle para colocar los destructores
      horizontalOvertical=(random.nextInt(2))+1;
          randomX=random.nextInt(8);
          randomY=random.nextInt(8);
          placeBoatsToZoneRandom(randomX,randomY,aux+1);
          if(isValidToContinue==true){
              aux=aux+1;
          }  
  }
      while(aux<9){ //bucle para colocar los cruceros
      horizontalOvertical=(random.nextInt(2))+1;
          randomX=random.nextInt(8);
          randomY=random.nextInt(8);
          placeBoatsToZoneRandom(randomX,randomY,aux+1);
          if(isValidToContinue==true){
              aux=aux+1;
          }  
  }
      while(aux<10){ //bucle para colocar el acorazado
      horizontalOvertical=(random.nextInt(2))+1;
          randomX=random.nextInt(8);
          randomY=random.nextInt(8);
          placeBoatsToZoneRandom(randomX,randomY,aux+1);
          if(isValidToContinue==true){
              aux=aux+1;
          }  
  }
      submarineCounter=0;
      destroyerCounter=0;
      cruiserCounter=0;
      battleshipCounter=0;
      horizontalOvertical=1;
    }
    @FXML
    public void endEditing(){ //para terminar de colocar barcos
        player2Board.setVisible(true);
        horizontalButton.setVisible(false);
        verticalButton.setVisible(false);
    }
    //Esta función maneja mediante un botón, si el barco va posicionado en vertical y la siguiente en horizontal
    @FXML
    public void setVertical(){
        horizontalButton.setVisible(false);
        verticalButton.setVisible(true);
        horizontalOvertical=2;
    }
    @FXML
    public void setHorizontal(){
        horizontalButton.setVisible(true);
        verticalButton.setVisible(false);
        horizontalOvertical=1;
        
    }
    //Esta función define si es el turno de colocar barcos del jugador 1
    @FXML
    public void setPlayer1Placing(){
        player1Board.setVisible(true);
        player2Board.setVisible(false);
        
    }
    //Esta función la lleva cada botón que conforma el tablero de cada jugador,
    //que obtiene las coordenadas del botón en específico y las usa para recorrer el gridpane y dependiendo de cuál barco haya 
    //sido seleccionado, este tomará cierto color, rojo para submarinos, negro para destructores, azul para cruceros y verde para acorazados
    @FXML
    public void placeBoatsToZone(int x, int y){
                        if(numOfBoat==1){ //verifica si es el barco número 1
                        if(submarineCounter<4){ //verifica si ya el jugador puso todos sus barcos de este tipo
                        
                        if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'){  //verifica si las coordenadas estan desocupadas para poder anadir otro barco 
                        SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);// ocupa el espacio de la matriz char del jugador
                        submarineCounter=submarineCounter+1;// suma al contador de submarinos
                        submarine11.setVisible(false);
                        }
                        SelectModeScreenController.infoContainer.getPlayerBoard1().placeCharacters(x, y, horizontalOvertical, numOfBoat);// le coloca estas coordenadas al barco seleccionado
                        }
                        }
                        if(numOfBoat==2){
                        if(submarineCounter<4){
                        
                        if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'){   
                        SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                        submarineCounter=submarineCounter+1;
                        submarine12.setVisible(false);
                        }
                        SelectModeScreenController.infoContainer.getPlayerBoard1().placeCharacters(x, y, horizontalOvertical, numOfBoat);
                        }
                      }
                       if(numOfBoat==3){
                       if(submarineCounter<4){
                        
                        if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'){   
                        SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                        submarineCounter=submarineCounter+1;
                        submarine13.setVisible(false);
                        }
                        SelectModeScreenController.infoContainer.getPlayerBoard1().placeCharacters(x, y, horizontalOvertical, numOfBoat);
                        }
                      }
                        if(numOfBoat==4){
                        if(submarineCounter<4){
                        
                        if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'){   
                        SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                        submarineCounter=submarineCounter+1;
                        submarine14.setVisible(false);
                        }
                        SelectModeScreenController.infoContainer.getPlayerBoard1().placeCharacters(x, y, horizontalOvertical, numOfBoat);
                        }
                      }
                        if(numOfBoat==5){
                        if (destroyerCounter<3){
                        
                         if(horizontalOvertical==1){
                           if(x<7){//verifica que el barco no se vaya a salir de los limites de la matriz en x
                           if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+1][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           destroyer11.setVisible(false);
                           }
                        }
                         }
                         else{
                           if(y<7){//verifica que el barco no se vaya a salir de los limites de la matriz en y
                           if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y+1]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           destroyer11.setVisible(false);
                           }
                        }
                         }
                         SelectModeScreenController.infoContainer.getPlayerBoard1().placeCharacters(x, y, horizontalOvertical, numOfBoat);
                        }
                      }
                        if(numOfBoat==6){
                       if (destroyerCounter<3){
                        
                         if(horizontalOvertical==1){
                           if(x<7){//verifica que el barco no se vaya a salir de los limites de la matriz en x
                           if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+1][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           destroyer12.setVisible(false);
                           }
                        }
                         }
                         else{
                           if(y<7){//verifica que el barco no se vaya a salir de los limites de la matriz en y
                           if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y+1]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           destroyer12.setVisible(false);
                           }
                        }
                         }
                         SelectModeScreenController.infoContainer.getPlayerBoard1().placeCharacters(x, y, horizontalOvertical, numOfBoat);
                        }
                        }
                      
                        if(numOfBoat==7){
                        if (destroyerCounter<3){
                        
                         if(horizontalOvertical==1){
                           if(x<7){//verifica que el barco no se vaya a salir de los limites de la matriz en x
                           if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+1][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           destroyer13.setVisible(false);
                           }
                        }
                         }
                         else{
                           if(y<7){//verifica que el barco no se vaya a salir de los limites de la matriz en y
                           if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y+1]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           destroyer13.setVisible(false);
                           }
                        }
                         }
                         SelectModeScreenController.infoContainer.getPlayerBoard1().placeCharacters(x, y, horizontalOvertical, numOfBoat);
                        }
                      }
                        if(numOfBoat==8){
                        if(cruiserCounter<2){
                        
                        if(horizontalOvertical==1){
                           if(x<6){
                           if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+1][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+2][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           cruiserCounter=cruiserCounter+1;
                           cruiser11.setVisible(false);
                           }
                        }
                         }
                         else{
                            if(y<6){
                             if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y+1]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y+2]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           cruiserCounter=cruiserCounter+1;
                           cruiser11.setVisible(false);
                             }
                        }
                         }
                        SelectModeScreenController.infoContainer.getPlayerBoard1().placeCharacters(x, y, horizontalOvertical, numOfBoat);
                        }
                        }
                        if(numOfBoat==9){
                        if(cruiserCounter<2){
                        
                        if(horizontalOvertical==1){
                           if(x<6){
                           if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+1][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+2][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           cruiserCounter=cruiserCounter+1;
                           cruiser12.setVisible(false);
                           }
                        }
                         }
                         else{
                            if(y<6){
                             if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y+1]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y+2]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           cruiserCounter=cruiserCounter+1;
                           cruiser12.setVisible(false);
                             }
                        }
                         }
                        SelectModeScreenController.infoContainer.getPlayerBoard1().placeCharacters(x, y, horizontalOvertical, numOfBoat);
                        }
                      }
                        if(numOfBoat==10){
                        if(battleshipCounter<1){
                        
                        if(horizontalOvertical==1){
                          if(x<5 &&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+1][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+2][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+3][y]=='M'){
                              
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           battleshipCounter=battleshipCounter+1;
                           battleship11.setVisible(false);
                          }
                         }
                        
                         else{
                            if(y<5){
                             if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y+1]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y+2]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y+3]=='M'){   
                             SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                             battleshipCounter=battleshipCounter+1;
                             }
                            }
                         }
                        SelectModeScreenController.infoContainer.getPlayerBoard1().placeCharacters(x, y, horizontalOvertical, numOfBoat);
                        }
                        }
                        if(numOfBoat==0){
                            return;
                        }
                        //Aqui se rellena el gridpane dependiendo de las casillas y los barcos que la esten ocupando en la matriz char para mostrarlo graficamente
                         for(int a=0;a<8;a++){
                            for(int b=0;b<8;b++){
                              if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[a][b]=='S'){// se verifica si es un submarino para y poner el color rojo
                              Button button=new Button(); 
                              button.setPrefSize(174, 129); 
                              button.setStyle("-fx-background-color: red;-fx-border-color:black");
                              player1Board.add(button, b, a);
                              }
                              if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[a][b]=='D'){ //verifica si es un destructor para rellenar con color negro
                              Button button=new Button(); 
                              button.setPrefSize(174, 129); 
                              button.setStyle("-fx-background-color: black;-fx-border-color:white");
                              player1Board.add(button, b, a);
                              }
                              if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[a][b]=='C'){//verifica si es un crucero para rellenar con el color azul
                              Button button=new Button(); 
                              button.setPrefSize(174, 129); 
                              button.setStyle("-fx-background-color: blue;-fx-border-color:black");
                              player1Board.add(button, b, a);
                              }
                              if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[a][b]=='A'){//verifica si es un acorazado para rellenar con color verde
                              Button button=new Button(); 
                              button.setPrefSize(174, 129); 
                              button.setStyle("-fx-background-color: green;-fx-border-color:black");
                              player1Board.add(button, b, a);
                              }
                            }
                        }
                         numOfBoat=0; //esto para que cada vez que se coloque un barco la variable quede en cero y no se puede seguir colocando hasta que el jugador seleccione otro barco
    }
    //esta es la misma funcion pero se usar
    public void placeBoatsToZoneRandom(int x, int y, int randBoat){
                        if(randBoat==1){ //verifica si es el barco número 1
                        if(submarineCounter<4){ //verifica si ya el jugador puso todos sus barcos de este tipo
                        
                        if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'){  //verifica si las coordenadas estan desocupadas para poder anadir otro barco 
                        SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);// ocupa el espacio de la matriz char del jugador
                        submarineCounter=submarineCounter+1;// suma al contador de submarinos
                        isValidToContinue=true;
                        }
                        else{
                            isValidToContinue=false;
                         }
                        SelectModeScreenController.infoContainer.getPlayerBoard2().placeCharacters(x, y, horizontalOvertical, randBoat);// le coloca estas coordenadas al barco seleccionado
                        }
                       }
                        if(randBoat==2){
                        if(submarineCounter<4){
                        
                        if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'){   
                        SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                        submarineCounter=submarineCounter+1;
                        isValidToContinue=true;
                        }
                        else{
                           isValidToContinue=false; 
                         }
                        SelectModeScreenController.infoContainer.getPlayerBoard2().placeCharacters(x, y, horizontalOvertical, randBoat);
                        }
                       }
                       if(randBoat==3){
                       if(submarineCounter<4){
                        
                        if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'){   
                        SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                        submarineCounter=submarineCounter+1;
                        isValidToContinue=true;
                        }
                        else{
                           isValidToContinue=false; 
                         }
                        SelectModeScreenController.infoContainer.getPlayerBoard2().placeCharacters(x, y, horizontalOvertical, randBoat);
                        }
                       }
                        if(randBoat==4){
                        if(submarineCounter<4){
                        
                        if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'){   
                        SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                        submarineCounter=submarineCounter+1;
                        isValidToContinue=true;
                        }
                        else{
                           isValidToContinue=false; 
                         }
                        SelectModeScreenController.infoContainer.getPlayerBoard2().placeCharacters(x, y, horizontalOvertical, randBoat);
                        }
                      }
                        if(randBoat==5){
                        if (destroyerCounter<3){
                        
                         if(horizontalOvertical==1){
                           if(x<7){//verifica que el barco no se vaya a salir de los limites de la matriz en x
                           if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x+1][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           isValidToContinue=true;
                           }
                           else{
                           isValidToContinue=false; 
                         }
                        }
                           else{
                            isValidToContinue=false; 
                           }
                         }
                         else{
                           if(y<7){//verifica que el barco no se vaya a salir de los limites de la matriz en y
                           if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y+1]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           isValidToContinue=true;
                           }
                           else{
                           isValidToContinue=false; 
                           }
                          }
                           else{
                            isValidToContinue=false; 
                           }
                         }
                         SelectModeScreenController.infoContainer.getPlayerBoard2().placeCharacters(x, y, horizontalOvertical, randBoat);
                        }
                      }
                        if(randBoat==6){
                       if (destroyerCounter<3){
                         if(horizontalOvertical==1){
                           if(x<7){//verifica que el barco no se vaya a salir de los limites de la matriz en x
                           if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x+1][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           isValidToContinue=true;
                           }
                           else{
                           isValidToContinue=false; 
                           }
                          }
                           else{
                            isValidToContinue=false; 
                           }
                         }
                         else{
                           if(y<7){//verifica que el barco no se vaya a salir de los limites de la matriz en y
                           if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y+1]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           isValidToContinue=true;
                           }
                           else{
                           isValidToContinue=false; 
                           }
                          }
                           else{
                            isValidToContinue=false; 
                           }
                         }
                         SelectModeScreenController.infoContainer.getPlayerBoard2().placeCharacters(x, y, horizontalOvertical, randBoat);
                        }
                        }
                      
                        if(randBoat==7){
                        if (destroyerCounter<3){
                         if(horizontalOvertical==1){
                           if(x<7){//verifica que el barco no se vaya a salir de los limites de la matriz en x
                           if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x+1][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           isValidToContinue=true;
                           }
                           else{
                           isValidToContinue=false; 
                           }
                          }
                           else{
                            isValidToContinue=false; 
                           }
                         }
                         else{
                           if(y<7){//verifica que el barco no se vaya a salir de los limites de la matriz en y
                           if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y+1]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           isValidToContinue=true;
                           }
                           else{
                           isValidToContinue=false; 
                           }
                          }
                           else{
                            isValidToContinue=false; 
                           }
                         }
                         SelectModeScreenController.infoContainer.getPlayerBoard2().placeCharacters(x, y, horizontalOvertical, randBoat);
                        }
                        }
                        if(randBoat==8){
                        if(cruiserCounter<2){
                        
                        if(horizontalOvertical==1){
                           if(x<6){
                           if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x+1][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x+2][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                           cruiserCounter=cruiserCounter+1;
                           isValidToContinue=true;
                           }
                           else{
                           isValidToContinue=false; 
                           }
                          }
                           else{
                            isValidToContinue=false; 
                           }
                         }
                         else{
                            if(y<6){
                             if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y+1]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y+2]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                           cruiserCounter=cruiserCounter+1;
                           isValidToContinue=true;
                            }
                           else{
                           isValidToContinue=false; 
                           }
                          }
                            else{
                            isValidToContinue=false; 
                           }
                         }
                        SelectModeScreenController.infoContainer.getPlayerBoard2().placeCharacters(x, y, horizontalOvertical, randBoat);
                        }
                        }
                        if(randBoat==9){
                        if(cruiserCounter<2){
                        if(horizontalOvertical==1){
                           if(x<6){
                           if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x+1][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x+2][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                           cruiserCounter=cruiserCounter+1;
                           isValidToContinue=true;
                           }
                           else{
                           isValidToContinue=false; 
                           }
                        }
                           else{
                            isValidToContinue=false; 
                           }
                         }
                         else{
                            if(y<6){
                             if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y+1]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y+2]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                           cruiserCounter=cruiserCounter+1;
                           isValidToContinue=true;
                            }
                            else{
                           isValidToContinue=false; 
                           }
                        }
                            else{
                            isValidToContinue=false; 
                           }
                         }
                        SelectModeScreenController.infoContainer.getPlayerBoard2().placeCharacters(x, y, horizontalOvertical, randBoat);
                        }
                      }
                        if(randBoat==10){
                        if(battleshipCounter<1){
                        if(horizontalOvertical==1){
                          if(x<5 &&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x+1][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x+2][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x+3][y]=='M'){
                           SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                           battleshipCounter=battleshipCounter+1;
                           isValidToContinue=true;
                          }
                          else{
                           isValidToContinue=false; 
                           }
                         }
                        
                         else{
                            if(y<5){
                             if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y+1]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y+2]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y+3]=='M'){   
                             SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                             battleshipCounter=battleshipCounter+1;
                             isValidToContinue=true;
                             }
                             else{
                           isValidToContinue=false; 
                           }
                            }
                            else{
                            isValidToContinue=false; 
                           }
                         }
                        SelectModeScreenController.infoContainer.getPlayerBoard2().placeCharacters(x, y, horizontalOvertical, randBoat);
                        }
                        }
                        if(randBoat==0){
                            return;
                        }
                        //Aqui se rellena el gridpane dependiendo de las casillas y los barcos que la esten ocupando en la matriz char para mostrarlo graficamente
                         for(int a=0;a<8;a++){
                            for(int b=0;b<8;b++){
                              if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[a][b]=='S'){// se verifica si es un submarino para y poner el color rojo
                              Button button=new Button(); 
                              button.setPrefSize(174, 129); 
                              button.setStyle("-fx-background-color: red;-fx-border-color:black");
                              player2Board.add(button, b, a);
                              }
                              if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[a][b]=='D'){ //verifica si es un destructor para rellenar con color negro
                              Button button=new Button(); 
                              button.setPrefSize(174, 129); 
                              button.setStyle("-fx-background-color: black;-fx-border-color:white");
                              player2Board.add(button, b, a);
                              }
                              if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[a][b]=='C'){//verifica si es un crucero para rellenar con el color azul
                              Button button=new Button(); 
                              button.setPrefSize(174, 129); 
                              button.setStyle("-fx-background-color: blue;-fx-border-color:black");
                              player2Board.add(button, b, a);
                              }
                              if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[a][b]=='A'){//verifica si es un acorazado para rellenar con color verde
                              Button button=new Button(); 
                              button.setPrefSize(174, 129); 
                              button.setStyle("-fx-background-color: green;-fx-border-color:black");
                              player2Board.add(button, b, a);
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
