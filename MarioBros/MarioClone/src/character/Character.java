package character;

import java.util.HashMap;
import enemies.BuzzyBeetle;
import enemies.Goomba;
import enemies.KoopaTroopa;
import enemies.Lakitu;
import factories.Sprite;
import game.Entity;
import game.Visitor;
import powerUps.Coin;
import powerUps.FireFlower;
import powerUps.GreenMushroom;
import powerUps.Star;
import powerUps.SuperMushroom;
import views.ViewConstants;

public class Character extends Entity implements CharacterEntity {
	
	protected int lives;
	protected int score;
	protected boolean invincible;
	protected CharacterState actuallyState;
	//Preguntar si lo dejamos en el CharacterThread o si nos la rebuscamos para ponerlo en el character 
	HashMap<String, Sprite> sprites; 

<<<<<<< Updated upstream
	
	
	public Character(Sprite sprite, HashMap<String,Sprite> sprites) {
        super( sprite ,5,1);
		this.sprites = sprites;
=======
	public Character(Sprite sprite,HashMap<String,Sprite> spritesList) {
        super( sprite ,100,0);
		sprites = spritesList;
>>>>>>> Stashed changes
		score=0;
		lives=3;
        invincible= false;
	}

	
	public void moveLeft(String key){
		float worldX = getX();
	    setX(round2Digits(worldX - ViewConstants.CHARACTER_SPEED));
		setSprite(sprites.get(key));
<<<<<<< Updated upstream
=======
	    setX(worldX - ViewConstants.CHARACTER_SPEED);	
>>>>>>> Stashed changes
		observer.update();
		
	}
	
	public void moveRight(String key){
        float worldX = getX();
	    setX(round2Digits(worldX + ViewConstants.CHARACTER_SPEED));
		setSprite(sprites.get(key));
<<<<<<< Updated upstream
=======
	    setX(worldX + ViewConstants.CHARACTER_SPEED);
>>>>>>> Stashed changes
		observer.update();
		
	}

	public void stayStill(String key){
		setSprite(sprites.get(key));
		observer.update();
	}

	public void jump(){
		//no es necesario por el momento
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
		score += number;
	}
	
	public void subtractScore(int number){
			score -= number;
	}
	
	public int getLives() {
		return lives;
	}

	public boolean isInvincible() {
		return invincible;
	}

<<<<<<< Updated upstream

	@Override
=======
>>>>>>> Stashed changes
	public float getSpeed() {
		return ViewConstants.CHARACTER_SPEED;
	}

	//Element
	public void acceptVisit(Visitor visitor) {
		super.acceptVisit(visitor);
	}
	
<<<<<<< Updated upstream
	
=======
	//Visits
	public void visit(Star star) {
		int points= star.getPoints();
		if (invincible)
			points += 15;
		addScore( points );
		//hacer que desaparezca de la pantalla
		invincible= true;
	}
	
	public void visit(FireFlower flower) {
		//actuallyState= stateList[2];
		int points= flower.getPoints();
		if (actuallyState.getName() == "Super")
			points += 25;
		else if(actuallyState.getName() == "Fire")
		        points +=45;
		addScore( points );
		//hacer que desaparezca de la pantalla
	}
	
	public void visit(GreenMushroom greenMushroom) {
		lives++;
		addScore( greenMushroom.getPoints() );
		//hacer que desaparezca de la pantalla
	}
	
	
	public void visit(SuperMushroom mushroom) {
		//actuallyState= stateList[1];
		int points= mushroom.getPoints();
		if (actuallyState.getName() == "Super")
			points +=-40;
		addScore( points );
		//hacer que desaparezca de la pantalla
	}
	
	
    public void visit(Coin coin) {
    	addScore( coin.getPoints() );
		//hacer que desaparezca de la pantalla
    }
    
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
    
    public void visit(Void voidBlck) {
    	subtractScore(15);
        dead();
    }
>>>>>>> Stashed changes
}