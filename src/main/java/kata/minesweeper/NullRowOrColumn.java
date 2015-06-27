package kata.minesweeper;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by alec on 27/06/15.
 */
public class NullRowOrColumn implements CellList {

    public NullRowOrColumn() {
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public void setNext(CellList next) {

    }

    @Override
    public Collection<? extends Cell> getCells() {
        return new ArrayList<>();
    }

    @Override
    public CellList getPrevious() {
        return new NullRowOrColumn();
    }


    @Override
    public void add(Cell cell) {

    }

    public CellList getNext() {
        return new NullRowOrColumn();
    }


}
