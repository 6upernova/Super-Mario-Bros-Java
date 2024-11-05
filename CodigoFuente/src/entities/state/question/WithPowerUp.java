package entities.state.question;

import entities.character.CharacterEntity;
import factories.Sprite;
import observer.SoundObserver;

public class WithPowerUp extends QuestionState {

	public WithPowerUp(Sprite sprite) {
		super(1, sprite);
	}

	public int damaged(SoundObserver soundObserver, CharacterEntity character) {
	    hits--;
	    powerUpOn.activatePowerUp();
		soundObserver.reproduceSound("powerUpAppears");
		return 0;
	}

}
