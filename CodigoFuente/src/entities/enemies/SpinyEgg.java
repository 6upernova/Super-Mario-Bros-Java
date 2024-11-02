package entities.enemies;
import views.ViewConstants;

public class SpinyEgg extends SpinyState {
    
    public SpinyEgg(Spiny spiny){
        super(spiny);
    }
    public void moveRight(int frame) {
        applyGravity();
	}
	public void moveLeft(int frame) {
        applyGravity();
	}
    public void applyGravity() {
		if (spiny.isInAir() && !spiny.getFlies()) { 
			spiny.setVerticalSpeed((spiny.getVerticalSpeed()) + ViewConstants.WORLD_GRAVITY * 0.5f); 
			if (spiny.getVerticalSpeed() >= ViewConstants.MAX_FALL_SPEED+5) {
				spiny.setVerticalSpeed(ViewConstants.MAX_FALL_SPEED+5); 
			}
			float worldY = spiny.getY();
			spiny.setY(worldY + (spiny.getVerticalSpeed() * 0.02f));
		}
	}

    public void visitPlatform(){
        spiny.changeToNormalState();
    }

}
