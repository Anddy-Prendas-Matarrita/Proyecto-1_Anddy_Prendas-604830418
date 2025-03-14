/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1anddyprendasmatarrita604830418;

/**
 *
 * @author Anddy Prendas
 */
public class Submarine extends Vessel {
    private VesselPart[] vesselPart= new VesselPart[1];

    public Submarine(){
    }
    public Submarine(int lifePart){
        vesselPart[0].setLife(lifePart);
    }
    public void updateState(){
        //Esta función actualiza el estado de la embarcación, si está hundido o no
            if(vesselPart[0].getIsDamaged()==true){
                isFallen=true;
            }
    }
    @Override
    //Esta función busca la parte de la embarcación que fue atacada mediante coordenadas y si coinciden
    //el barco recibirá el daño y retornará false, pero si también se detecta que el barco está hundido se retornará true.
    //Esto permite que luego se pueda ajustar la vida de las partes de los barcos y funcione perfectamente.
    public boolean searchAttackedPart(int x, int y){
            if (vesselPart[0].getX()==x && vesselPart[0].getY()==y){
                vesselPart[0].receiveAttack(1);
                if(vesselPart[0].getIsDamaged()==true) {
                    return true;
                }
            }
        return false;
    }
    }