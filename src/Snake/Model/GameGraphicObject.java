package Snake.Model;

import java.awt.*;
import java.awt.image.ImageObserver;

public interface GameGraphicObject {
    void paintComponent(Graphics g, ImageObserver observer);
}
