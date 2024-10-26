package character;
import java.util.HashMap;
import factories.Sprite;

public class SuperState extends CharacterState{	
	SuperState(Character character) {
		super(character);
		character.updateBoundingBoxToBig();
	}

	public void damaged() {
		character.changeState(new NormalState(character));
		character.updateBoundingBoxToSmall();
	}

	public HashMap<String, Sprite> getSprites() {
		HashMap<String, Sprite> sprites;
		if(character.isInvincible()){
			sprites = character.getSuperInvencibleSprites();
		}
		else sprites = character.getSuperSprites();
		return sprites;
	}
	
	@Override
	protected int getStarPoints() {
		return 30;
	}
}