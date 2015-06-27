package kata.minesweeper;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by alec on 27/06/15.
 */
public class Cell {
    private final String value;
    private RowOrColumn row;
    private RowOrColumn column;


    public Cell(String value, RowOrColumn row, RowOrColumn column) {
        this.value = value;
        this.row = row;
        this.column = column;
    }

    public boolean isMine() {
        return "*".equals(value);
    }

    public RowOrColumn getRow() {
        return row;
    }

    public RowOrColumn getColumn() {
        return column;
    }

    public String print() {
        if (isMine()) {
            return "*";
        }
        return Integer.toString(countNumberOfNeighbouringMines());
    }

    private int countNumberOfNeighbouringMines() {

        Set<Cell> allCellsInNeighbouringRows = new HashSet<>();
        allCellsInNeighbouringRows.addAll(getRow().getCells());
        allCellsInNeighbouringRows.addAll(getRow().getPrevious().getCells());
        allCellsInNeighbouringRows.addAll(getRow().getNext().getCells());


        Set<Cell> allCellsInNeighbouringColumns = new HashSet<>();
        allCellsInNeighbouringColumns.addAll(getColumn().getCells());
        allCellsInNeighbouringColumns.addAll(getColumn().getPrevious().getCells());
        allCellsInNeighbouringColumns.addAll(getColumn().getNext().getCells());

        Set<Cell> neighbours = new HashSet<>(allCellsInNeighbouringRows);
        neighbours.retainAll(allCellsInNeighbouringColumns);

        int neighbourCount = 0;
        for(Cell neighbour:neighbours){
            if(neighbour.isMine()){
                neighbourCount++;
            }
        }
        if(isMine()){
            neighbourCount--;
        }
        return neighbourCount;
    }
}
