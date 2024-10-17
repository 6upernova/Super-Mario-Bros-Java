package enemies;
import factories.Sprite;

public class KoopaTroopa extends Enemy{

	static final private int pointsOnDeath=90;
	static final private int pointsOnKill=-45;
	
	
	public KoopaTroopa(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
	}

	public int getPointsOnDeath() {
		return pointsOnDeath;
	}
	
	public int getPointsOnKill() {
		return pointsOnKill;
	}
	
}
