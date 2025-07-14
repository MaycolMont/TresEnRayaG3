/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espol.tresenrayag3;

/**
 * Clase que representa el tablero del juego Tres en Raya.
 * Contiene filas, columnas y diagonales, y permite marcar casillas.
 * @author maycmont
 */

 // No tested
public class Board implements Suscriber, Cloneable {
    private final Line[] rows = {new Line(), new Line(), new Line()};
    private final Line[] columns = {new Line(), new Line(), new Line()};
    private final Line[] diagonals = {new Line(), new Line()};
    private Line[] lines = new Line[8];

    /**
     * Constructor que inicializa el tablero creando las líneas
     * y suscribiendo las líneas a las notificaciones de cambios.
     */
    public Board() {
        diagonals[0].addSuscriber(this);
        diagonals[1].addSuscriber(this);
        for (int i = 0; i<3; i++) {
            rows[i].addSuscriber(this); // Suscribe la fila al tablero
            columns[i].addSuscriber(this); // Suscribe la columna al tablero
            for (int j = 0; j<3; j++) {
                Box newBox = new Box();
                rows[i].add(newBox); 
                columns[j].add(newBox);
                if (i == j) diagonals[0].add(newBox); // Diagonal principal
                if (Math.abs(i - j) > 1 || (i == 1 && j == 1)) {
                    diagonals[1].add(newBox); // Diagonal secundaria
                }
            }
        }
    }

    /**
     * Marca una casilla en el tablero con un valor específico.
     * @param position la posición de la casilla a marcar
     * @param value el valor a asignar a la casilla
     * @throws Exception si la casilla ya está ocupada
     */
    public void markBox(int[] position, char value) throws Exception { // validate input
        int row = position[0];
        int column = position[1];
        Box box = rows[row].getAt(column);
        try {
            box.setValue(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public char getValueAt(int row, int column) throws IndexOutOfBoundsException {
        if (0 > row ||row > 2 || 0 > column || column > 2) {
            throw new IndexOutOfBoundsException("Valores de posisición de casilla fuera de rango");
        }
        Box box = rows[row].getAt(column);
        return box.getValue();
    }
    
    public int getUtility(char valuePlayer1, char valuePlayer2) {
        int avalaibleLinesPlayer1 = 0;
        int avalaibleLinesPlayer2 = 0;
        for (Line line: lines) {
            if (line.isAvailableFor(valuePlayer1)){
                avalaibleLinesPlayer1++;
            }
            if (line.isAvailableFor(valuePlayer2)) {
                avalaibleLinesPlayer2++;
            }
        }
        return avalaibleLinesPlayer1 - avalaibleLinesPlayer2;
    }
    
    /**
     *
     * @return
     */
    public Board clone(){
        Board newBoard = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Box box = rows[i].getAt(j);
                if (box.isEmpty()) continue; // No se copia si la casilla está vacía
                try {
                    newBoard.markBox(new int[]{i, j}, box.getValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return newBoard;
    }

    public boolean hasWinner() {
        for (Line line : rows)
            if (line.isEqual())
                return true;
        for (Line line : columns)
            if (line.isEqual())
                return true;
        for (Line line : diagonals)
            if (line.isEqual())
                return true;
        return false;
    }

    public boolean isFull() {
        for (Line row : rows) {
            for (int i = 0; i < 3; i++) {
                if (row.getAt(i).isEmpty())
                    return false;
            }
        }
        return true;
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
