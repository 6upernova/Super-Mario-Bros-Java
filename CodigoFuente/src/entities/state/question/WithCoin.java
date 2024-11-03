package entities.state.question;
import factories.Sprite;
import observer.ObserverSound;
public class WithCoin extends QuestionState{

	public WithCoin(Sprite sprite) {
		super(3,sprite);
	}

	public int damaged(ObserverSound observerSound) {
		hits--;
		return powerUpOn.getPoints();
	}

}
