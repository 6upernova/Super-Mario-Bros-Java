package enemies;
import factories.Sprite;
import game.CharacterVisitor;

public class Spiny extends Enemy{

	static final private int pointsOnDeath=60;
	static final private int pointsOnKill=-30;
	private String direction;
	
	public Spiny(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
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
}
