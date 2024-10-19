package enemies;
import factories.Sprite;
import game.Visitor;
import views.GraphicObserver;

public class Goomba extends Enemy{

	static final private int pointsOnDeath=60;
	static final private int pointsOnKill=-30;
	
	public Goomba(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY,pointsOnDeath,pointsOnKill);
	}

	public int getPointsOnDeath() {
		return pointsOnDeath;
	}
	public int getPointsOnKill() {
		return pointsOnKill;
	}
	public void acceptVisit(Visitor visitor) {
    	visitor.visit(this);
    }
	public void setObserver(GraphicObserver observer) {
		this.observer = observer;
	}
}
