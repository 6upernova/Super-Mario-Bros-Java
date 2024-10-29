package entities.character;
import java.util.HashMap;
import factories.Sprite;

public class FireState extends SuperState{
	public FireState(Character character, HashMap<String, Sprite> stateSprites) {
		super(character, stateSprites);
	}
	public void damaged() {
		super.damaged();
	}
	
	public boolean execute() {
		boolean toReturn = true;
		//completar
		return toReturn;
	}
	
	public HashMap<String, Sprite>  getSprites(){
		HashMap<String, Sprite> sprites;
		if(character.isInvincible()){
			sprites = character.getSuperInvencibleSprites();
		}
		else 
			sprites = stateSprites;
		return sprites;
	}

	
	protected int getFireFlowerPoints() {
		return 35;
	}

	public boolean canThrowFireball(){
		return true;
	}
}
