package game;

import factories.Sprite;

public interface LogicalEntity extends Element {
    public Sprite getSprite();
    public float getX();
    public float getY();
    
}
