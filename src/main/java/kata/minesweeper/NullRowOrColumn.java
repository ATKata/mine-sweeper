package kata.minesweeper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alec on 27/06/15.
 */
public class NullRowOrColumn extends RowOrColumn {

    public NullRowOrColumn() {
    }

    public NullRowOrColumn(RowOrColumn previous) {
        super(previous);
    }

    public String print() {
        return "";
    }

    @Override
    public RowOrColumn getPrevious() {
        return new NullRowOrColumn();
    }

    @Override
    public RowOrColumn getNext() {
        return new NullRowOrColumn();
    }


}
