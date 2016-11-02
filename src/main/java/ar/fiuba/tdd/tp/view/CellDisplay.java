package ar.fiuba.tdd.tp.view;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * Created by martin on 9/28/16.
 */
public interface CellDisplay extends ImageObserver, MenuContainer, Serializable {

    void setPosition(int row, int column);
}
