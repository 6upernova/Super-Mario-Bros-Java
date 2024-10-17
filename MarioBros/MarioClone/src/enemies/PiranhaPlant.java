package enemies;
import factories.Sprite;

public class PiranhaPlant extends Enemy{

	static final private int pointsOnDeath=30;
	static final private int pointsOnKill=-30;
	
	public PiranhaPlant(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
	}
	
	public int getPointsOnDeath() {
		return pointsOnDeath;
	}
	
	public int getPointsOnKill() {
		return pointsOnKill;
	}
	
}
