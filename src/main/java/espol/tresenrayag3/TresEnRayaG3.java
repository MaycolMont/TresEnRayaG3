/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package espol.tresenrayag3;

/**
 *
 * @author maycmont
 */
public class TresEnRayaG3 {

    public static void main(String[] args) {
        Board board = new Board();
        int[][] positions = {{1,1}, {0,0}, {2,2}};
        for (int[] position : positions) {
            System.out.println(board);
            board.markBox(position, 'X');
        }
        System.out.println(board);
    }
}
