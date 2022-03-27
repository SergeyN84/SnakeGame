package Snake.Model;

import Snake.Const.GameConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Snake extends SnakeTail implements GameKLGameObject, ActionListener {

    ArrayList<SnakeTail> snakeList;
    private Timer timer;
    private Apple apple;
    private boolean left = true;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;
    private boolean checkUserKey = true;

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    private Image objectImage;

    public Snake(Apple apple, Timer mainTimer) {
        super(GameConstants.CELL_WIDTH*6, GameConstants.CELL_HEIGHT);
        init(apple, mainTimer);
    }

    private void init(Apple apple, Timer mainTimer) {
        snakeList = new ArrayList<>();
        this.apple = apple;
        this.timer = mainTimer;

        ImageIcon iia = new ImageIcon(GameConstants.SNAKE_HEAD_IMAGE_SRC);
        objectImage = iia.getImage();
        //В списке содержится голова + хвост
        addTail(this);

        for (int i = 1; i < 3; i ++) {
            int x = getX() + (GameConstants.CELL_WIDTH * i);
            addTail(new SnakeTail(x, getY()));
        }
    }

    private void addTail(SnakeTail snakeTail) {
        snakeList.add(snakeTail);
    }

    public void addToTheEndTail() {
        int i = snakeList.size()-1;
        snakeList.add(new SnakeTail(snakeList.get(i).getX(), snakeList.get(i).getY()));
    }

    @Override
    public void paintComponent(Graphics g, ImageObserver observer) {
        if (inGame) {
            g.drawImage(objectImage, getX(), getY(), observer);
            snakeList.forEach(el ->{ if (!el.equals(this)) el.paintComponent(g, observer);});
        }
    }

    private void checkCollision() {
        //Анализ координат яблока здесь реализовать или в игровом классе?
        if (!inGame) {
            return;
        }

        snakeList.forEach(el ->
            {
                if (!el.equals(this) && getX() == el.getX() && getY() == el.getY()) {
                    inGame = false;
                }
            }
        );

        if(getX()>GameConstants.SIZE){
            inGame = false;
        }
        if(getX()<0){
            inGame = false;
        }
        if(getY()>GameConstants.SIZE){
            inGame = false;
        }
        if(getY()<0){
            inGame = false;
        }

        if(getX() == apple.getX() && getY() == apple.getY()){
            addToTheEndTail();
            apple.setRandomAppleLocation();
            timer.setDelay(timer.getDelay() - 10);
        }

        apple.setInGame(inGame);
    }

    private void move() {

        for (int i = snakeList.size()-1; i > 0; i--) {
            snakeList.get(i).setX(snakeList.get(i-1));
            snakeList.get(i).setY(snakeList.get(i-1));
        }

        if(left){
            setX(getX()-GameConstants.CELL_WIDTH);
        } if(right){
            setX(getX()+GameConstants.CELL_WIDTH);
        } if(up){
            setY(getY()-GameConstants.CELL_HEIGHT);
        } if(down){
            setY(getY()+GameConstants.CELL_HEIGHT);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT && !right && checkUserKey){
            left = true;
            up = false;
            down = false;
        }
        if(key == KeyEvent.VK_RIGHT && !left && checkUserKey){
            right = true;
            up = false;
            down = false;
        }

        if(key == KeyEvent.VK_UP && !down && checkUserKey){
            right = false;
            up = true;
            left = false;
        }
        if(key == KeyEvent.VK_DOWN && !up && checkUserKey){
            right = false;
            down = true;
            left = false;
        }

        if(key == KeyEvent.VK_SPACE && checkUserKey){
            addToTheEndTail();
        }

        checkUserKey = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        checkCollision();
        checkUserKey = true;
    }
}
