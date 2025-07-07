package espol.tresenrayag3;
import java.util.Iterator;

public class BoardStatesGenerator implements Iterable<Board> {
    Board board;
    char value;

    public BoardStatesGenerator(Board board, char value) {
        this.board = board;
        this.value = value;
    }

    @Override
    public Iterator<Board> iterator() {
        return new Iterator<Board>(){
            int row = 0;
            int column = 0;

            public boolean hasNext() {
                if (row < 3) {
                    char value = board.getValueAt(row, column);
                    column++;
                    if (column == 3) {
                        column = 0;
                        row++;
                    }
                    if (value == 0) return true; // casilla vacía
                    return hasNext();
                } else {
                    return false;
                }
            }

            public Board next() {
                char value = board.getValueAt(row, column);
                Board newBoardState = board.clone();
                try {
                    newBoardState.markBox(new int[]{row, column}, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return newBoardState;
            }
        };
    }
    
}
