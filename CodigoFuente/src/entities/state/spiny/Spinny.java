package entities.state.spiny;
import java.util.HashMap;
import entities.character.CharacterVisitor;
import entities.enemies.Enemy;
import entities.platforms.Platform;
import factories.Sprite;
import observer.GraphicObserver;

public class Spinny extends Enemy{		
	static final private int pointsOnDeath=60;
	static final private int pointsOnKill=-30;	
	protected SpinnyState spinnyState;
	protected HashMap<String, SpinnyState> spinnyStates;	
	public Spinny(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
		direction = "Left";
		flies = false;
		this.spinnyStates = getSpinnyStates();
		spinnyState = spinnyStates.get("Egg");
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
		spinnyState = spinnyStates.get("Egg");	
		observer.update();
	}
	
	public void changeToNormalState(){
		spinnyState = spinnyStates.get("Normal");
        Sprite normalSprite = sprites.get("Right1");
        setSprite(normalSprite);
        observer.update();	
	}
	private HashMap<String, SpinnyState> getSpinnyStates(){
		HashMap<String, SpinnyState> spinnyStates = new HashMap<String, SpinnyState>();
		spinnyStates.put("Normal", new NormalSpinny(this));
		spinnyStates.put("Egg", new SpinnyEgg(this));
		return spinnyStates;
	}
	
	public void moveRight(int frame) {
		spinnyState.moveRight(frame);
	}	
	
	public void moveLeft(int frame) {
		spinnyState.moveLeft(frame);
	}

	public void applyGravity(){
		spinnyState.applyGravity();		
		observer.update();
	}

	public void visit(Platform p) {
		spinnyState.visitPlatform();
	}
}
