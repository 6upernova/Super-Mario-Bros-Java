package character;
import java.util.HashMap;
import factories.Sprite;

public class SuperState extends CharacterState{	
	SuperState(Character character) {
		super(character);
	}
	public void damaged(Character character) {
		character.changeState(new NormalState(character));
	}
	public HashMap<String, Sprite> getSprites() {
		HashMap<String, Sprite> sprites;
		if(character.isInvincible()){
			sprites = character.getSuperInvencibleSprites();
			System.out.println("retorne los sprites super invencible");
		}
		else sprites = character.getSuperSprites();
		return sprites;
	}
	@Override
	protected int getStarPoints() {
		return 30;
	}
}