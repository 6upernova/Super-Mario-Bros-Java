package enemies;
import factories.Sprite;
import game.CharacterVisitor;
import tools.GraphicTools;
import views.GraphicObserver;

public class Lakitu extends Enemy{

	static final private int pointsOnDeath=60;
	static final private int pointsOnKill=0;
	
	public Lakitu(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
		direction="Left";
		flies=true;
	}
	
	public void moveRight(int frame) {
		float enemyX=getX();
		setX(GraphicTools.round2Digits(enemyX + horizontalSpeed));
		setSprite(sprites.get("Right"));
		observer.update();
	}
	
	public void moveLeft(int frame) {
		float enemyX=getX();
		setX(GraphicTools.round2Digits(enemyX - horizontalSpeed));
		setSprite(sprites.get("Left" ));
		observer.update();
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
