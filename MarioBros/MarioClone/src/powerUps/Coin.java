package powerUps;
import factories.Sprite;
import game.CharacterVisitor;

public class Coin extends PowerUp{
	static final private int points = 5;
	
	public Coin(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, points);
	}
	
	public int getPoints() {
		return points;
	}
	public void acceptVisit(CharacterVisitor visitor) {
    	visitor.visit(this);
    }

}
