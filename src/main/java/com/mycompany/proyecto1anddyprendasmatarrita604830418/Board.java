/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1anddyprendasmatarrita604830418;

/**
 *
 * @author Anddy Prendas
 */
// Esta clase representa el tablero que tendrán ambos jugadores
public class Board {
        private char[][] board;
        private Vessel[] myVesselList=new Vessel[11];

    public Board(){
    }
    //En el constructor, dependiendo de la dificultad que se le pase por parámetro,
    //también cambiará el tamaño de la matriz.
    //La matriz también se llenará con M para cada posición, que indica que hay Mar
    public Board(int difficultyBoard){
        int modeLife;  //Esta variable contiene la cantidad de vida que va a tener cada parte de embarcación segÚn su dificultad.
        if (difficultyBoard ==1){
            board=new char[8][8];
            for(int f=0;f<8;f++){

                for(int c=0;c<8;c++){
                    board[f][c]='M';
                }
            }
            modeLife=1; //En la dificultad fácil, cada parte de embarcación tendrá 1 vida (se dañará esa parte de un disparo)
            Vessel submarine1=new Submarine(modeLife);
            Vessel submarine2=new Submarine(modeLife);
            Vessel submarine3=new Submarine(modeLife);
            Vessel submarine4=new Submarine(modeLife);
            Vessel destroyer1=new Destroyer(modeLife);
            Vessel destroyer2=new Destroyer(modeLife);
            Vessel destroyer3=new Destroyer(modeLife);
            Vessel cruiser1=new Cruiser(modeLife);
            Vessel cruiser2=new Cruiser(modeLife);
            Vessel battleShip1=new Battleship(modeLife);
            myVesselList[0]=submarine1;
            myVesselList[1]=submarine2;
            myVesselList[2]=submarine3;
            myVesselList[3]=submarine4;
            myVesselList[4]=destroyer1;
            myVesselList[5]=destroyer2;
            myVesselList[6]=destroyer3;
            myVesselList[7]=cruiser1;
            myVesselList[8]=cruiser2;
            myVesselList[9]=battleShip1;
        }
        else if (difficultyBoard ==2){
            board=new char[12][12];
            for(int f=0;f<12;f++){

                for(int c=0;c<12;c++){
                    board[f][c]='M';
                }
            }
            modeLife=2; //En la dificultad media, cada parte de embarcación tendrá 2 vidas (se dañará esa parte de dos disparos)
            Vessel submarine1=new Submarine(modeLife);
            Vessel submarine2=new Submarine(modeLife);
            Vessel submarine3=new Submarine(modeLife);
            Vessel submarine4=new Submarine(modeLife);
            Vessel destroyer1=new Destroyer(modeLife);
            Vessel destroyer2=new Destroyer(modeLife);
            Vessel destroyer3=new Destroyer(modeLife);
            Vessel cruiser1=new Cruiser(modeLife);
            Vessel cruiser2=new Cruiser(modeLife);
            Vessel battleShip1=new Battleship(modeLife);
            myVesselList[0]=submarine1;
            myVesselList[1]=submarine2;
            myVesselList[2]=submarine3;
            myVesselList[3]=submarine4;
            myVesselList[4]=destroyer1;
            myVesselList[5]=destroyer2;
            myVesselList[6]=destroyer3;
            myVesselList[7]=cruiser1;
            myVesselList[8]=cruiser2;
            myVesselList[9]=battleShip1;
        }
        else if (difficultyBoard ==3){
            board=new char[16][16];
            for(int f=0;f<16;f++){

                for(int c=0;c<16;c++){
                    board[f][c]='M';
                }
            }
            modeLife=3; //En la dificultad difícil, cada parte de embarcación tendrá 3 vidas (se dañará esa parte de tres disparos)
            Vessel submarine1=new Submarine(modeLife);
            Vessel submarine2=new Submarine(modeLife);
            Vessel submarine3=new Submarine(modeLife);
            Vessel submarine4=new Submarine(modeLife);
            Vessel destroyer1=new Destroyer(modeLife);
            Vessel destroyer2=new Destroyer(modeLife);
            Vessel destroyer3=new Destroyer(modeLife);
            Vessel cruiser1=new Cruiser(modeLife);
            Vessel cruiser2=new Cruiser(modeLife);
            Vessel battleShip1=new Battleship(modeLife);
            myVesselList[0]=submarine1;
            myVesselList[1]=submarine2;
            myVesselList[2]=submarine3;
            myVesselList[3]=submarine4;
            myVesselList[4]=destroyer1;
            myVesselList[5]=destroyer2;
            myVesselList[6]=destroyer3;
            myVesselList[7]=cruiser1;
            myVesselList[8]=cruiser2;
            myVesselList[9]=battleShip1;
        }
        else{
            board=new char[11][11];
            for(int f=0;f<11;f++){

                for(int c=0;c<11;c++){
                    board[f][c]='M';
                }
            }
            modeLife=1; //En la dificultad difícil, cada parte de embarcación tendrá 3 vidas (se dañará esa parte de tres disparos)
            Vessel submarine1=new Submarine(modeLife);
            Vessel submarine2=new Submarine(modeLife);
            Vessel submarine3=new Submarine(modeLife);
            Vessel submarine4=new Submarine(modeLife);
            Vessel destroyer1=new Destroyer(modeLife);
            Vessel destroyer2=new Destroyer(modeLife);
            Vessel destroyer3=new Destroyer(modeLife);
            Vessel cruiser1=new Cruiser(modeLife);
            Vessel cruiser2=new Cruiser(modeLife);
            Vessel battleShip1=new Battleship(modeLife);
            myVesselList[0]=submarine1;
            myVesselList[1]=submarine2;
            myVesselList[2]=submarine3;
            myVesselList[3]=submarine4;
            myVesselList[4]=destroyer1;
            myVesselList[5]=destroyer2;
            myVesselList[6]=destroyer3;
            myVesselList[7]=cruiser1;
            myVesselList[8]=cruiser2;
            myVesselList[9]=battleShip1;
        }
    }
    public Vessel getVessel(int num){
    return myVesselList[num];
    }
    
}

