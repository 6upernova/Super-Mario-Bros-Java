package character;
public abstract class CharacterState {
    protected Character character;
    CharacterState(Character character) {
        this.character = character;
    }
    public void damaged(){}    
}