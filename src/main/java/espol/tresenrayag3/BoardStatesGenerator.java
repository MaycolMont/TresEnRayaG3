package espol.tresenrayag3;
import java.util.Iterator;

// Clase Iterable que genera todos los posibles estados de un tablero
// y el valor correspondiente con el que se debe llenar
public class BoardStatesGenerator implements Iterable<Board> {
    private final Board board;
    private final char value;

    public BoardStatesGenerator(Board board, char value) {
        this.board = board;
        this.value = value;
    }

    @Override
    public Iterator<Board> iterator() {
        return new Iterator<Board>(){
            int row = 0;
            int column = 0;
            
            private void nextPosition() {
                column++;
                if (column > 2) {
                    column = 0;
                    row++;
                }
            }

            @Override
            public boolean hasNext() {
                if (row < 3 && column < 3) {
                    char value = board.getValueAt(row, column);
                    boolean boxIsEmpty = value == 0;
                    if (boxIsEmpty) {
                        return true;
                    } else {
                        nextPosition();
                        return hasNext();
                    }
                }
                return false;
            }

            @Override
            public Board next() {
                Board newBoardState = board.clone();
                try {
                    newBoardState.markBox(new int[]{row, column}, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                nextPosition();
                return newBoardState;
            }
        };
    } 
}
