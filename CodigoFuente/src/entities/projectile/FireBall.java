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
		verticalSpeed += 0.02f;
		System.out.println(verticalSpeed+"," +getY());      
    	setY(getY() - verticalSpeed);  
		observer.update();
    }

	public void rebound(){
		setY(getY()+1);
		verticalSpeed = -verticalSpeed*0.7f;
		
	}


	public void moveLeft(){
		float projectileX = getX();
		setX(GraphicTools.round2Digits(projectileX - horizontalSpeed));
		verticalSpeed += 0.02f;      
    	setY(getY() - verticalSpeed);  
		observer.update();
	}
}
