package character;

import projectile.*;

public class FireState extends SuperState{
	
	protected final String name= "Fire";
	protected Projectile fireBall;
	protected int numberFireBall;
	
	public FireState() {
		fireBall= new FireBall();
	}

	public String getName() {
		return name;
	}

	public void damaged(Character mario) {
		super.damaged(mario);
	}
	
	public boolean execute() {
		boolean toReturn =throwFireBall();
		return toReturn;
	}
	
	public boolean  throwFireBall() {
		boolean toReturn= true;
		if( numberFireBall > 1) {
		   subtractFireBallsThrowers();
		   fireBall.animation();
		}
		else toReturn= false;
		return toReturn;
	}
	//Las bolas de fuego son infinitas?
	public void addFireBallsThrowers() {
		numberFireBall++;
	}
	
	public void subtractFireBallsThrowers() {
		numberFireBall--;
	}

}
