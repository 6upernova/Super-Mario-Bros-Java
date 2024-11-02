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
	protected float travelTime; 			//0<= travelTime <= 1
	
	public Lakitu(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
		direction="Left";
		flies=true;
		characterReference = null;
		characterSide = "Left";
		horizontalSpeed = ViewConstants.CHARACTER_SPEED;
		waiting = false;
		travelTime = 0;
	}

	public void move(int frame){
		float destinationX = characterSide == "Right" ? characterReference.getX() - 3 : characterReference.getX() + 3;
		if(!isOnDestinationCoords(destinationX)){
			updateHorizontalSpeed();
			changeDirectionToDestination(destinationX);
			super.move(frame);
		}
		else {
			travelTime = 0;
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

	private void changeDirectionToDestination(float destinationX){
		if(destinationX > positionInX)
			direction = "Right";
		else if(destinationX < positionInX)
			direction = "Left";
		else if(isOnDestinationCoords(destinationX))
			direction = "None";
	}

	private boolean isOnDestinationCoords(float destinationX){
		return positionInX - horizontalSpeed <= destinationX && destinationX <= positionInX + horizontalSpeed;
	}

	private void throwSpinyEgg(String orientation){
		System.out.println("Throws egg to "+ orientation);
	}

	private boolean checkThrowTime(){
		return System.currentTimeMillis() - arrivalTimeMillis >= 3000;
	}

	private void switchSide(){
		characterSide = characterSide == "Left" ? "Right" : "Left";
	}

	private void updateHorizontalSpeed(){
		travelTime += travelTime < 1 ? 1/26f : 0;
		horizontalSpeed =  ViewConstants.CHARACTER_SPEED + 0.08f * travelTime * travelTime * travelTime;		
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
