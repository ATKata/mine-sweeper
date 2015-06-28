package kata.minesweeper;

/**
 * Created by alec on 27/06/15.
 */
public class Field {

    private CellList lastRow;
    private final CellList firstColumn;
    private CellList firstRow;

    public Field(int numberOfColumns) {
        lastRow = new NullRowOrColumn();
        firstColumn = new RowOrColumn();
        CellList currentColumn = firstColumn;
        for (int i = 1; i < numberOfColumns; i++) {
            currentColumn = new RowOrColumn(currentColumn);
        }
    }

    public void addRow(String input) {
        CellList row = new RowOrColumn(lastRow);
        if (firstRow == null) {
            firstRow = row;
        }

        CellList column = firstColumn;
        for (Character character : input.toCharArray()) {
            Cell cell = new Cell(Character.toString(character), row, column);
            row.add(cell);
            column.add(cell);
            column = column.getNext();
        }
        lastRow = row;
    }

    public String print() {
        StringBuilder result = new StringBuilder();

        for (CellList currentRow = firstRow; currentRow.hasNext(); currentRow = currentRow.getNext()){
            result.append(currentRow.toString());
        }
        return result.toString();
    }
}
