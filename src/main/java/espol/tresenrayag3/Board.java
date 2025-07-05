/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espol.tresenrayag3;

/**
 *
 * @author maycmont
 */
public class Board implements Suscriber {
    private final Line[] rows = {new Line(), new Line(), new Line()};
    private final Line[] columns = {new Line(), new Line(), new Line()};
    private final Line[] diagonals = {new Line(), new Line()};
    
    public Board() {
        diagonals[0].addSuscriber(this);
        diagonals[1].addSuscriber(this);
        for (int i = 0; i<3; i++) {
            rows[i].addSuscriber(this);
            columns[i].addSuscriber(this);
            for (int j = 0; j<3; j++) {
                Box newBox = new Box();
                rows[i].add(newBox);
                columns[j].add(newBox);
                if (i == j) diagonals[0].add(newBox);
                if (Math.abs(i - j) > 1 || (i == 1 && j == 1)) {
                    diagonals[1].add(newBox);
                }
            }
        }
    }
   
    public void markBox(int[] position, char value) {
        int row = position[0];
        int column = position[1];
        Box box = rows[row].getAt(column);
        try {
            box.setValue(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int getUtilidad() {
        return 0;
    }
    
    @Override
    public String toString() {
        String rowsString = "";
        for (Line line : rows) {
            rowsString += line.toString() + "\n";
        }
        return rowsString;
    }
    
    @Override
    public void onNotify() {
        System.out.println("There is a winner");
    }
}
