/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espol.tresenrayag3;

/**
 *
 * @author maycmont
 */
public class Box extends Publisher{
    private char value;
    
    public void setValue(char value) throws Exception{
        if (value != 0) {
            this.value = value;
            notifySuscribers();
        } else {
            throw new Exception("Esta casilla ya tiene un valor");
        }
    }
    
    public char getValue() {
        return value;
    }
    
    public boolean isEmpty() {
        return value == 0;
    }
    
    public boolean contains(char value) {
        return this.value == value;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "_";
        return String.valueOf(value);
    }
}
