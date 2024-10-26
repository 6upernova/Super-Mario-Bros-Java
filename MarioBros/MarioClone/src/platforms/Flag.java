package platforms;

import factories.Sprite;
import game.CharacterVisitor;

public class Flag extends Platform{
	static final private boolean isBreakeable = false;

	public Flag(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, isBreakeable);
	}

	public void acceptVisit(CharacterVisitor visitor) {
    	visitor.visit(this);
    }
	
}
