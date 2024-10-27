package enemies;
import factories.Sprite;
import game.Entity;
import game.VisitedElement;
import tools.GraphicTools;
import views.Observer;
import views.ViewConstants;
import game.EnemyVisitor;

public abstract class Enemy extends Entity implements EnemyEntity, EnemyVisitor,VisitedElement{
	
	private int pointsOnDeath;
	private int pointsOnKill;
	private String direction;
	private boolean isActive;
	private float horizontalSpeed;
	
	public Enemy(Sprite sprite, int positionInX, int positionInY, int pointsOnDeath,int pointsOnKill) {
		super(sprite, positionInX, positionInY);
		this.pointsOnDeath = pointsOnDeath;//Puntos cuando enemigo muere
		this.pointsOnKill = pointsOnKill;//Puntos cuando enemigo mata
		this.horizontalSpeed = ViewConstants.ENEMY_SPEED;
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
		setX(GraphicTools.round2Digits(enemyX + horizontalSpeed));
		observer.update();
	}

	
	public void moveLeft() {
		float enemyX=getX();
		setX(GraphicTools.round2Digits(enemyX - horizontalSpeed));
		observer.update();
	}
}
