package character;
import java.util.HashMap;

import factories.Sprite;
import projectile.FireBall;

public class FireState extends SuperState{
	
	private FireBall fireBall;
	
	public FireState(Character character, HashMap<String, Sprite> stateSprites) {
		super(character, stateSprites);
		this.fireBall= new FireBall();
	}
	public void damaged() {
		super.damaged();
	}
	
	public boolean execute() {
		boolean toReturn = true;
		//completar
		return toReturn;
	}
	
	public void throwFireBall() {
		fireBall.animation();
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

}
