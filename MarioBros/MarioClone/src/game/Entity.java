package game;
import factories.BoundingBox;
import factories.Sprite;
import views.GraphicObserver;

public abstract class Entity implements LogicalEntity {
    protected float positionInX;
    protected float positionInY;
    protected Sprite sprite;
    protected GraphicObserver observer;
    protected BoundingBox boundingBox;

    public Entity(Sprite sprite, float positionInX, float positionInY){
        this.sprite = sprite;
        this.positionInX = positionInX;
        this.positionInY = positionInY;
        this.boundingBox = new BoundingBox((int)positionInX,(int) positionInY, 1, 2);
    }
    protected void updateBoundingBoxCoords(){
        boundingBox.setLocation((int) positionInX, (int)positionInY);
    }
    public BoundingBox getBoundingBox(){
        return boundingBox;
    }
    public boolean colision(Entity entity){
<<<<<<< HEAD
        return boundingBox.intersects(entity.getBoundingBox());
=======
        return hitbox.collision(entity.getHitbox());
>>>>>>> e574773918794a318fbcce46311f6b8518e7637f
    }
    public boolean leftCollision(Entity entity){
        return boundingBox.leftCollision(entity.getBoundingBox());
    }
    public boolean rightCollision(Entity entity){
        return boundingBox.rightCollision(entity.getBoundingBox());
    }
    public boolean upCollision(Entity entity){
        return boundingBox.upCollision(entity.getBoundingBox());
    }
    public boolean downCollision(Entity entity){
        return boundingBox.downCollision(entity.getBoundingBox());
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
