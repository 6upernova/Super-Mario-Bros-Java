package entities.platforms;

import entities.character.ObserverSound;
import factories.Sprite;

public class QuestionBlockEmpty extends QuestionState{

	public QuestionBlockEmpty(int hits, Sprite newSprite) {
		super(hits, newSprite);
	}

	public int damaged() {
		return 0;
	}

	@Override
	public int damaged(ObserverSound observerSound) {
		// TODO Auto-generated method stub
		return 0;
	}

}
