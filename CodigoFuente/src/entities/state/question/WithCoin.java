package entities.state.question;
import java.util.HashMap;

import entities.character.CharacterEntity;
import factories.Sprite;
import observer.EntityObserver;
import observer.SoundObserver;
public class WithCoin extends QuestionState{

	public WithCoin(Sprite sprite, Question question) {
		super(3,sprite, question);
		
	}

	public int damaged(SoundObserver soundObserver) {
		hits--;
		soundObserver.reproduceSound("coin");
		((EntityObserver)question.getGraphicObserver()).spawnCoin(question.coinAnimationSprites.get("1"));
		return powerUpOn.getPoints();
	}

}
