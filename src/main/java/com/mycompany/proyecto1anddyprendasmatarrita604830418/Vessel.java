
package com.mycompany.proyecto1anddyprendasmatarrita604830418;

/**
 *
 * @author Anddy Prendas
 */
public abstract class Vessel {
    
protected boolean isFallen=false;

public Vessel (){
}
public boolean getIsFallen(){
    return isFallen;
}
//Esta función es abstracta, ya que se tiene que definir en las clases hijas.
public abstract boolean searchAttackedPart(int x, int y);
}
