package powerUps;
import factories.Sprite;
import game.Entity;
import game.VisitedElement;
import views.Observer;

public abstract class PowerUp extends Entity implements VisitedElement{
	
	protected int points;
	
    public PowerUp(Sprite sprite, int positionInX, int positionInY, int points) {
        super(sprite, positionInX, positionInY);
        this.points = points;
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