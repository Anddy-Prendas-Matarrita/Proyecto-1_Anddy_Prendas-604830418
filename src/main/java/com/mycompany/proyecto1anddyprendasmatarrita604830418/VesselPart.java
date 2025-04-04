
package com.mycompany.proyecto1anddyprendasmatarrita604830418;

/**
 *
 * @author Anddy Prendas
 */
//Esta clase representa un espacio en la matriz que ocuparán las embarcaciones dependiendo de su tamaño, las embarcaciones tendrán un arreglo de VesselPart
//y dependiendo de su tamaño, este arreglo será de cierto tamaño
public class VesselPart {
    private int life;
    private int x;
    private int y;
    private boolean isDamaged = false;
    public VesselPart(){
        
    }
    public VesselPart(int nLife, int nX, int nY){
        life=nLife;
        x=nX;
        y=nY;
    }
    public void receiveAttack(int enemyAttack){
        if(life==0) {
            System.out.println("Esta parte de la embarcación ya ha sido dañada");
            return;
        }
        if(life>0) {
            life = life - enemyAttack;
        }
        if (life<=0){
            life=0;
            isDamaged = true;
        }
//En esta función, la parte de la embarcación recibe el daño y se le baja cierta cantidad de vida, depende del daño que reciba.
//Si la vida llega a cero o menos, la vida será cero y el estado de esta parte del barco será "dañada".
//En caso de que ya la vida sea cero desde un inicio, la función terminará sin hacer ningún efecto.
    }

    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public boolean getIsDamaged() {
        return isDamaged;
    }
}