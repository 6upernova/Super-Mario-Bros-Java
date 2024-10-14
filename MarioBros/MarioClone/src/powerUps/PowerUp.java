package powerUps;

import factories.Sprite;
import game.Entity;
import views.Observer;

public abstract class PowerUp extends Entity{

	private int points;
	
    public PowerUp(Sprite sprite, int x, int y, int points) {
        super(sprite, x, y);
        this.points=points;
    }

    public void effect(Character character) {

    }
    
    public Observer getObserver() {
    	return observer;
    }
    
    public int getPoints() {
    	return points;
    }
   // public void acceptVisit(Visitor v) {}

    
}