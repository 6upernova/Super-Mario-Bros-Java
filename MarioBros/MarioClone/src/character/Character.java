package character;

import java.util.HashMap;
import factories.Sprite;
import game.Entity;
import views.ViewConstants;

public class Character extends Entity implements CharacterEntity {
	
	protected int lives;
	protected int score;
	protected boolean invincible;
	protected CharacterState state;

	//Preguntar si lo dejamos en el CharacterThread o si nos la rebuscamos para ponerlo en el character 
	HashMap<String, Sprite> sprites; 

	
	
	public Character(Sprite sprite, HashMap<String,Sprite> sprites) {
        super( sprite ,5,1);
		this.sprites = sprites;
		score=0;
		lives=3;
        invincible= false;
	}

	
	public void moveLeft(String key){
		float worldX = getX();
	    setX(round2Digits(worldX - ViewConstants.CHARACTER_SPEED));
		setSprite(sprites.get(key));
		observer.update();
	}
	private float round2Digits(float number){
		return Math.round(number * 100.0) / 100.0f;
	}
	
	public void moveRight(String key){
        float worldX = getX();
	    setX(round2Digits(worldX + ViewConstants.CHARACTER_SPEED));
		setSprite(sprites.get(key));
		observer.update();
		
	}

	public void stayStill(String key){
		setSprite(sprites.get(key));
		observer.update();
	}


	
	/*
	public void jump(){
		//no es necesario por el momento
	}
	
	public void dead(){
		lifes--;
		animation.dead();
	}
	
	public void damaged() {
		//no es necesario por el momento
	}

	
	
	
	public void visitStar(Star star) {
		int points= star.getPoints();
		if (invincible)
			points +=-15;
		addScore( points );
		//hacer que desaparezca de la pantalla
		invincible= true;
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
	
	public void visitGreenMushroom(GreenMushroom greenMushroom) {
		lifes++;
		addScore( greenMushroom.getPoints() );
		//hacer que desaparezca de la pantalla
	}
	
	
	public void visitSuperMushroom(Mushroom mushroom) {
		state= new Super();
		int points= superMushroom.getPoints();
		if (state.getName() == "Super")
			points +=-40;
		addScore( points );
		//hacer que desaparezca de la pantalla
	}
	
	
    public void visitCoin(Coin coin) {
    	addScore( coin.getPoints() );
		//hacer que desaparezca de la pantalla
    }
    
   
    
    public void collision(Entity e){
    	e.acceptVisit(this);
    }
    
    protected void changeState(CharacterState newState) {
        //animacion de cambio de estado
    	state= newState;
    }
    
	
	private void computeScoreFromEntity(Entity e) {
		
	}*/
	
	public int getScore() {
	    return score;
	}
	
	public void addScore(int number){
		score += number;
	}
	
	public void subtractScore(int number){
			score -= number;
	}


	
	public int getLives() {
		return lives;
	}


	
	


	@Override
	public boolean isInvincible() {
		return invincible;
	}


	@Override
	public float getSpeed() {
		return ViewConstants.CHARACTER_SPEED;
	}


	
	
}