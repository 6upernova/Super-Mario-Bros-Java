package platforms;

import factories.Sprite;
import game.CharacterVisitor;
import powerUps.PowerUp;

public class Question extends Platform {

	static final private boolean isBreakeable = false;
	protected PowerUp powerUp;
	
	public Question(Sprite sprite, int positionInX, int positionInY) {
		super(sprite, positionInX, positionInY, isBreakeable);
	}

	public void setPowerUp(PowerUp powerUp){
		this.powerUp = powerUp;
	}
	
	public void activatePowerUp(){
		powerUp.activatePowerUp();
	}

	public void acceptVisit(CharacterVisitor visitor) {
    	visitor.visit(this);
    }
}
