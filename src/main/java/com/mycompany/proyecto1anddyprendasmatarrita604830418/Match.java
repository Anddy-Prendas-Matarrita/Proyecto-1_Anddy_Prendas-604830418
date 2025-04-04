/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1anddyprendasmatarrita604830418;

/**
 *
 * @author Anddy Prendas
 */
public class Match {
    private int difficulty; //La dificultad es del 1 al 3, siendo la 3 la dificil.
    private String winner;
    private Player player1;
    private Player player2;
    
    public Match(){}
    public Match(int difficulty, Player player1, Player player2){
        this.difficulty=difficulty;
        this.player1=player1;
        this.player2=player2;
        //se crean los tableros de ambos jugadores
        Board player1Board=new Board(difficulty); 
        Board player2Board=new Board(difficulty);
        //se setean los tableros del jugador 2
        player1.setMyBoard(player1Board);
        player1.setEnemyBoard(player2Board);
        //se setean los tableros del jugador 2
        player2.setMyBoard(player2Board);
        player2.setEnemyBoard(player1Board);
    }
}
