package powerUps;

import factories.Sprite;
import game.Entity;

public abstract class PowerUp extends Entity{

	private int points;
	
    protected PowerUp(Sprite sprite, int x, int y, int points) {
        super(sprite, x, y);
        this.points=points;
    }

    public void effect(Character character) {

    }
    
    public int getPoints() {
    	return points;
    }
   // public void acceptVisit(Visitor v) {}

    
}