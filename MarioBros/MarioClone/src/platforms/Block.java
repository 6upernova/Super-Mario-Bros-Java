package platforms;

import factories.Sprite;
import game.Visitor;

public class Block extends Platform{

	public Block(Sprite sprite, int x, int y) {
		super(sprite, x, y, false);
	}
	
	public void acceptVisit(Visitor visitor) {
		super.acceptVisit(visitor);
	}
	
}
