package Snake.Model;

import Snake.Const.GameConstants;

import java.awt.*;
import java.awt.image.ImageObserver;

public class GameOver implements GameGraphicObject{
    @Override
    public void paintComponent(Graphics g, ImageObserver observer) {
        String str = "Game Over";
        g.setColor(Color.white);
        g.drawString(str,125, GameConstants.SIZE/2);
    }
}
