package entities.state.question;
import entities.character.CharacterEntity;
import factories.Sprite;
import observer.SoundObserver;
public class WithCoin extends QuestionState{

	public WithCoin(Sprite sprite) {
		super(3,sprite);
	}

	public int damaged(SoundObserver soundObserver, CharacterEntity character) {
		hits--;
		soundObserver.reproduceSound("coin");
		character.addCoins(1);
		return powerUpOn.getPoints();
	}

}
