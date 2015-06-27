package kata.minesweeper;

import com.sun.rowset.internal.Row;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alec on 27/06/15.
 */
public class RowOrColumn {
    List<Cell> cells;
    private RowOrColumn previous;
    private RowOrColumn next;

    public RowOrColumn(RowOrColumn previous) {
        this.previous = previous;
        if (previous != null) {
            previous.setNext(this);
        }
        cells = new ArrayList<>();
    }

    public void add(Cell cell) {
        cells.add(cell);
    }

    public List<Cell> getCells() {
        return cells;
    }

    public RowOrColumn getPrevious() {
        if (previous == null) {
            return new NullRowOrColumn(null);
        }
        return previous;
    }

    public RowOrColumn getNext() {
        if (next == null) {
            return new NullRowOrColumn(null);
        }
        return next;
    }

    public void setNext(RowOrColumn next) {
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Cell cell : cells) {
            result.append(cell.toString());
        }
        result.append("%n");
        return result.toString();
    }
}
