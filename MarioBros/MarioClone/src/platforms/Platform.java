package platforms;

import factories.Sprite;
import game.Entity;

public abstract class Platform extends Entity{

	protected boolean isBreakeable;
	
	public Platform(Sprite sprite, int positionInX, int positionInY, boolean isBreakeable) {
		super(sprite, positionInX, positionInY);
		this.isBreakeable = isBreakeable;
	}
	
	public boolean isBreakeable() {
		return isBreakeable;
	}
}
