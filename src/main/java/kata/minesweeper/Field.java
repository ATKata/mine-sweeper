package kata.minesweeper;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by alec on 27/06/15.
 */
public class Field {
    private final int numberOfColumns;
    private LinkedList<RowOrColumn> rows;
    private LinkedList<RowOrColumn> columns;

    public Field(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
        rows = new LinkedList<>();
        rows.add(new NullRowOrColumn(null));

        columns = new LinkedList<>();
        columns.add(new NullRowOrColumn(null));

        for (int i = 0; i < numberOfColumns; i++) {
            columns.add(new RowOrColumn(columns.getLast()));
        }
    }

    public void addRow(String input) {
        if (input.length() != numberOfColumns) {
            throw new IllegalArgumentException("Input string length does not match number of columns.");
        }
        RowOrColumn row = new RowOrColumn(rows.getLast());
        // we have to skip the first null column - nasty
        RowOrColumn column = columns.getFirst().getNext();
        for (Character character:input.toCharArray()) {
            Cell cell = new Cell(Character.toString(character), row, column);
            row.add(cell);
            column.add(cell);
            column = column.getNext();
        }
        rows.add(row);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (RowOrColumn row : rows) {
            result.append(row.toString());
        }
        return result.toString();
    }




}
