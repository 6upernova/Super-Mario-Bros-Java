package entities.state.question;
import factories.Sprite;
import observer.SoundObserver;
import entities.character.CharacterEntity;
import entities.powerUps.PowerUp;

public abstract class QuestionState {
	protected int hits;
	protected PowerUp powerUpOn;
	protected Sprite sprite;
	
	public QuestionState(int hits, Sprite newSprite) {
		this.hits = hits;
		this.powerUpOn = null;
		this.sprite = newSprite;
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
	
	public abstract int damaged(SoundObserver soundObserver, CharacterEntity character);

	public PowerUp getPowerUp() {
		return powerUpOn;
	}

}
