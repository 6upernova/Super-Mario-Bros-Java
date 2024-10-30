package entities.projectile;

import factories.Sprite;

public class FireBall extends Projectile {
	String direction;
	public FireBall(Sprite sprite, float positionInX, float positionInY, String direction) {
		super(sprite, positionInX, positionInY, direction);
	}

	public void animation() {
		
	}
}
