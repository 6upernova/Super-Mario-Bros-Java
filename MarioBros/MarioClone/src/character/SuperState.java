package character;
import java.util.HashMap;
import factories.Sprite;

public class SuperState extends CharacterState{	

	public SuperState(Character character ,  HashMap<String, Sprite> stateSprites) {
		super(character, stateSprites );
	}

	public void damaged() {
		character.changeState("Normal");
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
	
	
	protected int getStarPoints() {
		return 30;
	}

	
	protected int getMushroomPoints() {
		return 50;
	}

	
	protected int getFireFlowerPoints() {
		return 30;
	}
}