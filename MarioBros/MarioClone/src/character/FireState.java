package character;
import projectile.FireBall;

public class FireState extends SuperState{
	private FireBall fireBall;
	public FireState(Character character) {
		super(character);
		this.fireBall= new FireBall();
	}
	public void damaged(Character character) {
		super.damaged(character);
	}
	
	public boolean execute() {
		boolean toReturn = true;
		//completar
		return toReturn;
	}
	
	public void  throwFireBall() {
		fireBall.animation();
	}

}
