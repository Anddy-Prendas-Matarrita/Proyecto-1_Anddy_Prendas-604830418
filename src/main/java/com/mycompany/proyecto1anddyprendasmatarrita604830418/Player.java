/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1anddyprendasmatarrita604830418;

/**
 *
 * @author Anddy Prendas
 */
public class Player {
    private String name;
    private String playerType;
    private int turnsNumber=0; //Este es el número de turnos que lleva el jugador que inicia en 0.
    private boolean isMyTurn=false; //Este atributo bool, permite saber si es el turno del jugador o no.
    private Board myBoard;
    private Board enemyBoard;
    
    public Player(){}
    public Player(String name,String playerType, Board myBoard, Board enemyBoard){
        this.name=name;
        this.playerType=playerType;
        this.myBoard=myBoard;
        this.enemyBoard=enemyBoard;
    }
    public void setName(String newName){
        this.name=newName;
    }
    public void setMyBoard(Board newMyBoard){
        this.myBoard=newMyBoard;
    }
    public void setEnemyBoard(Board newEnemyBoard){
        this.enemyBoard=newEnemyBoard;
    }
    public void setPlayerType(String newType){
        this.playerType=newType;
    }
    public void setIsMyTurn(boolean newMyTurn){
        this.isMyTurn=newMyTurn;
    }
    public String getName(){
        return this.name;
    }
    public Board getBoard(){
        return myBoard;
        }
}
