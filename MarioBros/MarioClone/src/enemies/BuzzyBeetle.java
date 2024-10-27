package enemies;

import factories.Sprite;
import game.CharacterVisitor;
import platforms.Platform;
import views.GraphicObserver;

public class BuzzyBeetle extends Enemy {

	static final private int pointsOnDeath=30;
	static final private int pointsOnKill=-15;
	private String direction;
	
	public BuzzyBeetle(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY,pointsOnDeath,pointsOnKill);
		direction="Left";
	}
	public String getDirection() {
		return direction;
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
	@Override
	public void visit(Platform platform) {
		// TODO Auto-generated method stub
		
	}

}