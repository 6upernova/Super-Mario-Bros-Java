package character;
import java.util.HashMap;
import factories.Sprite;

public class NormalState extends CharacterState{
	NormalState(Character character) {
		super(character);
	}

	public void damaged() {
		System.out.println("Mario golpeado en estado normal");
	}
	
	public HashMap<String, Sprite> getSprites() {
		HashMap<String, Sprite> sprites;
		if(character.isInvincible())
			sprites = character.getNormalInvencibleSprites();
		else sprites = character.getNormalSprites();
		return sprites;
	}

	@Override
	protected int getStarPoints() {
		return 20;
	}
	
}
