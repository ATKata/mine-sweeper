package kata.minesweeper;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by alec on 27/06/15.
 */
public class Cell {
    private static final String ASTERISK = "*";
    private final String value;
    private final CellList row;
    private final CellList column;


    public Cell(String value, CellList row, CellList column) {
        this.value = value;
        this.row = row;
        this.column = column;
    }

    public boolean isMine() {
        return ASTERISK.equals(value);
    }

    public String print() {
        if (isMine()) {
            return ASTERISK;
        }
        return Integer.toString(countNumberOfNeighbouringMines());
    }

    private int countNumberOfNeighbouringMines() {

        Set<Cell> allCellsInNeighbouringRows = new HashSet<>();
        allCellsInNeighbouringRows.addAll(row.getCells());
        allCellsInNeighbouringRows.addAll(row.getPrevious().getCells());
        allCellsInNeighbouringRows.addAll(row.getNext().getCells());


        Set<Cell> allCellsInNeighbouringColumns = new HashSet<>();
        allCellsInNeighbouringColumns.addAll(column.getCells());
        allCellsInNeighbouringColumns.addAll(column.getPrevious().getCells());
        allCellsInNeighbouringColumns.addAll(column.getNext().getCells());

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
