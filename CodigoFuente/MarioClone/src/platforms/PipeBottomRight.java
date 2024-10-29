package platforms;

import factories.Sprite;
import game.CharacterVisitor;

public class PipeBottomRight extends Pipe {
	
	public PipeBottomRight(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY);
	}

	public void acceptVisit(CharacterVisitor visitor) {
    	visitor.visit(this);
    }

}
