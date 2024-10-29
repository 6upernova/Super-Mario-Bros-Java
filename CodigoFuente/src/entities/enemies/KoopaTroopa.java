package entities.enemies;
import entities.character.CharacterVisitor;
import factories.Sprite;
import views.GraphicObserver;

public class KoopaTroopa extends Enemy{

	static final private int pointsOnDeath=90;
	static final private int pointsOnKill=-45;
	
	
	public KoopaTroopa(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
		direction="Left";
		flies=false;
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
