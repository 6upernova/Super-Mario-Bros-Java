package powerUps;
import factories.Sprite;

public class SuperMushroom extends PowerUp{
	static final private int points = 10;
	
	public SuperMushroom(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, points);
	}

	public int getPoints() {
		return points;
	}
	
}
