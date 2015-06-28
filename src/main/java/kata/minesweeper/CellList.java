package kata.minesweeper;

import java.util.Collection;

/**
 * Created by alec on 27/06/15.
 */
public interface CellList {

    void add(Cell cell);

    String toString();

    CellList getNext();

    void setNext(CellList next);

    Collection<? extends Cell> getCells();

    CellList getPrevious();

    boolean hasNext();
}
