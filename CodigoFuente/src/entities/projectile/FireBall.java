package entities.projectile;

import factories.Sprite;
import tools.GraphicTools;

public class FireBall extends Projectile {
	String direction;
	public FireBall(Sprite sprite, float positionInX, float positionInY, String direction) {
		super(sprite, positionInX, positionInY, direction);
	}

	public void animation() {
		
	}
	 public void moveRight() {
		float projectileX = getX();
		setX(GraphicTools.round2Digits(projectileX + horizontalSpeed));
		setY(initialY+(float)Math.abs(2*Math.cos(projectileX)));
		observer.update();
    }

	public void moveLeft(){
		float projectileX = getX();
		setX(GraphicTools.round2Digits(projectileX - horizontalSpeed));
		setY(initialY+(float)Math.abs(2*Math.cos(projectileX)));
		observer.update();
	}
}
