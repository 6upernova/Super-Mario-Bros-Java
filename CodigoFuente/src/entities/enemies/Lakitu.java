package entities.enemies;
import entities.character.CharacterVisitor;
import entities.character.Character;
import factories.Sprite;
import tools.GraphicTools;
import views.GraphicObserver;
import views.ViewConstants;

public class Lakitu extends Enemy {

	static final private int pointsOnDeath=60;
	static final private int pointsOnKill=0;

	protected Character characterReference;
	protected long arrivalTimeMillis;
	protected String characterSide;
	protected boolean waiting;
	
	public Lakitu(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
		direction="Left";
		flies=true;
		characterReference = null;
		characterSide = "Left";
		horizontalSpeed = ViewConstants.CHARACTER_SPEED;
		waiting = false;
	}

	public void move(int frame){
		float destinationX = characterSide == "Right" ? characterReference.getX() - 3 : characterReference.getX() + 3;
		if(!isOnDestinationCoords(destinationX)){
			horizontalSpeed = ViewConstants.CHARACTER_SPEED * 3/2;
			if(destinationX > positionInX)
				direction = "Right";
			else if(destinationX < positionInX)
				direction = "Left";
			else if(isOnDestinationCoords(destinationX))
				direction = "None";

			super.move(frame);
		}
		else {
			horizontalSpeed = ViewConstants.CHARACTER_SPEED;
			if(!waiting){
				arrivalTimeMillis = System.currentTimeMillis();
				waiting = true;
			}
			if(checkThrowTime()){
				waiting = false;
				switchSide();
				throwSpinyEgg(characterSide);
			}
		}
	}

	private void throwSpinyEgg(String orientation){
		System.out.println("Throws egg to "+ orientation);
	}

	private boolean checkThrowTime(){
		return System.currentTimeMillis() - arrivalTimeMillis >= 3000;
	}

	private boolean isOnDestinationCoords(float destinationX){
		return positionInX - horizontalSpeed <= destinationX && destinationX <= positionInX + horizontalSpeed;
	}

	private void switchSide(){
		characterSide = characterSide == "Left" ? "Right" : "Left";
	}

	public void moveRight(int frame) {
		float enemyX=getX();
		setX(GraphicTools.round2Digits(enemyX + horizontalSpeed));
		setSprite(sprites.get("Right"));
		observer.update();
	}
	
	public void moveLeft(int frame) {
		float enemyX=getX();
		setX(GraphicTools.round2Digits(enemyX - horizontalSpeed));
		setSprite(sprites.get("Left"));
		observer.update();
	}

	public void setCharacterReference(Character character){
		this.characterReference = character;
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
