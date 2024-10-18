package game;
import factories.Sprite;
import views.Observer;

public abstract class Entity implements LogicalEntity {
    protected float positionInX;
    protected float positionInY;
    protected Sprite sprite;
    protected Observer observer;
    protected HitBox hitBox;

    public Entity(Sprite sprite, float positionInX, float positionInY){
        this.sprite = sprite;
        this.positionInX = positionInX;
        this.positionInY = positionInY;
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

    public void setX(float positionInX){
        this.positionInX = positionInX;
    }

    public void setY(float positionInY){
        this.positionInY = positionInY;
    }

    public float getX(){
        return positionInX;
    }

    public float getY(){
        return positionInY;
    }
    
    public void acceptVisit(Visitor visitor) {
    	visitor.visit(this);
    }
}
