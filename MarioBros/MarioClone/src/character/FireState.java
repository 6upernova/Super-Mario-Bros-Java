package character;

import projectile.*;

public class FireState extends SuperState{
	
	protected final String name= "Fire";
	protected Projectile fireBall;
	protected int numberFireBall;
	
	public FireState() {
		this.fireBall= new FireBall();
	}

	public String getName() {
		return name;
	}

	public void damaged(Character mario) {
		super.damaged(mario);
	}
	
	public boolean execute() {
		boolean toReturn = throwFireBall();
		return toReturn;
	}
	
	public boolean  throwFireBall() {
		boolean canTrhowFireBall = numberFireBall > 1;
		if(canTrhowFireBall) {
		   subtractFireBallsThrowers();
		   fireBall.animation();
		}
		else canTrhowFireBall = false;
		return canTrhowFireBall;
	}
	//Las bolas de fuego son infinitas?
	public void addFireBallsThrowers() {
		numberFireBall++;
	}
	
	public void subtractFireBallsThrowers() {
		numberFireBall--;
	}

}
