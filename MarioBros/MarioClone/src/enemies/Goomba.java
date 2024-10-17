package enemies;
import factories.Sprite;

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
}
