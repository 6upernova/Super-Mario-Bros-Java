package entities.enemies;
import entities.character.CharacterVisitor;
import factories.Sprite;
import tools.GraphicTools;
import views.GraphicObserver;
import views.ViewConstants;

public class PiranhaPlant extends Enemy{

	static final private int pointsOnDeath=30;
	static final private int pointsOnKill=-30;
	protected final float spawnY;
	protected long stopTime;
	
	public PiranhaPlant(Sprite sprite, float positionInX, float positionInY) {
		super(sprite, positionInX + 0.5f, positionInY - 67/43f, pointsOnDeath, pointsOnKill);
		spawnY = positionInY - 67/43f;
		direction="Up";
		flies=false;
	}
	
	public void move(int frame){
		long currentTime = System.currentTimeMillis();
		if(currentTime - stopTime >= 2000){
			switch (direction) {
				case "Up":
					moveUp(frame);
					break;
				case "Down":
					moveDown(frame);
					break;
				case "None":
					break;
			}
			checkDirectionChange();
		}	
		setSprite(sprites.get("PiranhaPlant" + frame));
		observer.update();
	}

	public void moveUp(int frame){
		float enemyY = getY();
		setY(GraphicTools.round2Digits(enemyY + horizontalSpeed));
	}

	public void moveDown(int frame){
		float enemyY = getY();
		setY(GraphicTools.round2Digits(enemyY - horizontalSpeed));
	}

	private void checkDirectionChange(){
		String newDirection = getDirection() == "Up" ? "Down" : "Up";
		if(getY() <= spawnY || getY() >= spawnY + getHeight()){
			direction = newDirection;
			stopTime = System.currentTimeMillis();
		}
	}
	
	public void applyGravity() {
	}

	public int getPointsOnDeath() {
		return pointsOnDeath;
	}
	
	public int getPointsOnKill() {
		return pointsOnKill;
	}
	
	public void acceptVisit(CharacterVisitor visitor) {
    	visitor.visit(this);
    }
	
	public void setObserver(GraphicObserver observer) {
		this.observer = observer;
	}
}
