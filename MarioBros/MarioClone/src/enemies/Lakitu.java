package enemies;
import factories.Sprite;

public class Lakitu extends Enemy{

	static final private int pointsOnDeath=60;
	static final private int pointsOnKill=0;
	
	public Lakitu(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
	}

	public int getPointsOnDeath() {
		return pointsOnDeath;
	}
	
	public int getPointsOnKill() {
		return pointsOnKill;
	}
	
}
