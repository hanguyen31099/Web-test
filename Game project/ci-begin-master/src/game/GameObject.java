package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    public static ArrayList<GameObject> objects = new ArrayList<>();
    public static <E extends GameObject>E recycle(Class<E> cls){
        E object = findInactive(cls);
        if(object != null) {
            object.reset();
            return object;
        }
        try {
            object = cls.getConstructor().newInstance();
            return object;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static <E extends GameObject>E findInterSects(Class<E> cls,BoxCollider hitbox){
        for (int i = 0; i <GameObject.objects.size() ; i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active && cls.isAssignableFrom(object.getClass())
                && object.hitBox.interset(hitbox))
            {
                return (E) object;
            }
        }
        return null;
    }
    private static <E extends GameObject> E findInactive(Class<E> cls) {
        for (int i = 0; i <GameObject.objects.size() ; i++) {
            GameObject object = objects.get(i);
            if(cls.isAssignableFrom(objects.getClass())
                    && object.active)
            {
                return (E) object;
            }
        }
        return null;
    }
    public int hp,dame;
    public boolean immue;
    public BoxCollider hitBox;
    public Vector2D anchor;
    public Renderer renderer;
    public Vector2D position;
    public boolean active;
    public GameObject(){
        anchor = new Vector2D(0.5,0.5);
        position = new Vector2D();
        active = true;
        objects.add(this);
    }
    public void run(){
        this.DeactiveIFneeded();
    }
    public void Takedame(int dame){
        hp -= dame;
        if(hp <=0){
            this.deactive();
        }
    }
    private void DeactiveIFneeded() {
        if(this.position.x > Setting.GAME_WIDTH
                || this.position.y > Setting.GAME_WIDTH
                || this.position.x < -100 || this.position.y < -50)
        {
            this.deactive();
        }
    }

    public void render(Graphics g){
        if(renderer!=null){
            renderer.render(g,this);
        }
    }
    public void reset(){
        this.active = true;
    }
    public void deactive(){
        this.active = false;
    }
}
