package entities.platforms;

import entities.character.ObserverSound;
import factories.Sprite;

public class WithPowerUp extends QuestionState {

	public WithPowerUp(Sprite sprite) {
		super(1, sprite);
	}


	public int damaged(ObserverSound observerSound) {
	    hits--;
	    powerUpOn.activatePowerUp();
		observerSound.reproduceSound("powerUpAppears");
		return 0;
	}

}
