package entities.character.characterStates;
import java.util.HashMap;
import entities.character.Character;
import factories.Sprite;

public class SuperState extends CharacterState{		
	
	public SuperState(Character character ,  HashMap<String, Sprite> stateSprites) {
		super(character, stateSprites, true);
	}
	
	public void damaged() {
		character.changeState("Normal");
		character.getCharacterAnimations().superAnimation(character,"Super", "Normal");
		character.updateBoundingBoxToSmall();
	}

	public HashMap<String, Sprite> getSprites() {
		HashMap<String, Sprite> sprites;
		if(character.isInvincible()){
			sprites = character.getSuperInvencibleSprites();
		}
		else 
			sprites = stateSprites;

		return sprites;
	}
	
	
	public int getStarPoints() {
		return 30;
	}

	
	public int getMushroomPoints() {
		return 50;
	}

	
	public int getFireFlowerPoints() {
		return 30;
	}

	@Override
	public boolean canThrowFireball() {
		return false;
	}

	@Override
	public boolean isSuper() {
		return true;
	}

}