package platforms;

import factories.Sprite;
import game.CharacterVisitor;

public class PipeTopLeft extends Pipe {
	
	public PipeTopLeft(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY);
	}

	public void acceptVisit(CharacterVisitor visitor) {
    	visitor.visit(this);
    }

}
