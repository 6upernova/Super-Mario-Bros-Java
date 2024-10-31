package entities.platforms;

import factories.Sprite;

public class WithPowerUp extends QuestionState {

	public WithPowerUp(Sprite sprite) {
		super(1, sprite);
	}

	public int damaged() {
	    golpesantesdeestarvacio--;
	    powerUpOn.activatePowerUp();
		return 0;
	}

}
