package powerUps;

import factories.Sprite;

public class FireFlower extends PowerUp{

	static final private int points=5;
	
	protected FireFlower(Sprite sprite, int x, int y) {
		super(sprite, x, y);
		// TODO Auto-generated constructor stub
	}
	
	public int getPoints() {
		return points;
	}
}
