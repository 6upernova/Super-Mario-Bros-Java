package platforms;

import factories.Sprite;
import game.Visitor;

public class Flag extends Platform{
	static final private boolean isBreakeable = false;

	public Flag(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, isBreakeable);
	}

	public void acceptVisit(Visitor visitor) {
		super.acceptVisit(visitor);
	}
	
}
