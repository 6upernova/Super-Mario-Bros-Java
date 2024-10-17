package game;

import factories.Sprite;
import views.Observer;

public abstract class Entity implements LogicalEntity {

    protected float x;
    protected float y;
    protected Sprite sprite;
    protected Observer observer;

    public Entity(Sprite sprite, float x, float y){
        this.sprite = sprite;
        this.x = x;
        this.y = y;
    }

    public Sprite getSprite(){
        return sprite;
    }

    public Sprite setSprite(Sprite sprite){
        return this.sprite = sprite;
    }

    public void registerObserver(Observer observer){
        this.observer = observer;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }
    
    public void acceptVisit(Visitor visitor) {
    	visitor.visit(this);
    }

}
