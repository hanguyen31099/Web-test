package game;

import tklibs.SpriteUtils;

public class AirEnnemy extends GameObject{
    public AirEnnemy(){
        renderer = new Renderer("assets/images/airEnnemy.png");
        hitBox = new BoxCollider(this,120,30);
        position.set(300,500);
        hp = 3;
    }
    public void run(){
        position.y--;
    }
}
