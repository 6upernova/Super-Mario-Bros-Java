package enemies;
import factories.Sprite;
import game.CharacterVisitor;
import platforms.Platform;
import views.GraphicObserver;

public class Lakitu extends Enemy{

	static final private int pointsOnDeath=60;
	static final private int pointsOnKill=0;
	static final private boolean isFlying=true;
	
	public Lakitu(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
		direction="Left";
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
