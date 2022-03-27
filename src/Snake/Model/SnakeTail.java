package Snake.Model;

import Snake.Const.GameConstants;

import java.awt.*;
import java.awt.image.ImageObserver;

public class SnakeTail extends GameCell{

    public SnakeTail(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintComponent(Graphics g, ImageObserver observer) {
        g.setColor(Color.ORANGE);
        g.fillRect(getX(), getY(), GameConstants.CELL_WIDTH-1, GameConstants.CELL_HEIGHT-1);
    }

    public void setX(SnakeTail snakeTail) {
        setX(snakeTail.getX());
    }

    public void setY(SnakeTail snakeTail) {
        setY(snakeTail.getY());
    }

}
