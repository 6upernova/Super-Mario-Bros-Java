package platforms;

import factories.Sprite;
import game.CharacterVisitor;

public class Brick extends Platform{
	public Brick(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, true);
	}

	public void breakBrick() {
		boundingBox = null;
        sprite= new Sprite("void");
		observer.update();
	}
	
	public void acceptVisit(CharacterVisitor visitor) {
    	visitor.visit(this);
    }
}
