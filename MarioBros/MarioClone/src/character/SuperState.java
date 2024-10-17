package character;

public class SuperState implements CharacterState{
	
	protected final String name= "Super";

	public String getName() {
		return name;
	}

	public void damaged(Character mario) {
		CharacterState newState = new NormalState();
		//mario.changeState(newState);
	}

}
