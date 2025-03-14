/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1anddyprendasmatarrita604830418;

/**
 *
 * @author Anddy Prendas
 */
public abstract class Player {
      protected String name;
    protected String playerType;
    protected int turnsNumber=0; //Este es el número de turnos que lleva el jugador que inicia en 0.
    protected boolean itIsMyTurn=false; //Este atributo bool, permite saber si es el turno del jugador o no.
    protected Board myBoard;
    protected Board enemyBoard;
    
    public Player(){}
    public Player(String name,String playerType,int turnsNumber, Board myBoard, Board enemyBoard){
        this.name=name;
        this.playerType=playerType;
        this.turnsNumber=turnsNumber;
        this.myBoard=myBoard;
        this.enemyBoard=enemyBoard;
    }
}
