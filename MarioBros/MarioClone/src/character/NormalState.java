package character;
import java.util.HashMap;
import factories.Sprite;

public class NormalState extends CharacterState{
		
	public NormalState(Character character, HashMap<String, Sprite> stateSprites ) {
		super(character, stateSprites, false);
	}

	public void damaged() {
		character.dead();
	}
	
	public HashMap<String, Sprite> getSprites() {
		HashMap<String, Sprite> sprites;
		if(character.isInvincible())
			sprites = character.getNormalInvencibleSprites();
		else 
			sprites = stateSprites;
		return sprites;
	}

	protected int getStarPoints() {
		return 20;
	}

	
	protected int getMushroomPoints() {
		return 10;
	}

	protected int getFireFlowerPoints() {
		return 5;
	}
	public boolean isSuper(){
		return false;
	}
	
}
