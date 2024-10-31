package entities.platforms;

import factories.Sprite;
import entities.powerUps.PowerUp;

public abstract class QuestionState {

	protected int golpesantesdeestarvacio;
	protected PowerUp powerUpOn;
	protected Sprite sprite;
	
	public QuestionState(int hits, Sprite newSprite) {
		golpesantesdeestarvacio= hits;
		powerUpOn= null;
		sprite= newSprite;
	}
	
	public void setPowerUp(PowerUp powerUp) {
		powerUpOn= powerUp;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public boolean isEmpty() {
		return golpesantesdeestarvacio == 0;
	}
	
	public abstract int damaged();

	public PowerUp getPowerUp() {
		return powerUpOn;
	}

}
