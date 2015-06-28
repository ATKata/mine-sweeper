package kata.minesweeper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alec on 27/06/15.
 */
public class RowOrColumn implements CellList {
    private List<Cell> cells;
    private final CellList previous;
    private CellList next;

    public RowOrColumn(CellList previous) {
        cells = new ArrayList<>();
        this.previous = previous;
        previous.setNext(this);
        this.next = new NullRowOrColumn();
    }

    public RowOrColumn() {
        this(new NullRowOrColumn());
    }

    @Override
    public void add(Cell cell) {
        cells.add(cell);
    }

    @Override
    public List<Cell> getCells() {
        return cells;
    }

    @Override
    public CellList getPrevious() {
        return previous;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public CellList getNext() {
        return next;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Cell cell : cells) {
            result.append(cell.print());
        }
        result.append("%n");
        return result.toString();
    }

    @Override
    public void setNext(CellList next) {
        this.next = next;
    }
}
