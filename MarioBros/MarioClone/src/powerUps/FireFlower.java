package powerUps;
import factories.Sprite;
import game.Visitor;
import views.GraphicObserver;

public class FireFlower extends PowerUp{
	static final private int points = 5;

	public FireFlower(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, points);
	}
	
	public int getPoints() {
		return points;
	}
	
	public void acceptVisit(Visitor visitor) {
    	visitor.visit(this);
    }
	public void setObserver(GraphicObserver observer) {
		this.observer = observer;
	}
}
