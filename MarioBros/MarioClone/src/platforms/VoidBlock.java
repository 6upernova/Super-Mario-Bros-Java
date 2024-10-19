package platforms;

import factories.Sprite;
import game.Visitor;
import views.GraphicObserver;
//Representa vacíos entre bloques por los que puede caer Mario
public class VoidBlock extends Platform{
	static final private int pointsOnKill = -15;
	static final private boolean isBreakeable = false;
	
	public VoidBlock(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, isBreakeable); 
	}

	public int getPointOnKill() {
		return pointsOnKill;
	}
	
	public void acceptVisit(Visitor visitor) {
    	visitor.visit(this);
    }
	public void setObserver(GraphicObserver observer) {
		this.observer = observer;
	}
}