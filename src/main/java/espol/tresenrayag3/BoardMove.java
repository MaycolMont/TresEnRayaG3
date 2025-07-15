package espol.tresenrayag3;

public class BoardMove {
    private int row;
    private int column;
    private char value;

    public BoardMove(int row, int column, char value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "BoardMove{" +
                "row=" + row +
                ", column=" + column +
                ", value=" + value +
                '}';
    }
}
