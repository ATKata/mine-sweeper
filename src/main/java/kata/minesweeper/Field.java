package kata.minesweeper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alec on 27/06/15.
 */
public class Field {
    private List<List<Cell>> rows;
    private int noOfColumns = 0;

    public Field() {
        rows = new ArrayList<>();
    }

    public void addRow(String input) {
        List<Cell> row = new ArrayList<>();
        for (int column = 0; column < input.length(); column++) {
            if (noOfColumns < input.length()) {
                noOfColumns = input.length();
            }
            row.add(new Cell(Character.toString(input.charAt(column)), rows.size(), column));
        }
        rows.add(row);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (List<Cell> row : rows) {
            for (Cell cell : row) {
                result.append(printCell(cell));
            }
            result.append("%n");
        }
        return result.toString();
    }

    private String printCell(Cell cell) {
        if (cell.isMine()) {
            return "*";
        }
        return Integer.toString(countNumberOfNeighbouringMines(cell));
    }

    private int countNumberOfNeighbouringMines(Cell cell) {
        int result = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) {
                    result += isMine(cell.getRow() + dx, cell.getColumn() + dy);
                }
            }
        }
        return result;
    }

    private int isMine(int row, int column) {
        if (row >= 0 && row < rows.size() && column >= 0 && column < noOfColumns){
            return rows.get(row).get(column).isMine() ? 1 : 0;
        }
        return 0;
    }
}
