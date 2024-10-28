package enemies;
import factories.Sprite;
import game.CharacterVisitor;
import platforms.Platform;
import views.GraphicObserver;

public class PiranhaPlant extends Enemy{

	static final private int pointsOnDeath=30;
	static final private int pointsOnKill=-30;
	
	public PiranhaPlant(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
		direction="None";
		isInAir=false;
	}
	

	public int getPointsOnDeath() {
		return pointsOnDeath;
	}
	
	public int getPointsOnKill() {
		return pointsOnKill;
	}
	
	public void acceptVisit(CharacterVisitor visitor) {
    	visitor.visit(this);
    }
	
	public void setObserver(GraphicObserver observer) {
		this.observer = observer;
	}
}
