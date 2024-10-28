package powerUps;
import factories.Sprite;
import game.Entity;
import game.VisitedElement;
import views.EntityObserver;
import views.Observer;

public abstract class PowerUp extends Entity implements VisitedElement{
	protected int points;
	protected boolean isActive;

    public PowerUp(Sprite sprite, int positionInX, int positionInY, int points) {
        super(sprite, positionInX, positionInY);
        this.points = points;
        this.isActive = false;
    }

    public void effect(Character character) {

    }
    
    public Observer getObserver() {
    	return observer;
    }
    
    public int getPoints() {
    	return points;
    }

    public void activatePowerUp(){
        if(!isActive){
            isActive = true;
            EntityObserver entityObserver = (EntityObserver) observer;
            entityObserver.activateObserver();
        }
    }
    public boolean isActive(){
        return isActive;
    }
   // public void acceptVisit(Visitor v) {}
}