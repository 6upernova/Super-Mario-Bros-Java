package platforms;

import factories.Sprite;

public class Flag extends Platform{

	static final private boolean isBreakeable=false;
	
	public Flag(Sprite sprite, int x, int y) {
		super(sprite, x, y, isBreakeable);
	}

}
