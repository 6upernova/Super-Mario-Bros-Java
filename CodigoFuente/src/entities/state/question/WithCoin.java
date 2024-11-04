package entities.state.question;
import factories.Sprite;
import observer.SoundObserver;
public class WithCoin extends QuestionState{

	public WithCoin(Sprite sprite) {
		super(3,sprite);
	}

	public int damaged(SoundObserver soundObserver) {
		hits--;
		soundObserver.reproduceSound("coin");
		return powerUpOn.getPoints();
	}

}
