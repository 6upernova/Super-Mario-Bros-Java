package enemies;
import factories.Sprite;
import game.Entity;
import game.VisitedElement;
import views.Observer;
import game.EnemyVisitor;

public abstract class Enemy extends Entity implements EnemyEntity, EnemyVisitor,VisitedElement{
	
	private int pointsOnDeath;
	private int pointsOnKill;
	private String direction;
	private boolean isActive;
	
	public Enemy(Sprite sprite, int positionInX, int positionInY, int pointsOnDeath,int pointsOnKill) {
		super(sprite, positionInX, positionInY);
		this.pointsOnDeath=pointsOnDeath;//Puntos cuando enemigo muere
		this.pointsOnKill=pointsOnKill;//Puntos cuando enemigo mata
		this.isActive = false;
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
	
	public void dead() {
		//desaparecerlo de la pantalla y que se borre el objeto
	}
	
	
	public void moveRight() {
		float enemyX=getX();
		
	}

	
	public void moveLeft() {
		float enemyY=getY();
		
	}
}
