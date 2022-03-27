package Snake.Model;

import Snake.Const.GameConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Random;

public class Apple extends GameCell {

    private Image objectImage;

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    private boolean inGame = true;

    static int getRPosX() {
        return new Random().nextInt(20)*GameConstants.CELL_WIDTH;
    }

    static int getRPosY() {
        return new Random().nextInt(20)*GameConstants.CELL_HEIGHT;
    }

    public Apple() {
        super(getRPosX(), getRPosY()) ;
        ImageIcon iia = new ImageIcon(GameConstants.APPLE_IMAGE_SRC);
        objectImage = iia.getImage();
    }

    public void setRandomAppleLocation() {
        setX(getRPosX());
        setY(getRPosY());
    }


    @Override
    public void paintComponent(Graphics g, ImageObserver observer) {
        if (inGame) {
            g.drawImage(objectImage, getX(), getY(), observer);
        }
    }
}
