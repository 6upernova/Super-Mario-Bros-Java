package projectile;

import factories.Sprite;
import game.Entity;
import tools.GraphicTools;

public abstract class Projectile extends Entity{
	protected boolean isMovingRight;
	protected float horizontalSpeed;
	protected String direction;
	protected Projectile(Sprite sprite, float positionInX, float positionInY, String direction) {
		super(sprite, positionInX, positionInY);
		this.direction = direction;
	}

	public abstract void animation();

    public void moveRight() {
		float projectileX = getX();
		setX(GraphicTools.round2Digits(projectileX + horizontalSpeed));
		observer.update();
    }

	public void moveLeft(){
		float projectileX = getX();
		setX(GraphicTools.round2Digits(projectileX - horizontalSpeed));
		observer.update();
	}

	public String getDirection() {
		return direction;
	}

}
