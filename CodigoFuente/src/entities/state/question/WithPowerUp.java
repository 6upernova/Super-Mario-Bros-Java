package entities.state.question;
import factories.Sprite;
import observer.SoundObserver;

public class WithPowerUp extends QuestionState {

	public WithPowerUp(Sprite sprite, Question question) {
		super(1, sprite, question);
	}

	public int damaged(SoundObserver soundObserver) {
	    hits--;
	    powerUpOn.activatePowerUp();
		soundObserver.reproduceSound("powerUpAppears");
		return 0;
	}

}
