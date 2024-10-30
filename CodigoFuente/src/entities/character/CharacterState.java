package entities.character;

import java.util.HashMap;

import factories.Sprite;

public abstract class CharacterState {
    protected Character character;
    protected HashMap<String, Sprite> stateSprites;
    protected boolean breakBlocks;

    public CharacterState(Character character, HashMap<String, Sprite> stateSprites, boolean capacityToBreakBlocks) {
        this.character = character;
        this.stateSprites = stateSprites;
        breakBlocks= capacityToBreakBlocks;
    }

    public abstract void damaged();

    public HashMap<String, Sprite> getSprites() {
		return stateSprites;
	}

    protected abstract int getStarPoints();
    protected abstract int getMushroomPoints();
    protected abstract int getFireFlowerPoints();
    protected  boolean breakBlock() {
    	return breakBlocks;
    }

    protected boolean canThrowFireball(){
        return false;
    }

    public boolean isSuper() {
        return true;
    }
    
}