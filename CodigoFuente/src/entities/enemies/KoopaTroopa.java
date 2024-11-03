package entities.enemies;

import java.util.HashMap;
import entities.character.CharacterVisitor;
import entities.platforms.Platform;
import entities.character.Character;
import factories.Sprite;
import views.GraphicObserver;

public class KoopaTroopa extends Enemy{

	static final private int pointsOnDeath=90;
	static final private int pointsOnKill=-45;
	
	protected HashMap<String, KoopaTroopaState> koopaTroopaStates;
	protected KoopaTroopaState koopaTroopaActualState;
	
	public KoopaTroopa(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, pointsOnDeath, pointsOnKill);
		direction="Left";
		flies=false;
		koopaTroopaStates = getKoopaTroopaStates();
		koopaTroopaActualState = koopaTroopaStates.get("Normal");
	}

	private HashMap<String, KoopaTroopaState> getKoopaTroopaStates(){
		HashMap<String, KoopaTroopaState> koopaTroopaStates = new HashMap<String, KoopaTroopaState>();
		koopaTroopaStates.put("Normal", new KoopaTroopaNormalState(this));
		koopaTroopaStates.put("Shell", new KoopaTroopaShellState(this));
		return koopaTroopaStates;
	}
	
	public void move(int frame){
		koopaTroopaActualState.move(frame);
	}

	public void hit(Character character){
		koopaTroopaActualState.hit(character);
	}

	public void normalMode(){
		koopaTroopaActualState = koopaTroopaStates.get("Normal");
	}

	public void shellMode(){
		KoopaTroopaShellState shellState = (KoopaTroopaShellState) koopaTroopaStates.get("Shell");
		koopaTroopaActualState = shellState;
		shellState.updateShell();
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
	
	public void visit(Enemy enemy) {
		koopaTroopaActualState.hitEnemy(enemy);
	}

	@Override
	public void visit(Platform platform) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptVisit(EnemyVisitor enemy) {
		// TODO Auto-generated method stub
		
	}
	
}
