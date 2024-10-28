package character;

import java.util.HashMap;

import factories.Sprite;

public abstract class CharacterState {
    protected Character character;
    HashMap<String, Sprite> stateSprites;

    public CharacterState(Character character, HashMap<String, Sprite> stateSprites) {
        this.character = character;
        this.stateSprites = stateSprites;
    }

    public abstract void damaged();

    public HashMap<String, Sprite> getSprites() {
		return stateSprites;
	}

    protected abstract int getStarPoints();
    protected abstract int getMushroomPoints();
    protected abstract int getFireFlowerPoints();
    
}