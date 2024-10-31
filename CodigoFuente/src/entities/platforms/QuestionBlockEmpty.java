package entities.platforms;

import factories.Sprite;

public class QuestionBlockEmpty extends QuestionState{

	public QuestionBlockEmpty(int hits, Sprite newSprite) {
		super(hits, newSprite);
	}

	public int damaged() {
		return 0;
	}

}
