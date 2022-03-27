package Snake.Controller;

import Snake.Const.GameConstants;
import Snake.Model.Apple;
import Snake.Model.GameCell;
import Snake.Model.GameOver;
import Snake.Model.Snake;
import Snake.View.GameField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePlay implements ActionListener {

    private final GameField gameFieldView;
    private Snake snake;
    private Apple apple;
    private boolean inGame = true;
    private Timer timer;

    public GamePlay(GameField gFieldView){
        gameFieldView = gFieldView;
        initGamePlay();
    }

    private void initGamePlay(){
        gameFieldView.addKeyListener(new ViewKeyListener(this));
        timer = new Timer(250, this);
        timer.start();

        for (int j = 0; j< (GameConstants.SIZE/ GameConstants.CELL_HEIGHT) ; j++) {
            for (int i = 0; i< (GameConstants.SIZE/ GameConstants.CELL_WIDTH) ; i++) {
                gameFieldView.addGameGraphicObject(new GameCell(GameConstants.CELL_WIDTH * i, j*GameConstants.CELL_HEIGHT));
            }
        }

        apple = new Apple();
        gameFieldView.addGameGraphicObject(apple);

        snake = new Snake(apple, timer);
        gameFieldView.addGameGraphicObject(snake);



    }
    private void checkGameStatus() {
        if (!inGame) {
            gameFieldView.clearAllGameObject();
            gameFieldView.addGameGraphicObject(new GameOver());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame)  {
            snake.actionPerformed(e);
            inGame = snake.isInGame();
            checkGameStatus();
        };

        gameFieldView.repaint();
    }

    public void keyPressed(KeyEvent e) {
        snake.keyPressed(e);
    }

}

class ViewKeyListener extends KeyAdapter {

    private GamePlay gamePlay;

    public ViewKeyListener(GamePlay gPlay) {
        gamePlay = gPlay;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        gamePlay.keyPressed(e);
    }
}