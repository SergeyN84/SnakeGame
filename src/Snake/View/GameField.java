package Snake.View;

import Snake.Model.GameGraphicObject;

import javax.swing.*;
import java.awt.*;

import java.util.LinkedList;


public class GameField extends JPanel {

    private LinkedList<GameGraphicObject> gameGraphicObjects;

    public GameField() {
        setBackground(Color.black);
        gameGraphicObjects = new LinkedList<>();
        setFocusable(true);
    }

    public void clearAllGameObject() {
        gameGraphicObjects.clear();
    }

    public void delGameGraphicObject(GameGraphicObject gameGraphicObject) {
        if (gameGraphicObjects.contains(gameGraphicObject) ) {
            gameGraphicObjects.remove(gameGraphicObject);
        }
    }

    public void addGameGraphicObject(GameGraphicObject gameGraphicObject) {
        if (! gameGraphicObjects.contains(gameGraphicObject) ) {
            gameGraphicObjects.add(gameGraphicObject);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gameGraphicObjects.forEach(gameGraphicObject -> gameGraphicObject.paintComponent(g, this));
    }

}
