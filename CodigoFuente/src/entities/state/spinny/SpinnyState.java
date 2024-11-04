package entities.state.spinny;

import entities.enemies.Spinny;

public abstract class SpinnyState {
	
    protected Spinny spinny;
    
    public SpinnyState(Spinny spinny){
        this.spinny = spinny;
    }
    public abstract void moveRight(int frame);
	public abstract void moveLeft(int frame);
    public abstract void visitPlatform();
    public abstract void applyGravity();
}
