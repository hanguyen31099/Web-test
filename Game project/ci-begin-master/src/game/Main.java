package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        GamePanel panel = new GamePanel();
        panel.setBackground(Color.BLACK);
        panel.setPreferredSize(new Dimension(675,675));
        window.add(panel);
        window.pack();
        window.setTitle("Game");
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MouseAdapter mouse = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Setting.mouseClicked = true;
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                double x = e.getX() - window.getInsets().left;
                double y = e.getY() - window.getInsets().top;
                Setting.mousePosition.set(x, y);
            }
        };
        window.addMouseListener(mouse);
        window.addMouseMotionListener(mouse);
        window.setVisible(true);
        panel.gameLoop();
    }
}
