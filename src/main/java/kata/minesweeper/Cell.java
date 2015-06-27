package kata.minesweeper;

/**
 * Created by alec on 27/06/15.
 */
public class Cell {
    private final String value;
    private final int row;
    private final int column;


    public Cell(String value, int row, int column) {
        this.value = value;
        this.row = row;
        this.column = column;
    }

    public boolean isMine() {
        return "*".equals(value);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
