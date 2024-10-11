package platforms;

import factories.Sprite;
//Representa vacíos entre bloques por los que puede caer Mario
public class Void extends Platform{

	public Void(Sprite sprite, int x, int y) {
		super(sprite, x, y, false); 
	}

	public void killMario() {
		
	}
}
