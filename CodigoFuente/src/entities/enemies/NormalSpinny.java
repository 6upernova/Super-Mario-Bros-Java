package entities.enemies;

import tools.GraphicTools;
import views.ViewConstants;

public class NormalSpinny extends SpinnyState {
   
	public NormalSpinny(Spinny spinny){
        super(spinny);
    }
    
    public void moveRight(int frame) {
		float enemyX = spinny.getX();
		spinny.setX(GraphicTools.round2Digits(enemyX + spinny.getHorizontalSpeed()));
		spinny.setSprite(spinny.getSpritesMap().get("Right" + frame));
		spinny.getObserver().update();
	}
	public void moveLeft(int frame) {
		float enemyX = spinny.getX();
		spinny.setX(GraphicTools.round2Digits(enemyX - spinny.getHorizontalSpeed()));
		spinny.setSprite(spinny.getSpritesMap().get("Left" + frame));
		spinny.getObserver().update();
	}
	public void applyGravity() {
		if (spinny.isInAir && !spinny.getFlies()){ 
			spinny.setVerticalSpeed(spinny.getVerticalSpeed() + ViewConstants.WORLD_GRAVITY);
			if(spinny.getVerticalSpeed() <= ViewConstants.MAX_FALL_SPEED){
				spinny.setVerticalSpeed( ViewConstants.MAX_FALL_SPEED);
			}
			float worldY = spinny.getY();
			spinny.setY(worldY + (spinny.getVerticalSpeed() * 0.04f));
		}
	}

	public void visitPlatform() {
	}
    
}
