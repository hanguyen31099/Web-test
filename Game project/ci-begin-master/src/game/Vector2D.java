package game;

public class Vector2D {
    public double x,y;
    public Vector2D(){
        this(0,0);
    }
    public Vector2D(double x,double y){
        this.x = x; this.y = y;
    }
    public void set(double x,double y){
        this.x = x;
        this.y = y;
    }
}
