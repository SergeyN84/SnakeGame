import Snake.Controller.GamePlay;
import Snake.View.GameField;

import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow(){
        setTitle("Змейка");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 350);
        setLocation(400, 400);

        GameField gameFieldView = new GameField();
        GamePlay gamePlay = new GamePlay(gameFieldView);
        add(gameFieldView);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
    }
}
