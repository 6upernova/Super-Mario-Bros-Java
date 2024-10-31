package entities.platforms;

import factories.Sprite;

public class WithCoin extends QuestionState{

	public WithCoin(Sprite sprite) {
		super(3,sprite);
	}

	public int damaged() {
		golpesantesdeestarvacio--;
		return powerUpOn.getPoints();
	}

}
