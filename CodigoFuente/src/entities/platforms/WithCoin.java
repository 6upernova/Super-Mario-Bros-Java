package entities.platforms;

import entities.character.ObserverSound;
import factories.Sprite;

public class WithCoin extends QuestionState{

	public WithCoin(Sprite sprite) {
		super(3,sprite);
	}

	public int damaged(ObserverSound observerSound) {
		hits--;
		return powerUpOn.getPoints();
	}

}
