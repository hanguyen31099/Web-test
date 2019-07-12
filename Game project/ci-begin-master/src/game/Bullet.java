package game;

import tklibs.SpriteUtils;

public class Bullet extends GameObject {
    public Bullet(){
        renderer = new Renderer("assets/images/bullet.png");
        hitBox = new BoxCollider(this,15,15);
        position.set(-50,-50); // out of battle
        dame = 1;
    }

    @Override
    public void run() {
        this.position.y++;
        this.CheckEnnemy();
    }

    private void CheckEnnemy() {
        AirEnnemy ennemy = GameObject.findInterSects(AirEnnemy.class,this.hitBox);
        if (ennemy !=null){
            this.deactive();
            ennemy.Takedame(dame);
        }
    }
}
