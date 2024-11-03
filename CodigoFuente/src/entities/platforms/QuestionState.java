package entities.platforms;

import factories.Sprite;
import entities.character.ObserverSound;
import entities.powerUps.PowerUp;

public abstract class QuestionState {

	protected int hits;
	protected PowerUp powerUpOn;
	protected Sprite sprite;
	
	public QuestionState(int hits, Sprite newSprite) {
		this.hits= hits;
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
		return hits == 0;
	}
	
	public abstract int damaged(ObserverSound observerSound);

	public PowerUp getPowerUp() {
		return powerUpOn;
	}

}
