package platforms;

import factories.Sprite;
//Representa vacíos entre bloques por los que puede caer Mario
public class Void extends Platform{
	
	static final private int pointsOnKill=-15;
	static final private boolean isBreakeable=false;
	
	public Void(Sprite sprite, int x, int y) {
		super(sprite, x, y, isBreakeable); 
	}

	public int getPointOnKill() {
		return pointsOnKill;
	}
}