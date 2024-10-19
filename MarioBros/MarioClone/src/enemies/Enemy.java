package enemies;
import factories.Sprite;
import game.Entity;
import game.VisitedElement;
import views.Observer;

public abstract class Enemy extends Entity implements VisitedElement{
	private int pointsOnDeath;
	private int pointsOnKill;
	
	public Enemy(Sprite sprite, int positionInX, int positionInY, int pointsOnDeath,int pointsOnKill) {
		super(sprite, positionInX, positionInY);
		this.pointsOnDeath=pointsOnDeath;//Puntos cuando enemigo muere
		this.pointsOnKill=pointsOnKill;//Puntos cuando enemigo mata
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
}
