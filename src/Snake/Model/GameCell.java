package Snake.Model;

import Snake.Const.GameConstants;
import java.awt.*;
import java.awt.image.ImageObserver;


public class GameCell implements GameGraphicObject {
    private int x;
    private int y;

    public GameCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g, ImageObserver observer) {
        g.setColor(Color.DARK_GRAY);
        g.drawRect(x, y, GameConstants.CELL_WIDTH, GameConstants.CELL_HEIGHT);
    }
}
