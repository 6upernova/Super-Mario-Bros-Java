package character;

public class Super extends State{
	
	protected final String name= "Super";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void damaged(Character mario) {
		State newState= new Normal();
		mario.changeState(newState);
	}

}
