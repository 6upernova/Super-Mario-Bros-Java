package character;

import factories.Sprite;
import game.Entity;

public class Character extends Entity {
	
	protected int lifes;
	protected int score;
	protected boolean invinsible;
	protected State state; 
	
	public Character(String sprite) {
        super( new Sprite("assets.player.1") ,6,4);
		score=0;
		lifes=3;
        invinsible= false;
	}
	
	public void moveLeft(){
		int worldX = getX();
	    setX(worldX +6);
	}
	
	public void moveRight(){
        int worldX = getX();
	    setX(worldX - 6);
	}
	
	public void jump(){
		//no es necesario por el momento
	}
	
	public void dead(){
		lifes--;
		//animation.dead();
	}
	
	public void damaged() {
		state.damaged(this);
	}

	public void addScore(int number){
		score += number;
	}
	
	public void subtractScore(int number){
		score -= number;
	}
	
	public void visitStar(Star star) {
		int points= star.getPoints();
		if (invinsible)
			points +=-15;
		addScore( points );
		//hacer que desaparezca de la pantalla
		invinsible= true;
	}
	
	public void visitFireFlower(FireFlower flower) {
		state= new Fire();
		int points= flower.getPoints();
		if (state.getName() == "Super")
			points +=-25;
		else if(state.getName() == "Fire")
		        points +=45;
		addScore( points );
		//hacer que desaparezca de la pantalla
	}
	
	public void visitGreenMushroom(GreenMushroom star) {
		lifes++;
		addScore( star.getPoints() );
		//hacer que desaparezca de la pantalla
	}
	
	public void visitMushroom(Mushroom mushroom) {
		state= new Super();
		int points= mushroom.getPoints();
		if (state.getName() == "Super")
			points +=-40;
		addScore( points );
		//hacer que desaparezca de la pantalla
	}
	
    public void visitCoin(Coin coin) {
    	addScore( coin.getPoints() );
		//hacer que desaparezca de la pantalla
    }
    
    public int getScore() {
    	return score;
    }
    
    public void collision(Entity e){
    	e.acceptVisit(this);
    }
    
    protected void changeState(State newState) {
        //animacion de cambio de estado
    	state= newState;
    }
}