package enemies;

import factories.Sprite;
import game.Entity;

public abstract class Enemy extends Entity{

	protected Enemy(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}

	
}
