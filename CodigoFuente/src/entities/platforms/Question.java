package entities.platforms;

import java.util.HashMap;
import entities.character.CharacterVisitor;
import entities.character.ObserverSound;
import entities.powerUps.Coin;
import entities.powerUps.PowerUp;
import factories.Sprite;

public class Question extends Platform {

	private static final boolean isBreakeable = false;
	
	protected QuestionState actualState;
	protected HashMap<String,QuestionState> questionStates;
	
	public Question(Sprite sprite, int positionInX, int positionInY, HashMap<String,QuestionState> states) {
		super(sprite, positionInX, positionInY, isBreakeable);
		questionStates= states;
		actualState =null;
	}

	public void setPowerUp(PowerUp powerUp){
		actualState= questionStates.get("WithOrtherPowerUp");
		actualState.setPowerUp(powerUp);
	}
	
	public void setPowerUp(Coin coin){
		actualState= questionStates.get("WithCoin");
		actualState.setPowerUp(coin);
	}
	
	public int damage(ObserverSound observerSound){
		int points= actualState.damaged(observerSound); 
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
