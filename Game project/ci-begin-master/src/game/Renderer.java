package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Renderer {
    public BufferedImage image;
    public ArrayList<BufferedImage> images;
    public int currentImageIndex;
    public int frameCount,loop,countloop;
    public boolean isOnce,isRevivalPlayer = false;
    public Renderer() {

    }

    public Renderer(String url){
        File source = new File(url);
        if(source.exists() && source.isFile()){
            image = SpriteUtils.loadImage(url);

        }
        if(source.exists() && source.isDirectory()){
            images = SpriteUtils.loadImages(url);
            frameCount = 0;
            currentImageIndex = 0;
            countloop=0;
        }
    }
    public Renderer(String url,boolean isOnce){
        this(url);
        this.isOnce = isOnce;

    }
    public Renderer(String url,int loop,boolean isRevivalPlayer){
        this(url);
        this.loop = loop;
        this.isRevivalPlayer = isRevivalPlayer;
    }
    public void render(Graphics g, GameObject master){
        if(image != null){
            drawImage(g,image,master);
        }
        if(images!=null){
            BufferedImage currrentImage = images.get(currentImageIndex);
            drawImage(g,currrentImage,master);
            frameCount++;
            if(frameCount>4){
                currentImageIndex++;
                if(currentImageIndex >=images.size()){
                    if(isOnce){
                        this.deactive(master);
                    }
                    currentImageIndex = 0;
                }
                frameCount = 0;
            }
        }
    }

    public void deactive(GameObject master) {
        master.deactive();
    }

    private void drawImage(Graphics g, BufferedImage image,GameObject master) {
        g.drawImage(image,
                (int)(master.position.x - master.anchor.x * image.getWidth()),
                (int)(master.position.y - master.anchor.y * image.getHeight()),
                null);
//        if(master.hitBox!=null){
//            g.setColor(Color.GREEN);
//            g.drawRect(
//                    (int) master.hitBox.left(),
//                    (int) master.hitBox.top(),
//                    master.hitBox.width,master.hitBox.height);
//        }

    }
}
