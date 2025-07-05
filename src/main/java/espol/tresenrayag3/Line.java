/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espol.tresenrayag3;

import java.util.Arrays;

/**
 *
 * @author maycmont
 */
public class Line extends Publisher implements Suscriber {
    private Box[] casillas = new Box[3];
    private int size = 0;
    
    public void add(Box box) {
        box.addSuscriber(this);
        casillas[size] = box;
        size++;
    }
    
    public boolean isEqual() {
        char first = casillas[0].getValue();
        for (Box casilla : casillas) {
            if (!casilla.contains(first)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isAvailableFor(char value) {
        for (Box casilla : casillas) {
            if (!casilla.contains(value) && !casilla.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isEmpty() {
        for (Box casilla : casillas) {
            if (!casilla.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public Box getAt(int index){
        return casillas[index];
    }
    
    @Override
    public String toString() {
        String line = "| ";
        for (Box box : casillas) {
            line += box.toString() + " | ";
        }
        return line;
    }

    @Override
    public void onNotify() {
        if (isEqual()) {
            notifySuscribers();
        }
    }
}
