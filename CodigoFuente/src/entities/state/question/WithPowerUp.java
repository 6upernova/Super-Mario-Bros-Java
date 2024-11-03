package entities.state.question;
import factories.Sprite;
import observer.ObserverSound;
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
