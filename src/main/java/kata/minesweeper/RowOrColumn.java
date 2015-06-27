package kata.minesweeper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alec on 27/06/15.
 */
public class RowOrColumn {
    List<Cell> cells;
    private RowOrColumn previous;
    private RowOrColumn next;

    protected RowOrColumn(){
        cells = new ArrayList<>();
    }

    public RowOrColumn(RowOrColumn previous) {
        this();
        this.previous = previous;
        previous.setNext(this);

    }

    public void add(Cell cell) {
        cells.add(cell);
    }

    public List<Cell> getCells() {
        return cells;
    }

    public RowOrColumn getPrevious() {
        return previous;
    }

    public RowOrColumn getNext() {
        return next;
    }

    public void setNext(RowOrColumn next) {
        this.next = next;
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        for (Cell cell : cells) {
            result.append(cell.print());
        }
        result.append("%n");
        return result.toString();
    }
}
