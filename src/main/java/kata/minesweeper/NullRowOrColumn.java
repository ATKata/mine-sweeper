package kata.minesweeper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alec on 27/06/15.
 */
public class NullRowOrColumn extends RowOrColumn {

    public NullRowOrColumn(RowOrColumn previous) {
        super(previous);
    }

    @Override
    public String toString() {
        return "";
    }
}
