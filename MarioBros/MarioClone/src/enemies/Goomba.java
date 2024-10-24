package enemies;
import factories.Sprite;
import game.CharacterVisitor;
import platforms.Block;
import platforms.Brick;
import platforms.Pipe;
import platforms.Question;
import platforms.VoidBlock;
import views.GraphicObserver;

public class Goomba extends Enemy{

	static final private int pointsOnDeath=60;
	static final private int pointsOnKill=-30;
	private String direction;
	
	public Goomba(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY,pointsOnDeath,pointsOnKill);
		direction="Left";
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
