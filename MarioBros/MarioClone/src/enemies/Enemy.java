package enemies;
import factories.Sprite;
import game.EnemyVisitor;
import game.Entity;
import game.VisitedElement;
import platforms.Platform;
import tools.GraphicTools;
import views.Observer;
import views.ViewConstants;

public abstract class Enemy extends Entity implements EnemyEntity, EnemyVisitor,VisitedElement{
	
	private int pointsOnDeath;
	private int pointsOnKill;
	private String direction;
	private float horizontalSpeed;
	
	public Enemy(Sprite sprite, int positionInX, int positionInY, int pointsOnDeath,int pointsOnKill) {
		super(sprite, positionInX, positionInY);
		this.pointsOnDeath = pointsOnDeath;//Puntos cuando enemigo muere
		this.pointsOnKill = pointsOnKill;//Puntos cuando enemigo mata
		this.horizontalSpeed = ViewConstants.ENEMY_SPEED;
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
	
	public void dead() {
		//desaparecerlo de la pantalla y que se borre el objeto
	}
	
	public void visit(Platform platform) {
		
	}
	
	public boolean isOnSolid() {
		return getY()<=1;
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
