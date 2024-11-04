package entities.projectile;

import java.util.HashMap;

import factories.Sprite;
import tools.GraphicTools;

public class FireBall extends Projectile {
	String direction;
	HashMap<String,Sprite> sprites;
	public FireBall(Sprite sprite, float positionInX, float positionInY, String direction, HashMap<String,Sprite> sprites ) {
		super(sprite, positionInX, positionInY, direction);
		this.sprites = sprites;
	}

	public void animation() {
		
	}

	public void moveRight(int spriteNumber) {
		float projectileX = getX();
		setX(GraphicTools.round2Digits(projectileX + horizontalSpeed));
		verticalSpeed += 0.02f;     
    	setY(getY() - verticalSpeed);
		setSprite(sprites.get(""+spriteNumber));  
		observer.update();
    }

	public void rebound(){
		setY(getY()+1);
		verticalSpeed = -verticalSpeed*0.4f;	
	}


	public void moveLeft(int spriteNumber){
		float projectileX = getX();
		setX(GraphicTools.round2Digits(projectileX - horizontalSpeed));
		verticalSpeed += 0.02f;      
    	setY(getY() - verticalSpeed);
		setSprite(sprites.get(""+spriteNumber));
		observer.update();
	}
}
