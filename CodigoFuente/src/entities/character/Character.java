package entities.character;
import java.util.HashMap;

import entities.Entity;
import entities.enemies.*;
import entities.platforms.*;
import entities.powerUps.*;
import factories.Sprite;
import game.SoundReproducer;
import tools.GraphicTools;
import views.ViewConstants;
import views.CharacterObserver;

public class Character extends Entity implements CharacterEntity,CharacterVisitor {
	protected int lives;
	protected int score;
	protected int coins;

	protected CharacterState characterActualState;
	protected HashMap<String,CharacterState> characterStates;
	protected HashMap<String, Sprite> characterInvencibleSprites;
	protected HashMap<String, Sprite> characterSuperInvencibleSprites;
	protected SoundReproducer sounds;
	protected CharacterAnimations characterAnimations;

	
	//Gravity And movementd
	protected boolean isInAir;
	protected float verticalSpeed;
	protected float horizontalSpeed;

	//Flags
	protected boolean isMovingRight;
	protected boolean isInEnd;
	protected boolean invincible;
	protected boolean invulnerable;
	protected boolean isDying;

	//Constants
	public final int HIT_INVINCIBILITY_TIME = 200;
	public final int STAR_INVINCIBILITY_TIME = 5000 ;
	
	public Character(Sprite sprite) {
        super(sprite ,5,0);
		this.score = 0;
		this.lives = 3;
        this.invincible = false;
		this.invulnerable = false;
		this.isInAir = false;
		this.isDying = false;
		this.verticalSpeed = 0;
		this.horizontalSpeed = ViewConstants.CHARACTER_SPEED;
		this.isInEnd = false;
		this.coins = 0;
		sounds = new SoundReproducer();
		characterAnimations = new CharacterAnimations(this);
	}

	public void setInStart(){
		((CharacterObserver)observer).respawn();
		setX(5);
		setY(0);
	}

	public boolean isMovingRight(){
		return isMovingRight;
	}

	public boolean isDying() {
        return isDying;
    }


	public void setCharacterStates(HashMap<String,CharacterState> characterStates){
		this.characterStates = characterStates;
		characterActualState = characterStates.get("Normal");

	}
	
	public void moveLeft(String key){
			float worldX = getX();
			setX(GraphicTools.round2Digits(worldX - horizontalSpeed));
			isMovingRight=false;
			if(!isInAir())
				setSprite(characterActualState.getSprites().get(key));	
			observer.update();
	}

	public void moveRight(String key){
			float worldX = getX();
			setX(GraphicTools.round2Digits(worldX + horizontalSpeed));
			isMovingRight = true;
			if(!isInAir())
				setSprite(characterActualState.getSprites().get(key));
			observer.update();
	}

	public void applyGravity() {
		if (isInAir){ 
			verticalSpeed += ViewConstants.WORLD_GRAVITY;
			if(verticalSpeed <= ViewConstants.MAX_FALL_SPEED){
				verticalSpeed = ViewConstants.MAX_FALL_SPEED;
			}
			float worldY = getY();
			setY(worldY + (verticalSpeed*0.04f));
			
		}
	}
	
	public void jump(String key){
		if(!isInAir()){
			verticalSpeed = ViewConstants.CHARACTER_JUMP;
        	isInAir = true;
			setSprite(characterActualState.getSprites().get(key));
			sounds.setAuxiliarAudio("Jump");
        	observer.update();
        	sounds.start();
		}
	}

	public void stayStill(String key){
		if(!isInAir())
			setSprite(characterActualState.getSprites().get(key));
		observer.update();
	}

	public boolean isInAir(){
		return isInAir;
	}
	public void setIsInAir(boolean isInAir){
		this.isInAir = isInAir;
	}
	
	public boolean isInvulnerable(){
		return invulnerable;
	}

	public void setInvulnerable(boolean state){
		invulnerable = state;
	}
	
	public void dead(){
		lives--;
		
		if(this.lives > 0) {
			
			sounds.setAuxiliarAudio("marioDie");
			isDying = true;
			characterAnimations.deathAnimation();
			setInStart();
			
		}
		else sounds.setAuxiliarAudio("gameOver");
	}
	
	
    protected void changeState(String state) {
		this.characterActualState = characterStates.get(state);
    }

	public void damaged() {
		characterActualState.damaged();
	}
    
	public int getCoins() {
		return coins;
	}
	
	public int getScore() {
	    return score;
	}
	
	public void addScore(int number){
		score = score + number;
	}
	public int getLives() {
		return lives;
	}
	
	public boolean isInvincible() {
		return invincible;
	}

	public void setInvencible(boolean invincible){
		this.invincible = invincible;
	}

	public float getSpeed() {
		return ViewConstants.CHARACTER_SPEED;
	}

	//VISITAS
    public void visit(Goomba goomba) {	
		addScore(goomba.getPointsOnDeath());
		sounds.setAuxiliarAudio("kick");
		goomba.dead();
    }    
    public void visit(KoopaTroopa koopaTroopa) {
		addScore(koopaTroopa.getPointsOnDeath());
		sounds.setAuxiliarAudio("kick");
		//Change state
		koopaTroopa.dead();
    }    
    public void visit(PiranhaPlant piranhaPlant) {
		sounds.setAuxiliarAudio("kick");
		addScore(piranhaPlant.getPointsOnDeath());
		piranhaPlant.dead();
    }	
    public void visit(Lakitu lakitu) {
		sounds.setAuxiliarAudio("kick");
		addScore(lakitu.getPointsOnDeath());
		lakitu.dead();
    }
    public void visit(BuzzyBeetle buzzyBeetle) {
		sounds.setAuxiliarAudio("kick");
		buzzyBeetle.dead();
		addScore(buzzyBeetle.getPointsOnDeath());
		
    }
	public void visit(Spiny spiny) {
		addScore(spiny.getPointsOnDeath());
		sounds.setAuxiliarAudio("kick");
		spiny.dead();
	}
	/*
	public void visit(Shell shell) {
		addScore(shell.getPointsOnDeath());
		shell.dead();
		} */
	
	//power ups visits
	public void visit(SuperMushroom mushroom){
		int points = characterActualState.getMushroomPoints();
		addScore(points);
		if(!characterActualState.isSuper()){			
			characterActualState = characterStates.get("Super");
			updateBoundingBoxToBig();
			sounds.setAuxiliarAudio("mushroom");
		}
		observer.update();
		//hacer que desaparezca de la pantalla
	}

	public void visit(GreenMushroom greenMushroom){
		lives++;
		addScore(greenMushroom.getPoints());
		sounds.setAuxiliarAudio("1-up");
		//hacer que desaparezca de la pantalla
	}

	public void visit(FireFlower flower){
		int points= characterActualState.getFireFlowerPoints();
		this.characterActualState = characterStates.get("Fire");
		addScore(points);
		updateBoundingBoxToBig();
		observer.update();
	}

	public void visit(Star star){
		if (invincible) {
			addScore(35);
		}
		else {
			addScore(characterActualState.getStarPoints());
		}
		invincible = true;
		observer.update();
	}

	public void visit(Coin coin){
		addScore( coin.getPoints());
		coins++;
		//hacer que desaparezca de la pantalla
	}


	//platforms visit
	public void visit(Pipe pipe) {
	}
	
	public void visit(Flag flag) {

	}
	public void visit(VoidBlock voidBlock) {
		if (downCollision(voidBlock)){
			addScore(-15);
        	dead();
		}
    }
	
	public void visit(Block block) {
		
	}

	public void visit(Brick brickBlock) {
		
	}
	public void visit(Question questionBlock) {
		if(upCollision(questionBlock)){
			questionBlock.activatePowerUp();
			sounds.setAuxiliarAudio("powerUpAppears");
		}		
	}
	
	public void visit(Mast mast) {
		isInEnd = true;
		setSprite(characterActualState.getSprites().get("InFlag"));	
		observer.update();
	}

	public void visit(MastEnd mast) {
		isInEnd = true;
		setSprite(characterActualState.getSprites().get("InFlag"));	
		observer.update();
	}

	public boolean isInEnd(){
		return isInEnd;
	}

	public float getVerticalSpeed() {
		return verticalSpeed;
	}
	
	public void setVerticalSpeed(float verticalSpeed) {
		this.verticalSpeed = verticalSpeed;
		observer.update();
	}
	
	public float getHorizontalSpeed() {
		return horizontalSpeed;
	}
	
	public void setHorizontalSpeed(float horizontalSpeed) {
		this.horizontalSpeed = horizontalSpeed;
	}

	public void setNormalInvencibleSprites(HashMap<String, Sprite> characterInvencibleSprites) {
		this.characterInvencibleSprites = characterInvencibleSprites;
	}
	public void setSuperInvencibleSprites(HashMap<String, Sprite> characterSuperInvencibleSprites) {
		this.characterSuperInvencibleSprites = characterSuperInvencibleSprites;
	}

	
	public HashMap<String, Sprite> getNormalInvencibleSprites() {
		return characterInvencibleSprites;
    }
    public HashMap<String, Sprite> getSuperInvencibleSprites() {
		return characterSuperInvencibleSprites;
    }

    public void setInEnd(boolean isInEnd) {	
		this.isInEnd = isInEnd;
    }

    public void addCoins(int coins) {
		this.coins = coins;
    }

    public void addLives(int lives) {
		this.lives = lives;
    }

    public void setState(CharacterState state) {
		this.characterActualState = state;
    }

    public CharacterState getState() {
		return characterActualState;
    }
	
    public boolean capacityToBreakBlocks() {
    	return characterActualState.breakBlock();
    }

	public boolean canThrowFireball() {
		return characterActualState.canThrowFireball();
	}

	public void updateBoundingBoxToBig(){
		System.out.println(boundingBox.height <= ViewConstants.CELL_SIZE);
		if(boundingBox.height <= ViewConstants.CELL_SIZE){
			boundingBox.height *= 2;
			boundingBox.updateExternalBoundsToBig();
		}
	}
	public void updateBoundingBoxToSmall(){
		if(boundingBox.height > ViewConstants.CELL_SIZE){
			boundingBox.height /= 2;
			boundingBox.updateExternalBoundsToSmall();
		}
	}

   

}