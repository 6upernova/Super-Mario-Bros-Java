package platforms;

import factories.Sprite;
import game.Visitor;

public class Question extends Platform {

	static final private boolean isBreakeable=false;
	
	public Question(Sprite sprite, int x, int y) {
		super(sprite, x, y, isBreakeable);
	}

	public void acceptVisit(Visitor visitor) {
		super.acceptVisit(visitor);
	}
}
