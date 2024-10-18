package character;

import java.util.HashMap;
import enemies.*;
import factories.Sprite;
import game.Entity;
import game.Visitor;
import powerUps.*;
import views.ViewConstants;

public class Character extends Entity implements CharacterEntity {
	
	protected int lives;
	protected int score;
	protected boolean invincible;
	protected CharacterState actualState;
	protected HashMap<String, Sprite> sprites;
	
	//Gravity and jump
	protected boolean isInAir;
	protected float verticalSpeed;

	
	
	public Character(Sprite sprite, HashMap<String,Sprite> sprites) {
        super(sprite ,5,1);
		this.sprites = sprites;
		this.score=0;
		this.lives=3;
        this.invincible= false;
		this.isInAir = false;
		this.verticalSpeed = 0;
	}

	
	public void moveLeft(String key){
		float worldX = getX();
	    setX(round2Digits(worldX - ViewConstants.CHARACTER_SPEED));
		setSprite(sprites.get(key));	
		observer.update();
	}
	
	public void moveRight(String key){
        float worldX = getX();
	    setX(round2Digits(worldX + ViewConstants.CHARACTER_SPEED));
		setSprite(sprites.get(key));
		observer.update();
	}
	
	public void applyGravity() {
		if (isInAir) {
			verticalSpeed -= ViewConstants.WORLD_GRAVITY ; 
			float worldY = getY();
			setY(worldY + verticalSpeed); 
			observer.update();
			
			
			if (isOnSolid()) {
				isInAir = false;
				verticalSpeed = 0; 
			}
		}
	}
	
	public void jump(){
		if(!isInAir && isOnSolid()){
			verticalSpeed = ViewConstants.CHARACTER_JUMP;
        	isInAir = true;
        	observer.update();
		}
	}

	private boolean isOnSolid(){

		//Metodo provisional hasta definir lo de las colisiones es decir hay que comprobar 
		return getY() <= 1;

	}

	public boolean isInAir(){
		return isInAir;
	}



	
	private float round2Digits(float number){
		return Math.round(number * 100.0) / 100.0f;
	}

	public void stayStill(String key){
		setSprite(sprites.get(key));
		observer.update();
	}

	
	
	public void dead(){
		lives--;
		//animation.dead();
	}
	
	public void damaged() {
	}
    
    protected void changeState(int numberOfState) {
        //actuallyState= stateList[numberOfState];
    }
    
	
	public int getScore() {
	    return score;
	}
	
	public void addScore(int number){
		score = score + number;
	}
	
	public void subtractScore(int number){
			score = score - number;
	}
	
	public int getLives() {
		return lives;
	}

	public boolean isInvincible() {
		return invincible;
	}


	public float getSpeed() {
		return ViewConstants.CHARACTER_SPEED;
	}

	//Element
	public void acceptVisit(Visitor visitor) {
		super.acceptVisit(visitor);
	}
	

	//Visits
	public void visit(Star star) {
		int points= star.getPoints();
		if (invincible)
			points = points + 15;
		addScore( points );
		//hacer que desaparezca de la pantalla
		invincible = true;
	}
	
	public void visit(FireFlower flower) {
		//actuallyState= stateList[2];
		int points= flower.getPoints();
		if (actualState.getName() == "Super")
			points = points + 25;
		else if(actualState.getName() == "Fire")
		        points = points + 45;
		addScore( points );
		//hacer que desaparezca de la pantalla
	}
	
	public void visit(GreenMushroom greenMushroom) {
		lives++;
		addScore( greenMushroom.getPoints() );
		//hacer que desaparezca de la pantalla
	}
	
	
	public void visit(SuperMushroom mushroom) {
		//actualState= stateList[1];
		int points= mushroom.getPoints();
		if (actualState.getName() == "Super")
			points = points + 40;
		addScore( points );
		//hacer que desaparezca de la pantalla
	}
	
	
    public void visit(Coin coin) {
    	addScore( coin.getPoints() );
		//hacer que desaparezca de la pantalla
    }
   /* 
    public void visit(Goomba goomba) {
    	addScore(goomba.getPointsOnDeath());
    	goomba.dead();
    }
    
    public void visit(Lakitu lakitu) {
    	addScore(lakitu.getPointsOnDeath());
    	lakitu.dead();
    }
	
    public void visit(KoopaTroopa koopaTroopa) {
    	addScore(koopaTroopa.getPointsOnDeath());
    	koopaTroopa.dead();
    }
    
    public void visit(BuzzyBeetle buzzyBeetle) {
    	addScore(buzzyBeetle.getPointsOnDeath());
    	buzzyBeetle.dead();
    }
    */
    public void visit(Void voidBlock) {
    	subtractScore(15);
		/*	si todavia tiene vidas	
				resetea el nivel
			sino muere 
		 */
        dead();
    }



}