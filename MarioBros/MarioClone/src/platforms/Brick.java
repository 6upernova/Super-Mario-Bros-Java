package platforms;

import factories.Sprite;
import game.Visitor;

public class Brick extends Platform{

	public Brick(Sprite sprite, int x, int y) {
		super(sprite, x, y, true);
	}

	public void brakeBrick() {
		
	}
	
	public void acceptVisit(Visitor visitor) {
		super.acceptVisit(visitor);
	}
}
