/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package espol.tresenrayag3;

import java.util.Scanner;

/**
 *
 * @author maycmont
 */
public class TresEnRayaG3 {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';  //Juego empieza con jugador 'X'
        boolean gameOver = false;  //Controla el estado final del juego

        while (!gameOver) {
            System.out.println(board);
            boolean moveSuccessful = false;
            
            //Solicita un movimiento al jugador mientras el movimiento elegido sea invalido
            while (!moveSuccessful) {
                try {
                    System.out.print("Turno de " + currentPlayer + ". Ingrese fila y columna (0-2 separados por espacio): ");
                    int row = scanner.nextInt();
                    int col = scanner.nextInt();
                    board.markBox(new int[] { row, col }, currentPlayer);
                    moveSuccessful = true;
                } catch (Exception e) {
                    System.out.println("Casilla invalida. Intente otra vez.");
                    scanner.nextLine();
                }
            }

            System.out.println(board);

            if (board.hasWinner()) {
                System.out.println("¡Jugador " + currentPlayer + " ha ganado!");
                gameOver = true;
            } else if (board.isFull()) {
                System.out.println("¡Empate!");
                gameOver = true;
            // Cambia el turno del jugador solo si la tabla no tiene un ganador y no está llena(empate)
            } else {
                if (currentPlayer == 'X') {          
                    currentPlayer = 'O';
                } else {
                    currentPlayer = 'X';
                }
            }
        }
        scanner.close();
    }
}
