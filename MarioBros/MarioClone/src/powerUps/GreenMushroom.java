package powerUps;
import factories.Sprite;
import game.CharacterVisitor;
import views.GraphicObserver;

public class GreenMushroom extends PowerUp{
	static final private int points = 100;
			
	public GreenMushroom(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, points);
	}
	
	public int getPoints() {
		return points;
	}
	public void acceptVisit(CharacterVisitor visitor) {
    	visitor.visit(this);
    }
	public void setObserver(GraphicObserver observer) {
		this.observer = observer;
	}
	
}
