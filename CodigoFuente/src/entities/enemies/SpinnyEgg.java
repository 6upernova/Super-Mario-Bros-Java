package entities.enemies;
import views.ViewConstants;

public class SpinnyEgg extends SpinnyState {
    
    public SpinnyEgg(Spinny spinny){
        super(spinny);
    }
    
    public void moveRight(int frame) {
        applyGravity();
	}
    
	public void moveLeft(int frame) {
        applyGravity();
	}
    public void applyGravity() {
		if (spinny.isInAir() && !spinny.getFlies()) { 
			spinny.setVerticalSpeed((spinny.getVerticalSpeed()) + ViewConstants.WORLD_GRAVITY * 0.5f); 
			if (spinny.getVerticalSpeed() >= ViewConstants.MAX_FALL_SPEED+5) {
				spinny.setVerticalSpeed(ViewConstants.MAX_FALL_SPEED+5); 
			}
			float worldY = spinny.getY();
			spinny.setY(worldY + (spinny.getVerticalSpeed() * 0.02f));
		}
	}

    public void visitPlatform(){
        spinny.changeToNormalState();
    }

}
