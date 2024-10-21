package character;
public class SuperState extends CharacterState{	
	SuperState(Character character) {
		super(character);
	}
	public void damaged(Character character) {
		character.changeState(new NormalState(character));
	}
}