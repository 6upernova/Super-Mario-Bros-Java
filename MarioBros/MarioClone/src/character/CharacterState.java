package character;

import java.util.HashMap;

import factories.Sprite;

public abstract class CharacterState {
    protected Character character;
    HashMap<String, Sprite> stateSprites;
    CharacterState(Character character) {
        this.character = character;
    }
    public abstract void damaged();

    public HashMap<String, Sprite> getSprites() {
		return character.getNormalSprites();
	}
    protected abstract int getStarPoints();
    
}