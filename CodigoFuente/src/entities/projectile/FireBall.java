package entities.projectile;
import java.util.HashMap;
import factories.Sprite;
import tools.GraphicTools;

public class FireBall extends Projectile {
	protected String direction;
	protected HashMap<String,Sprite> sprites;
	protected boolean isExplotion;

	public FireBall(Sprite sprite, float positionInX, float positionInY, String direction, HashMap<String,Sprite> sprites ) {
		super(sprite, positionInX, positionInY, direction);
		this.sprites = sprites;
		isExplotion=false;
	}

	public void moveRight(int spriteNumber) {
		float projectileX = getX();
		setX(GraphicTools.round2Digits(projectileX + horizontalSpeed));
		verticalSpeed += 0.01f;     
    	setY(getY() - verticalSpeed);
		setSprite(sprites.get(""+spriteNumber));  
		observer.update();
    }

	public void rebound(){
		verticalSpeed = -verticalSpeed*0.4f;
		setY(getY()+0.5f);
	}

	public Sprite getSprite(String path){
		return sprites.get(path);
	}

	public void explotion(int count){
		sprite= sprites.get("explotion"+ count);
		observer.update();
	}

	public void moveLeft(int spriteNumber){
		float projectileX = getX();
		setX(GraphicTools.round2Digits(projectileX - horizontalSpeed));
		verticalSpeed += 0.01f;      
    	setY(getY() - verticalSpeed);
		setSprite(sprites.get(""+spriteNumber));
		observer.update();
	}

	public boolean getIsExplotion(){
		return isExplotion;
	}

	public void setIsExplotion(boolean isExplotion){
		this.isExplotion= isExplotion;
	}
}
