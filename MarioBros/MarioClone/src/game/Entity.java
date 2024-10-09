package game;

import views.Observer;

public abstract class Entity {

    protected int x;
    protected int y;
    
    protected Sprite sprite;
    protected Observer observer;

    protected Entity(Sprite sprite, int x, int y){
        this.sprite = sprite;
        this.x = x;
        this.y = y;
    }

    public Sprite getSprite(){
        return sprite;
    }

    public Sprite setSprite(Sprite sprite){
        this.sprite = sprite;
    }

    public void registerObserver(Observer observer){
        this.observer = observer;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
