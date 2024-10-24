package platforms;

import factories.Sprite;
import game.CharacterVisitor;
import views.GraphicObserver;

public class Brick extends Platform{
	public Brick(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, true);
	}

	public void brakeBrick() {
		
	}
	
	public void acceptVisit(CharacterVisitor visitor) {
    	visitor.visit(this);
    }
	public void setObserver(GraphicObserver observer) {
		this.observer = observer;
	}
}
