package game;
import factories.Sprite;
import views.GraphicObserver;

public interface LogicalEntity{
    public Sprite getSprite();
    public float getX();
    public float getY();
    public GraphicObserver getGraphicObserver();
    public void setObserver(GraphicObserver observer);
    public BoundingBox getBoundingBox();
    public void setBoundingBox(BoundingBox boundingBox);
}
