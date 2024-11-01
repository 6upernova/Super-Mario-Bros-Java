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
	protected float characterX;
	
	public Lakitu(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
		direction="Left";
		flies=true;
		characterReference = null;
	}

	public void move(int frame){
		if(!isOnCharacterCoords()){
			if(characterX > positionInX)
				moveRight(frame);
			else {
				direction = "Left";
				moveLeft(frame);
			}
		}
		else{
			characterX = characterReference.getX();
			throwSpinyEgg(getSpinyOrientation());
		}
	}

	private void throwSpinyEgg(String orientation){
		System.out.println("Throws egg to "+ orientation);
	}

	private String getSpinyOrientation(){
		return characterReference.getX() > positionInX ? "Right" : "Left";
	}

	private boolean isOnCharacterCoords(){
		return positionInX - ViewConstants.ENEMY_SPEED <= characterX && characterX <= positionInX + ViewConstants.ENEMY_SPEED;
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
	
	public void activateEnemy(){
		super.activateEnemy();
		characterX = characterReference.getX();
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
