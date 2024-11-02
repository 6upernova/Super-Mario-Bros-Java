package entities.enemies;
import java.util.HashMap;
import entities.character.CharacterVisitor;
import entities.platforms.Platform;
import factories.Sprite;
import views.GraphicObserver;
public class Spiny extends Enemy{	
	static final private int pointsOnDeath=60;
	static final private int pointsOnKill=-30;
	protected SpinyState spinyState;
	protected HashMap<String, SpinyState> spinyStates;
	
	public Spiny(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
		direction = "Left";
		flies = false;
		this.spinyStates = getSpinyStates();
		spinyState = spinyStates.get("Egg");
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
		observer.update();
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

	public void changeToEggState(){		
		spinyState = spinyStates.get("Egg");	
		observer.update();
	}
	
	public void changeToNormalState(){
		spinyState = spinyStates.get("Normal");
        Sprite normalSprite = sprites.get("Right1");
        setSprite(normalSprite);
        observer.update();	
	}
	private HashMap<String, SpinyState> getSpinyStates(){
		HashMap<String, SpinyState> spinyStates = new HashMap<String, SpinyState>();
		spinyStates.put("Normal", new NormalSpiny(this));
		spinyStates.put("Egg", new SpinyEgg(this));
		return spinyStates;
	}
	public void moveRight(int frame) {
		spinyState.moveRight(frame);
	}	
	public void moveLeft(int frame) {
		spinyState.moveLeft(frame);
	}

	public void applyGravity(){
		spinyState.applyGravity();		
		observer.update();
	}

	public void visit(Platform p) {
		spinyState.visitPlatform();
	}
}
