package com.mycompany.proyecto1anddyprendasmatarrita604830418;
import java.util.Random;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;


public class HardMatchScreenController {
    @FXML 
    private Button showPcButton;
    @FXML 
    private Button hideButton;
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
    @FXML
    private Button returnMenuButton;
    @FXML
    private Text messagesText;
    @FXML
    private Text messagesText1;
    @FXML
    private TextArea winnerText;
    private String winner;
    private boolean isPlayerAttacking;
    private boolean isValidToContinue=true;
    private int submarineCounter=0;
    private int destroyerCounter=0;
    private int cruiserCounter=0;
    private boolean hasAttacked=false;
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
        for(int f=0;f<16;f++){ // for para recorrer el tablero entero
        for(int c=0;c<16;c++){
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
    @FXML
    public void hidePcBoard(){
        hideButton.setVisible(false);
        showPcButton.setVisible(true);
        prepareGridToAttack2();
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
          randomX=random.nextInt(16);// se genera un numero aleatorio entre 0 y 7 para la posicion en x
          randomY=random.nextInt(16);// se genera un numero aleatorio entre 0 y 7 para la posicion en y
          placeBoatsToZoneRandom(randomX,randomY,aux+1); // se llama la funcion que se encarga de colocar los barcos en el tablero y de forma logica, usando los numeor antes creados
          if(isValidToContinue==true){ //esta verifica si el barco fue realmente colocado o si no se coloco por salirse de los limites o por que ya habia un barco en esa posicion
              aux=aux+1;//se le suma a la variable para que avance, sino se coloco el barco, se repite hasta que se coloque
          }  
  }
   while(aux<7){//bucle para colocar los destructores
      horizontalOvertical=(random.nextInt(2))+1;
          randomX=random.nextInt(16);
          randomY=random.nextInt(16);
          placeBoatsToZoneRandom(randomX,randomY,aux+1);
          if(isValidToContinue==true){
              aux=aux+1;
          }  
  }
      while(aux<9){ //bucle para colocar los cruceros
      horizontalOvertical=(random.nextInt(2))+1;
          randomX=random.nextInt(16);
          randomY=random.nextInt(16);
          placeBoatsToZoneRandom(randomX,randomY,aux+1);
          if(isValidToContinue==true){
              aux=aux+1;
          }  
  }
      while(aux<10){ //bucle para colocar el acorazado
      horizontalOvertical=(random.nextInt(2))+1;
          randomX=random.nextInt(16);
          randomY=random.nextInt(16);
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
        public void showPcBoard(){
            showPcButton.setVisible(false);
            hideButton.setVisible(true);
            for(int a=0;a<16;a++){
                            for(int b=0;b<16;b++){
                              if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[a][b]=='S'){// se verifica si es un submarino para y poner el color rojo
                              Button button=new Button(); 
                              button.setPrefSize(174, 129); 
                              button.setStyle("-fx-background-color: red;-fx-border-color:black");
                              player2Board.add(button, b, a);
                              }
                              else if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[a][b]=='D'){ //verifica si es un destructor para rellenar con color negro
                              Button button=new Button(); 
                              button.setPrefSize(174, 129); 
                              button.setStyle("-fx-background-color: black;-fx-border-color:white");
                              player2Board.add(button, b, a);
                              }
                              else if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[a][b]=='C'){//verifica si es un crucero para rellenar con el color azul
                              Button button=new Button(); 
                              button.setPrefSize(174, 129); 
                              button.setStyle("-fx-background-color: blue;-fx-border-color:black");
                              player2Board.add(button, b, a);
                              }
                              else if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[a][b]=='A'){//verifica si es un acorazado para rellenar con color verde
                              Button button=new Button(); 
                              button.setPrefSize(174, 129); 
                              button.setStyle("-fx-background-color: green;-fx-border-color:black");
                              player2Board.add(button, b, a);
                              }
                              else if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[a][b]=='H'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[a][b]=='M'){//verifica si es un acorazado para rellenar con color verde
                              Button button=new Button(); 
                              button.setPrefSize(174, 129); 
                              button.setStyle("-fx-background-color: white;-fx-border-color:black");
                              player2Board.add(button, b, a);
                              }
                              
                            }
            }
        }
    @FXML
    public void endEditing(){ //para terminar de colocar barcos
        
        if(submarineCounter==4 && destroyerCounter==3 && cruiserCounter==2 && battleshipCounter==1){//solo se termina de colocar si ya fueron colocados todos los barcos
            editOffButton.setVisible(false);
        horizontalButton.setVisible(false);
        verticalButton.setVisible(false);
        prepareGridToAttack2();
        player2Board.setVisible(true);
        isValidToContinue=false;
        showPcButton.setVisible(true);
        }
        else{
            System.out.println("No se puede terminar la colocacion hasta que se coloquen todos los barcos");
        }
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
    //Esta función define si es el turno de atacar del jugador 1
    public void setPlayerAttacking(){
        isPlayerAttacking = true;
    }
    public void setPCAttacking(){
        isPlayerAttacking = false;
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
                           if(x<15){//verifica que el barco no se vaya a salir de los limites de la matriz en x
                           if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+1][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           destroyer11.setVisible(false);
                           }
                        }
                         }
                         else{
                           if(y<15){//verifica que el barco no se vaya a salir de los limites de la matriz en y
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
                           if(x<15){//verifica que el barco no se vaya a salir de los limites de la matriz en x
                           if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+1][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           destroyer12.setVisible(false);
                           }
                        }
                         }
                         else{
                           if(y<15){//verifica que el barco no se vaya a salir de los limites de la matriz en y
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
                           if(x<15){//verifica que el barco no se vaya a salir de los limites de la matriz en x
                           if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+1][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           destroyerCounter=destroyerCounter+1;
                           destroyer13.setVisible(false);
                           }
                        }
                         }
                         else{
                           if(y<15){//verifica que el barco no se vaya a salir de los limites de la matriz en y
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
                           if(x<14){
                           if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+1][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+2][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           cruiserCounter=cruiserCounter+1;
                           cruiser11.setVisible(false);
                           }
                        }
                         }
                         else{
                            if(y<14){
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
                           if(x<14){
                           if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+1][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+2][y]=='M'){   
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           cruiserCounter=cruiserCounter+1;
                           cruiser12.setVisible(false);
                           }
                        }
                         }
                         else{
                            if(y<14){
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
                          if(x<13 &&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+1][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+2][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x+3][y]=='M'){
                              
                           SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                           battleshipCounter=battleshipCounter+1;
                           battleship11.setVisible(false);
                          }
                         }
                        
                         else{
                            if(y<13){
                             if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y+1]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y+2]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y+3]=='M'){   
                             SelectModeScreenController.infoContainer.getPlayerVessel1(numOfBoat-1).setPositions(x, y, horizontalOvertical);
                             battleshipCounter=battleshipCounter+1;
                             battleship11.setVisible(false);
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
                         for(int a=0;a<16;a++){
                            for(int b=0;b<16;b++){
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
                           if(x<15){//verifica que el barco no se vaya a salir de los limites de la matriz en x
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
                           if(y<15){//verifica que el barco no se vaya a salir de los limites de la matriz en y
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
                           if(x<15){//verifica que el barco no se vaya a salir de los limites de la matriz en x
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
                           if(y<15){//verifica que el barco no se vaya a salir de los limites de la matriz en y
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
                           if(x<15){//verifica que el barco no se vaya a salir de los limites de la matriz en x
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
                           if(y<15){//verifica que el barco no se vaya a salir de los limites de la matriz en y
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
                           if(x<14){
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
                            if(y<14){
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
                           if(x<14){
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
                            if(y<14){
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
                          if(x<13 &&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x+1][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x+2][y]=='M'&&SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x+3][y]=='M'){
                           SelectModeScreenController.infoContainer.getPlayerVessel2(randBoat-1).setPositions(x, y, horizontalOvertical);
                           battleshipCounter=battleshipCounter+1;
                           isValidToContinue=true;
                          }
                          else{
                           isValidToContinue=false; 
                           }
                         }
                         else{
                            if(y<13){
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
                         for(int a=0;a<16;a++){
                            for(int b=0;b<16;b++){
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
    public void prepareGridToAttack1(){
        for(int row=0;row<16;row++){
          for(int column=0;column<16;column++){
            if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[row][column]=='F'){
            Button button=new Button(); // Se le asigna un botón a cada casilla 
            button.setPrefSize(174, 129); // Se le asigna un tamaño a cada botón
            button.setStyle("-fx-background-image: url('images/notAvailableToAttack.jpg');-fx-border-color:black");
            player1Board.add(button, column, row); //Aquí el botón es introducido al Grid
            }
            else if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[row][column]=='H'){
            Button button=new Button(); // Se le asigna un botón a cada casilla 
            button.setPrefSize(174, 129); // Se le asigna un tamaño a cada botón
            button.setStyle("-fx-background-image: url('images/Water.jpeg');-fx-border-color:black");
            player1Board.add(button, column, row); //Aquí el botón es introducido al Grid
            }
            else{
                 if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[row][column]=='S'){// se verifica si es un submarino para y poner el color rojo
                 Button button=new Button(); 
                 button.setPrefSize(174, 129); 
                 button.setStyle("-fx-background-color: red;-fx-border-color:black");
                 player1Board.add(button, column, row);
                 }
                 if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[row][column]=='D'){ //verifica si es un destructor para rellenar con color negro
                 Button button=new Button(); 
                 button.setPrefSize(174, 129); 
                 button.setStyle("-fx-background-color: black;-fx-border-color:white");
                 player1Board.add(button, column, row);
                 }
                 if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[row][column]=='C'){//verifica si es un crucero para rellenar con el color azul
                 Button button=new Button(); 
                 button.setPrefSize(174, 129); 
                 button.setStyle("-fx-background-color: blue;-fx-border-color:black");
                 player1Board.add(button, column, row);
                 }
                 if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[row][column]=='A'){//verifica si es un acorazado para rellenar con color verde
                 Button button=new Button(); 
                 button.setPrefSize(174, 129); 
                 button.setStyle("-fx-background-color: green;-fx-border-color:black");
                 player1Board.add(button, column, row);
                 }
            }
          }
        }
    }
    @FXML
    public void returnToMenu()throws IOException{
        App.setRoot("MenuScreen");
    }
    public boolean isWinnerDefined(char[][] matrix){
        int counter=0;
        for(int i=0;i<16;i++){
            for(int e=0;e<16;e++){
             if(matrix[i][e]=='F'){
                 counter++;
             }
            }
        }
        if(counter==20){
            return true;
        }
        else{
            return false;
        }
    }
   
    public void prepareGridToAttack2(){
        for(int row=0;row<16;row++){
          for(int column=0;column<16;column++){
            if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[row][column]=='F'){
            Button button=new Button(); // Se le asigna un botón a cada casilla 
            button.setPrefSize(174, 129); // Se le asigna un tamaño a cada botón
            button.setStyle("-fx-background-image: url('images/notAvailableToAttack.jpg');-fx-border-color:black");
            player2Board.add(button, column, row); //Aquí el botón es introducido al Grid
            }
            else if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[row][column]=='H'){
            Button button=new Button(); // Se le asigna un botón a cada casilla 
            button.setPrefSize(174, 129); // Se le asigna un tamaño a cada botón
            button.setStyle("-fx-background-image: url('images/Water.jpeg');-fx-border-color:black");
            player2Board.add(button, column, row); //Aquí el botón es introducido al Grid
            }
            
            else{
            Button button=new Button(); // Se le asigna un botón a cada casilla 
            button.setPrefSize(174, 129); // Se le asigna un tamaño a cada botón
            button.setStyle("-fx-background-image: url('images/availableToAttack.jpg');-fx-border-color:black");
            button.setOnAction(event -> {
                int newRow=player2Board.getRowIndex(button);
                int newColumn=player2Board.getColumnIndex(button);
                getAttackPlayer2(newRow,newColumn);
            });
            player2Board.add(button, column, row); //Aquí el botón es introducido al Grid
            }
          }
        }
    }
    public void getAttackPlayer2(int x, int y){
        if(isWinnerDefined(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard())==true &&isWinnerDefined(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard())==true){
                System.out.println("Empate");
                prepareGridToAttack1();
                prepareGridToAttack2();
                winnerText.setText("Empate");
                winnerText.setVisible(true);
                returnMenuButton.setVisible(true);
                return;
            }
        if(isWinnerDefined(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard())==true){
                winner=SelectModeScreenController.infoContainer.getPlayer2Name();
                System.out.println(winner);
                System.out.println("ha ganado");
                prepareGridToAttack1();
                prepareGridToAttack2();
                winnerText.setText("Ganador:"+winner);
                winnerText.setVisible(true);
                returnMenuButton.setVisible(true);
                return;
            }
            if(isWinnerDefined(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard())==true){
                winner=SelectModeScreenController.infoContainer.getPlayer1Name();
                System.out.println(winner);
                System.out.println("ha ganado");
                prepareGridToAttack1();
                prepareGridToAttack2();
                winnerText.setText("Ganador:"+winner);
                winnerText.setVisible(true);
                returnMenuButton.setVisible(true);
                return;
            }

            if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='S'){
                for(int i=0;i<4;i++){
                      if(SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[i].getVesselPart()[0].getX()==x && SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[i].getVesselPart()[0].getY()==y){
                        SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[i].getVesselPart()[0].receiveAttack(1);
                        if(SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[i].getVesselPart()[0].getIsDamaged()==true){
                        SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]='F';
                       messagesText.setText(SelectModeScreenController.infoContainer.getPlayer1Name() + " ha hundido una embarcación");
                        }
                        else{
                        System.out.println("Toque! submarino PLAYER");
                        messagesText.setText(SelectModeScreenController.infoContainer.getPlayer1Name() + " le ha dado a una embarcación");
                        }
                      }
                }
            }
            else if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='D'){
              int counter=0;
                for(int i=4;i<7;i++){
                    for(int e=0;e<2;e++){
                      if(SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[i].getVesselPart()[e].getX()==x && SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[i].getVesselPart()[e].getY()==y){
                        SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[i].getVesselPart()[e].receiveAttack(1);
                        for(int u=0;u<2;u++){
                        if(SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[i].getVesselPart()[u].getIsDamaged()==true){
                            counter++;
                        }
                        }
                        if(counter==2){
                          SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]='F';
                          messagesText.setText(SelectModeScreenController.infoContainer.getPlayer1Name() + " ha hundido una embarcación");  
                        }else{
                        System.out.println("Toque! destructor PLAYER");
                        messagesText.setText(SelectModeScreenController.infoContainer.getPlayer1Name() + " le ha dado a una embarcación");
                        }
                      }
                    }
                }
            }
            else if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='C'){
               int counter=0;
                for(int i=7;i<9;i++){
                    for(int e=0;e<3;e++){
                      if(SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[i].getVesselPart()[e].getX()==x && SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[i].getVesselPart()[e].getY()==y){
                        SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[i].getVesselPart()[e].receiveAttack(1);
                        for(int u=0;u<3;u++){
                            if(SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[i].getVesselPart()[u].getIsDamaged()==true){
                                counter++;
                            }
                        }
                        if(counter==3){
                            SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]='F';
                            messagesText.setText(SelectModeScreenController.infoContainer.getPlayer1Name() + " ha hundido una embarcación");
                        }
                        else{
                        System.out.println("Toque! crucero PLAYER");
                        messagesText.setText(SelectModeScreenController.infoContainer.getPlayer1Name() + " le ha dado a una embarcación");
                        }
                      }
                    }
                }
            }
            else if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='A'){
                   int counter=0;
                    for(int e=0;e<4;e++){
                      if(SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[9].getVesselPart()[e].getX()==x && SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[9].getVesselPart()[e].getY()==y){
                        SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[9].getVesselPart()[e].receiveAttack(1);
                        for(int u=0;u<4;u++){
                            if(SelectModeScreenController.infoContainer.getPlayerBoard2().getVeselList()[9].getVesselPart()[e].getIsDamaged()==true){
                                counter++;
                            }
                        }
                        if(counter==4){
                            SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]='F';
                            messagesText.setText(SelectModeScreenController.infoContainer.getPlayer1Name() + " ha hundido una embarcación");
                        }
                        else{
                        System.out.println("Toque! acorazado PLAYER");
                        messagesText.setText(SelectModeScreenController.infoContainer.getPlayer1Name() + " le ha dado a una embarcación");
                        }
                    }
                }
            }
            else if(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]=='M'){
                System.out.println("Agua! PC");
              SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard()[x][y]='H';
              messagesText.setText(SelectModeScreenController.infoContainer.getPlayer1Name() + " ha fallado el tiro");
            }
           
            
            getAttackPlayer1();
           prepareGridToAttack2();
        }
        public void getAttackPlayer1(){
            if(isWinnerDefined(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard())==true &&isWinnerDefined(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard())==true){
                System.out.println("Empate");
                prepareGridToAttack1();
                prepareGridToAttack2();
                winnerText.setText("Empate");
                winnerText.setVisible(true);
                returnMenuButton.setVisible(true);
                return;
            }
            if(isWinnerDefined(SelectModeScreenController.infoContainer.getPlayerBoard2().getCharBoard())==true){
                winner=SelectModeScreenController.infoContainer.getPlayer1Name();
                System.out.println(winner);
                System.out.println("ha ganado");
                prepareGridToAttack1();
                prepareGridToAttack2();
                winnerText.setText("Ganador:"+winner);
                winnerText.setVisible(true);
                returnMenuButton.setVisible(true);
                return;
            }
             if(isWinnerDefined(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard())==true){
                winner=SelectModeScreenController.infoContainer.getPlayer2Name();
                System.out.println(winner);
                System.out.println("ha ganado");
                prepareGridToAttack1();
                prepareGridToAttack2();
                winnerText.setText("Ganador:"+winner);
                winnerText.setVisible(true);
                returnMenuButton.setVisible(true);
                return;
            }
            int x=random.nextInt(16);
            int y=random.nextInt(16);
            if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='S'){
                for(int i=0;i<4;i++){
                      if(SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[i].getVesselPart()[0].getX()==x && SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[i].getVesselPart()[0].getY()==y){
                        SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[i].getVesselPart()[0].receiveAttack(1);
                        if(SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[i].getVesselPart()[0].getIsDamaged()==true){
                        SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]='F';
                       messagesText1.setText(SelectModeScreenController.infoContainer.getPlayer2Name() + " ha hundido una embarcación");
                        }
                        else{
                        System.out.println("Toque! submarino PLAYER");
                        messagesText1.setText(SelectModeScreenController.infoContainer.getPlayer2Name() + " le ha dado a una embarcación");
                        }
                      }
                }
            }
            else if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='D'){
                int counter=0;
                for(int i=4;i<7;i++){
                    for(int e=0;e<2;e++){
                      if(SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[i].getVesselPart()[e].getX()==x && SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[i].getVesselPart()[e].getY()==y){
                        SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[i].getVesselPart()[e].receiveAttack(1);
                        for(int u=0;u<2;u++){
                        if(SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[i].getVesselPart()[u].getIsDamaged()==true){
                            counter++;
                        }
                        }
                        if(counter==2){
                          SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]='F';
                          messagesText1.setText(SelectModeScreenController.infoContainer.getPlayer2Name() + " ha hundido una embarcación");  
                        }else{
                        System.out.println("Toque! destructor PLAYER");
                        messagesText1.setText(SelectModeScreenController.infoContainer.getPlayer2Name() + " le ha dado a una embarcación");
                        }
                      }
                    }
                }
            }
            else if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='C'){
                int counter=0;
                for(int i=7;i<9;i++){
                    for(int e=0;e<3;e++){
                      if(SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[i].getVesselPart()[e].getX()==x && SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[i].getVesselPart()[e].getY()==y){
                        SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[i].getVesselPart()[e].receiveAttack(1);
                        for(int u=0;u<3;u++){
                            if(SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[i].getVesselPart()[u].getIsDamaged()==true){
                                counter++;
                            }
                        }
                        if(counter==3){
                            SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]='F';
                            messagesText1.setText(SelectModeScreenController.infoContainer.getPlayer2Name() + " ha hundido una embarcación");
                        }
                        else{
                        System.out.println("Toque! crucero PLAYER");
                        messagesText1.setText(SelectModeScreenController.infoContainer.getPlayer2Name() + " le ha dado a una embarcación");
                        }
                      }
                    }
                }
            }
            else if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='A'){
                int counter=0;
                    for(int e=0;e<4;e++){
                      if(SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[9].getVesselPart()[e].getX()==x && SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[9].getVesselPart()[e].getY()==y){
                        SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[9].getVesselPart()[e].receiveAttack(1);
                        for(int u=0;u<4;u++){
                            if(SelectModeScreenController.infoContainer.getPlayerBoard1().getVeselList()[9].getVesselPart()[e].getIsDamaged()==true){
                                counter++;
                            }
                        }
                        if(counter==4){
                            SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]='F';
                            messagesText1.setText(SelectModeScreenController.infoContainer.getPlayer2Name() + " ha hundido una embarcación");
                        }
                        else{
                        System.out.println("Toque! acorazado PLAYER");
                        messagesText1.setText(SelectModeScreenController.infoContainer.getPlayer2Name() + " le ha dado a una embarcación");
                        }
                    }
                }
            }
            else if(SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]=='M'){
                System.out.println("Agua! PLAYER");
              SelectModeScreenController.infoContainer.getPlayerBoard1().getCharBoard()[x][y]='H';
              messagesText1.setText(SelectModeScreenController.infoContainer.getPlayer2Name() + " ha fallado");
            }
            else{
                getAttackPlayer1(); //se usa recursividad para que siga hasta que cree una coordenada que sirva
            }
           
           prepareGridToAttack1();
        }
    }