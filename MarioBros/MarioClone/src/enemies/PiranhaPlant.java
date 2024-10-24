package enemies;
import factories.Sprite;
import game.CharacterVisitor;
import views.GraphicObserver;

public class PiranhaPlant extends Enemy{

	static final private int pointsOnDeath=30;
	static final private int pointsOnKill=-30;
	private String direction;
	
	public PiranhaPlant(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
		direction="None";
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
