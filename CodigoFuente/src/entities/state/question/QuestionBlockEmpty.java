package entities.state.question;
import factories.Sprite;
import observer.ObserverSound;
public class QuestionBlockEmpty extends QuestionState{

	public QuestionBlockEmpty(int hits, Sprite newSprite) {
		super(hits, newSprite);
	}

	public int damaged() {
		return 0;
	}

	@Override
	public int damaged(ObserverSound observerSound) {
		return 0;
	}

}
