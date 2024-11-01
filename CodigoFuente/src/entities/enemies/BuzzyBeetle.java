package entities.enemies;
import java.util.HashMap;

import entities.character.CharacterVisitor;
import factories.Sprite;
public class BuzzyBeetle extends Enemy {

	static final private int pointsOnDeath=30;
	static final private int pointsOnKill=-15;
	protected HashMap<String, BuzzyBeetleState> buzzyBeetleStates;
	protected BuzzyBeetleState buzzyBeetleActualState;
	
	public BuzzyBeetle(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY,pointsOnDeath,pointsOnKill);
		direction="Left";
		flies=false;
		buzzyBeetleStates = getBuzzyBeetleStates();
		buzzyBeetleActualState = buzzyBeetleStates.get("Normal");
	}

	private HashMap<String, BuzzyBeetleState> getBuzzyBeetleStates(){
		HashMap<String, BuzzyBeetleState> buzzyBeetleStates = new HashMap<String, BuzzyBeetleState>();
		buzzyBeetleStates.put("Normal", new BuzzyBeetleNormalState(this));
		buzzyBeetleStates.put("Shell", new BuzzyBeetleShellState(this));
		return buzzyBeetleStates;
	}
	
	public void moveRight(int frame) {
		buzzyBeetleActualState.moveRight(frame);
	}
	
	public void moveLeft(int frame) {
		buzzyBeetleActualState.moveLeft(frame);
	}

	public void hit(){
		buzzyBeetleActualState.hit();
	}

	public void normalMode(){
		buzzyBeetleActualState = buzzyBeetleStates.get("Normal");
	}

	public void shellMode(){
		buzzyBeetleActualState = buzzyBeetleStates.get("Shell");
        Sprite shellSprite = sprites.get("Shell");
        setSprite(shellSprite);
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
	

}