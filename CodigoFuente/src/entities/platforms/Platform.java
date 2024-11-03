package entities.platforms;

import entities.Entity;
import entities.PlatformsVisitor;
import entities.VisitedElement;
import entities.enemies.Enemy;
import entities.enemies.EnemyVisitor;
import factories.Sprite;

public abstract class Platform extends Entity implements VisitedElement, EnemyVisitor{

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
	
    public void visit(Enemy enemy) {}
    
}
