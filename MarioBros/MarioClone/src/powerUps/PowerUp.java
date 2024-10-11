package powerUps;

import factories.Sprite;
import game.Entity;

public abstract class PowerUp extends Entity{

    protected PowerUp(Sprite sprite, int x, int y) {
        super(sprite, x, y);
    }

    public void effect(Character character) {

    }

   // public void acceptVisit(Visitor v) {}

    
}