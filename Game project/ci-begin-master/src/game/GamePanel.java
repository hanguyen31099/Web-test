package game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    AirEnnemy ennemy;

    public GamePanel() {
        ennemy = new AirEnnemy();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if (object.active) {
                object.render(g);
            }
        }
        for (int x = 0; x <= Setting.GAME_WIDTH; x += 48) {
            for (int y = 0; y <= Setting.GAME_HEIGHT; y += 48)
                g.drawRect(x, y, 48, 48);


        }
    }
    public void gameLoop () {
        long lastTime = 0;
        while (true) {
            long currenTime = System.currentTimeMillis();
            if (currenTime - lastTime > 1000 / 60) {
                this.run();
                this.repaint();
                lastTime = currenTime;
            }
        }
    }

    private void run () {
        if (Setting.mouseClicked) {
            Setting.mouseClicked = false;
            int x = (int) Setting.mousePosition.x / 48;
            int y = (int) Setting.mousePosition.y / 48;
            Bullet bullet = GameObject.recycle(Bullet.class);
            bullet.position.set(x*48 + 24,0);
        }
        for (int i = 0; i <GameObject.objects.size() ; i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active)
                object.run();
        }
    }

}