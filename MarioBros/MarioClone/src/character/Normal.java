package character;

public class Normal extends State{
	
	protected final String name= "Normal";


	@Override
	public String getName() {
		return name;
	}

	@Override
	public void damaged(Character mario) {
		mario.dead();
	}

}
