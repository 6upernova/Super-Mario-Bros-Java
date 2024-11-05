package entities.state.question;
import factories.Sprite;
import observer.SoundObserver;

public class QuestionBlockEmpty extends QuestionState{

	public QuestionBlockEmpty(int hits, Sprite newSprite, Question question) {
		super(hits, newSprite,question);
	}

	public int damaged(SoundObserver soundObserver) {
		return 0;
	}

}
