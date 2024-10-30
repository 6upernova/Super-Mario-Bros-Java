package enemies;

import factories.Sprite;
import game.Entity;
import game.VisitedElement;
import tools.GraphicTools;
import views.Observer;
import views.ViewConstants;
import java.util.HashMap;

public abstract class Enemy extends Entity implements EnemyEntity,VisitedElement{
	
	protected int pointsOnDeath;
	protected int pointsOnKill;
	protected String direction;
	protected boolean isActive;
	protected boolean isInAir;
	protected float horizontalSpeed;
	protected float verticalSpeed;
	protected boolean flies;
	protected HashMap<String, Sprite> sprites;
	
	public Enemy(Sprite sprite, int positionInX, int positionInY, int pointsOnDeath,int pointsOnKill) {
		super(sprite, positionInX, positionInY);
		this.pointsOnDeath = pointsOnDeath;//Puntos cuando enemigo muere
		this.pointsOnKill = pointsOnKill;  //Puntos cuando enemigo mata
		this.horizontalSpeed = ViewConstants.ENEMY_SPEED;
		this.verticalSpeed = 0;
		this.isActive = false;
		this.isInAir = true;
	}
	
	public void setDirection(String newDirection) {
		direction=newDirection;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public int pointsOnDeath() {
		return pointsOnDeath;
	}
	
	public int getPointsOnKill() {
		return pointsOnKill;
	}
	
	public Observer getObserver() {
		return observer;
	}
	public boolean isActive(){
		return isActive;
	}
	public void activateEnemy(){
		isActive = true;
	}

	public void setSpritesMap(HashMap<String, Sprite> spritesMap){
		sprites = spritesMap;
	}
	
	public float getVerticalSpeed() {
		return verticalSpeed;
	}
	
	public void setVerticalSpeed(float verticalSpeed) {
		this.verticalSpeed = verticalSpeed;
		observer.update();
	}

	public boolean isInAir() {
		return isInAir;
	}
	
	public void setIsInAir(boolean value) {
		isInAir=value;
	}
	
	public void dead() {
		//desaparecerlo de la pantalla y que se borre el objeto
	}
	

	public void applyGravity() {
		if (isInAir&&!flies){ 
			verticalSpeed += ViewConstants.WORLD_GRAVITY;
			if(verticalSpeed <= ViewConstants.MAX_FALL_SPEED){
				verticalSpeed = ViewConstants.MAX_FALL_SPEED;
			}
			float worldY = getY();
			setY(worldY + (verticalSpeed*0.04f));
			observer.update();
		}
	}
	
	public void moveRight(int frame) {
		float enemyX=getX();
		setX(GraphicTools.round2Digits(enemyX + horizontalSpeed));
		setSprite(sprites.get("Right" + frame));
		observer.update();
	}
	
	public void moveLeft(int frame) {
		float enemyX=getX();
		setX(GraphicTools.round2Digits(enemyX - horizontalSpeed));
		setSprite(sprites.get("Left" + frame));
		observer.update();
	}
	//Borrar estos cuando termine
	public void moveRight() {
		float enemyX=getX();
		setX(GraphicTools.round2Digits(enemyX + horizontalSpeed));
		observer.update();
	}
	
	public void moveLeft() {
		float enemyX=getX();
		setX(GraphicTools.round2Digits(enemyX - horizontalSpeed));
		observer.update();
	}
	
	
}
