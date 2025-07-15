package espol.tresenrayag3;

public class BoardState {
    private final BoardMove move;
    private final Board board;
    private final char nextPlayer;

    public BoardState(BoardMove move, Board board, char nextPlayer) {
        this.move = move;
        this.nextPlayer = nextPlayer;
        this.board = board.clone();
    }

    public BoardMove getMove() {
        return move;
    }

    public Board getBoard() {
        return board;
    }

    public char getNextPlayer() {
        return nextPlayer;
    }

    public char getCurrentPlayer() {
        return move.getValue();
    }

    public String toString() {
        return board.toString();
    }
}