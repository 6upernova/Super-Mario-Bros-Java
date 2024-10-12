package platforms;

import factories.Sprite;
import game.Entity;

public abstract class Platform extends Entity{

	protected boolean isBreakeable;
	
	public Platform(Sprite sprite, int x, int y, boolean isBreakeable) {
		super(sprite, x, y);
		this.isBreakeable=isBreakeable;
	}
	
	public boolean isBreakeable() {
		return isBreakeable;
	}
}
