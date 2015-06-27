package kata.minesweeper;

import java.util.LinkedList;

/**
 * Created by alec on 27/06/15.
 */
public class Field {
    private final int numberOfRows;
    private final int numberOfColumns;
    private LinkedList<RowOrColumn> rows;
    private LinkedList<RowOrColumn> columns;

    public Field(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        rows = new LinkedList<>();
        rows.add(new NullRowOrColumn());

        columns = new LinkedList<>();
        columns.add(new NullRowOrColumn());

        for (int i = 0; i < numberOfColumns; i++) {
            columns.add(new RowOrColumn(columns.getLast()));
        }
        columns.add(new NullRowOrColumn(columns.getLast()));
    }

    public void addRow(String input) {
        if (input.length() != numberOfColumns) {
            throw new IllegalArgumentException("Input string length does not match number of columns.");
        }
        RowOrColumn row = new RowOrColumn(rows.getLast());
        // we have to skip the first null column - nasty
        RowOrColumn column = columns.get(1);
        for (Character character:input.toCharArray()) {
            Cell cell = new Cell(Character.toString(character), row, column);
            row.add(cell);
            column.add(cell);
            column = column.getNext();
        }
        rows.add(row);

        if(rows.size()==numberOfRows+1){
            rows.add(new NullRowOrColumn(rows.getLast()));
        }
    }

    public String print() {

        StringBuilder result = new StringBuilder();
        for (RowOrColumn row : rows) {
            result.append(row.print());
        }
        return result.toString();
    }




}
