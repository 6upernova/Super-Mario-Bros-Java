package entities.enemies;

import entities.Entity;
import entities.VisitedElement;
import entities.character.CharacterVisitor;
import factories.Sprite;
import tools.GraphicTools;
import views.EnemyObserver;
import views.Observer;
import views.ViewConstants;
import java.util.HashMap;

public abstract class Enemy extends Entity implements EnemyEntity,VisitedElement, EnemyVisitor{
	
	protected int pointsOnDeath;
	protected int pointsOnKill;
	protected String direction;

	//flags
	protected boolean isActive;
	protected boolean isAlive;
	protected boolean isInAir;
	protected boolean flies;
	protected boolean isHostile;

	protected float horizontalSpeed;
	protected float verticalSpeed;
	
	protected HashMap<String, Sprite> sprites;
	
	public Enemy(Sprite sprite, float positionInX, float positionInY, int pointsOnDeath,int pointsOnKill) {
		super(sprite, positionInX, positionInY);
		this.pointsOnDeath = pointsOnDeath;//Puntos cuando enemigo muere
		this.pointsOnKill = pointsOnKill;  //Puntos cuando enemigo mata
		this.horizontalSpeed = ViewConstants.ENEMY_SPEED;
		this.verticalSpeed = 0;
		this.isActive = false;
		this.isInAir = true;
		this.isAlive = true;
		
	}

	public void move(int frame){
		switch (direction) {
            case "Left":
                moveLeft(frame);
                break;
            case "Right":
                moveRight(frame);
                break;
            case "None":
            	break;
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
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public void setDirection(String newDirection) {
		direction = newDirection;
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
	public void deactivateEnemy(){
		isActive = false;
	}

	public HashMap<String, Sprite> getSpritesMap(){
		return sprites;
	}

	public void setSpritesMap(HashMap<String, Sprite> spritesMap){
		sprites = spritesMap;
	}
	
	public float getHorizontalSpeed(){
		return horizontalSpeed;
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
		((EnemyObserver)observer).remove();
		setAlive(false);
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


	public void acceptVisit(EnemyVisitor visitor){
		visitor.visit(this);
	}

	public void visit(Enemy enemy){
		if(this.leftCollision(enemy))
			leftEnemyCollision(enemy);
		else if(this.rightCollision(enemy))
			rightEnemyCollision(enemy);
	
	}

	private void leftEnemyCollision(Enemy enemy){
			this.setDirection("Right");
			enemy.setDirection("Left");
	}
	private void rightEnemyCollision( Enemy enemy){
			this.setDirection("Left");
			enemy.setDirection("Right");
	}
	
}

	
	
	
	

