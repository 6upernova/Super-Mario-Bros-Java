package game;
import factories.BoundingBox;
import factories.Sprite;
import views.GraphicObserver;

public abstract class Entity implements LogicalEntity {
    protected float positionInX;
    protected float positionInY;
    protected Sprite sprite;
    protected GraphicObserver observer;
    protected BoundingBox hitbox;

    public Entity(Sprite sprite, float positionInX, float positionInY){
        this.sprite = sprite;
        this.positionInX = positionInX;
        this.positionInY = positionInY;
        this.hitbox = new BoundingBox((int)positionInX,(int) positionInY, 1, 2);
    }
    protected void updateHitboxCoords(){
        hitbox.setLocation((int) positionInX, (int)positionInY);
    }
    public BoundingBox getHitbox(){
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
