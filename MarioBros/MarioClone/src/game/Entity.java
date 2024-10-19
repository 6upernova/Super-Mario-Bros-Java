package game;
import factories.Sprite;
import views.GraphicObserver;
import views.Observer;
import java.awt.Rectangle;

public abstract class Entity implements LogicalEntity {
    protected float positionInX;
    protected float positionInY;
    protected Sprite sprite;
    protected GraphicObserver observer;
    protected Rectangle hitbox;

    public Entity(Sprite sprite, float positionInX, float positionInY){
        this.sprite = sprite;
        this.positionInX = positionInX;
        this.positionInY = positionInY;
        this.hitbox = new Rectangle((int)positionInX,(int) positionInY, 1, 2);
    }
    protected void updateHitboxCoords(){
        hitbox.setLocation((int) positionInX, (int)positionInY);
    }
    public Rectangle getHitbox(){
        return hitbox;
    }
    public boolean colision(Entity entity){
        return hitbox.intersects(entity.getHitbox());
    }

    public Sprite getSprite(){
        return sprite;
    }

    public Sprite setSprite(Sprite sprite){
        return this.sprite = sprite;
    }

    public void registerObserver(GraphicObserver observer){
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
    
    public GraphicObserver getGraphicObserver(){
        return observer;
    }
}
