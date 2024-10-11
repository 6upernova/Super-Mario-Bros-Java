package character;

public class NormalState implements CharacterState{

	
	protected final String name= "Normal";

	public String getName() {
		return name;
	}

	public void damaged(Character mario) {
		//mario.dead();
	}
	
}
