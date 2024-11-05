package entities.state.question;

import entities.character.CharacterEntity;
import factories.Sprite;
import observer.SoundObserver;

public class QuestionBlockEmpty extends QuestionState{

	public QuestionBlockEmpty(int hits, Sprite newSprite) {
		super(hits, newSprite);
	}

	public int damaged(SoundObserver soundObserver, CharacterEntity character) {
		return 0;
	}

}
