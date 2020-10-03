package mindbound.graphics;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;

import mindbound.MindBound;

public class GameWindow extends Canvas {

    private static final long serialVersionUID = 1018850306638987290L;

    public GameWindow(MindBound game, Image iconImage, int width, int height, String title) {
        JFrame jframe = new JFrame(title);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setPreferredSize(new Dimension(width, height));
        jframe.setMaximumSize(new Dimension(width, height));
        jframe.setMinimumSize(new Dimension(width, height));

        jframe.setIconImage(iconImage);
        jframe.pack();
        jframe.setLocationRelativeTo(null);

        jframe.add(game);
        game.start();

        jframe.setVisible(true);
    }
}
