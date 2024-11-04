package entities.state.question;

import factories.Sprite;
import observer.SoundObserver;

public class QuestionBlockEmpty extends QuestionState{

	public QuestionBlockEmpty(int hits, Sprite newSprite) {
		super(hits, newSprite);
	}

	public int damaged(SoundObserver soundObserver) {
		return 0;
	}

}
