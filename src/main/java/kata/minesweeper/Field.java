package kata.minesweeper;

import java.util.LinkedList;

/**
 * Created by alec on 27/06/15.
 */
public class Field {
    private LinkedList<CellList> rows;
    private LinkedList<CellList> columns;

    public Field(int numberOfColumns) {
        rows = new LinkedList<>();

        columns = new LinkedList<>();
        for (int i = 0; i < numberOfColumns; i++) {
            columns.add(new RowOrColumn(getLastColumn()));
        }
    }

    public void addRow(String input) {
        CellList row = new RowOrColumn(getLastRow());
        CellList column = columns.getFirst();
        for (Character character:input.toCharArray()) {
            Cell cell = new Cell(Character.toString(character), row, column);
            row.add(cell);
            column.add(cell);
            column = column.getNext();
        }
        rows.add(row);
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        for (CellList row : rows) {
            result.append(row.toString());
        }
        return result.toString();
    }

    private CellList getLastColumn() {
        if( columns.isEmpty() ){
            return new NullRowOrColumn();
        }
        return columns.getLast();
    }

    private CellList getLastRow() {
        if( rows.isEmpty() ){
            return new NullRowOrColumn();
        }
        return rows.getLast();
    }
}
