package entities.platforms;

import entities.Entity;
import entities.PlatformsVisitor;
import entities.VisitedElement;
import factories.Sprite;

public abstract class Platform extends Entity implements VisitedElement, Visited{

	protected boolean isBreakeable;
	
	public Platform(Sprite sprite, int positionInX, int positionInY, boolean isBreakeable) {
		super(sprite, positionInX, positionInY);
		this.isBreakeable = isBreakeable;
	}
	
	public boolean isBreakeable() {
		return isBreakeable;
	}
	
    public void acceptVisit(PlatformsVisitor visitor){
		visitor.visit(this);
	}
	
}
