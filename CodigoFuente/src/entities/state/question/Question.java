package entities.state.question;

import java.util.HashMap;
import entities.character.CharacterVisitor;
import entities.platforms.Platform;
import entities.powerUps.Coin;
import entities.powerUps.PowerUp;
import factories.Sprite;
import observer.SoundObserver;

public class Question extends Platform {

	private static final boolean isBreakeable = false;
	
	protected QuestionState actualState;
	protected HashMap<String,QuestionState> questionStates;
	
	public Question(Sprite sprite, int positionInX, int positionInY, HashMap<String,QuestionState> states) {
		super(sprite, positionInX, positionInY, isBreakeable);
		this.questionStates= states;
		this.actualState =null;
	}

	public void setPowerUp(PowerUp powerUp){
		actualState= questionStates.get("WithOrtherPowerUp");
		actualState.setPowerUp(powerUp);
	}
	
	public void setPowerUp(Coin coin){
		actualState= questionStates.get("WithCoin");
		actualState.setPowerUp(coin);
	}
	
	public int damage(SoundObserver soundObserver){
		int points= actualState.damaged(soundObserver); 
        if(actualState.isEmpty()) {
        	changeToVoidQuestionBlock();
        	observer.update();
        }
		return points;
	}

    public boolean isEmpty(){
        return actualState.isEmpty();
	}

	public void acceptVisit(CharacterVisitor visitor) {
    	visitor.visit(this);
    }
	
	private void changeToVoidQuestionBlock() {
		actualState= questionStates.get("EmptyQuestion");
		sprite= actualState.getSprite();
	}
	
	public PowerUp getPowerUp() {
		return actualState.getPowerUp();
	}
}
