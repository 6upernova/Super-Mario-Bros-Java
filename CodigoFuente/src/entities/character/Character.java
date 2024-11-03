package entities.character;
import java.util.HashMap;

import entities.Entity;
import entities.character.characterStates.*;
import entities.enemies.*;
import entities.platforms.*;
import entities.powerUps.*;
import entities.state.buzzyBeetle.BuzzyBeetle;
import entities.state.koopaTroopa.KoopaTroopa;
import entities.state.question.Question;
import entities.state.spiny.Spinny;
import factories.Sprite;
import observer.CharacterObserver;
import observer.ObserverSound;
import tools.GraphicTools;
import views.ViewConstants;

public class Character extends Entity implements CharacterEntity,CharacterVisitor {
	
	public final int HIT_INVINCIBILITY_TIME = 500;
	public final int STAR_INVINCIBILITY_TIME = 5000 ;
	
	protected int lives;
	protected int score;
	protected int coins;
	protected CharacterState characterActualState;
	protected HashMap<String,CharacterState> characterStates;
	protected HashMap<String, Sprite> characterInvencibleSprites;
	protected HashMap<String, Sprite> characterSuperInvencibleSprites;
	protected CharacterAnimations characterAnimations;
	protected ObserverSound observerOfSounds;
	protected boolean isInAir;
	protected float verticalSpeed;
	protected float horizontalSpeed;
	protected boolean isMovingRight;
	protected boolean isInEnd;
	protected boolean invincible;
	protected boolean invulnerable;
	protected boolean isBusy;
	
	public Character(Sprite sprite) {
        super(sprite ,5,0);
		this.score = 0;
		this.lives = 3;
        this.invincible = false;
		this.invulnerable = false;
		this.isInAir = false;
		this.isBusy = false;
		this.verticalSpeed = 0;
		this.horizontalSpeed = ViewConstants.CHARACTER_SPEED;
		this.isInEnd = false;
		this.coins = 0;
		this.characterAnimations = new CharacterAnimations(this);
	}

	public void setInStart(){	
		setX(5);
		setY(0);
		((CharacterObserver)observer).respawn();
		setX(5);
		setY(0.5f);
		observer.update();
	}

	public void setCharacterStates(HashMap<String,CharacterState> characterStates){
		this.characterStates = characterStates;
		characterActualState = characterStates.get("Normal");
	}

	protected HashMap<String,CharacterState> getCharacterStates(){
		return characterStates;
	}
	
	public void moveLeft(int frame){
			float worldX = getX();
			setX(GraphicTools.round2Digits(worldX - horizontalSpeed));
			isMovingRight=false;
			if(!isInAir())
				setSprite(characterActualState.getSprites().get("Left" + frame));	
			observer.update();
	}

	public void moveRight(int frame){
			float worldX = getX();
			setX(GraphicTools.round2Digits(worldX + horizontalSpeed));
			isMovingRight = true;
			if(!isInAir())
				setSprite(characterActualState.getSprites().get("Right" + frame));
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
			observer.update();
			
		}
	}
	
	public void smallJump(String direction){
		verticalSpeed = ViewConstants.CHARACTER_JUMP / 2;
		setSprite(characterActualState.getSprites().get("Jumping" + direction));
        observer.update();
	}
	
	public void jump(String key){
		if(!isInAir()){
			verticalSpeed = ViewConstants.CHARACTER_JUMP;
        	isInAir = true;
			setSprite(characterActualState.getSprites().get(key));
        	observer.update();
        	observerOfSounds.reproduceSound("jump");
		}
	}

	public void stayStill(String key){
		if(!isInAir())
			setSprite(characterActualState.getSprites().get(key));
		isMovingRight = false;
		observer.update();
	}

	public void dead(){
		lives--;
		if(this.lives > 0) {
			characterAnimations.deathAnimation();
		}
		else observerOfSounds.reproduceSoundOneIteration("gameOver");
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
		this.invulnerable = state;
	}

	public boolean isMovingRight(){
		return isMovingRight;
	}

	public boolean isBusy() {
        return isBusy;
    }

	public void setIsBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}

    public void changeState(String state) {
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
	
	public ObserverSound getObserverSound(){
		return observerOfSounds;
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

    public void visit(Goomba goomba) {	
		killEnemySound();
		observerOfSounds.reproduceSound("stomp");
		addScore(goomba.getPointsOnDeath());
		goomba.dead();
    }    
    
    public void visit(KoopaTroopa koopaTroopa) {
		killEnemySound();
		observerOfSounds.reproduceSound("stomp");
		addScore(koopaTroopa.getPointsOnDeath());
		koopaTroopa.hit(this);
    }   
    
    public void visit(PiranhaPlant piranhaPlant) {
		addScore(piranhaPlant.getPointsOnDeath());
		this.damaged();
    }	
    
    public void visit(Lakitu lakitu) {
		killEnemySound();
		addScore(lakitu.getPointsOnDeath());
		lakitu.dead();
    }
    
    public void visit(BuzzyBeetle buzzyBeetle) {
		killEnemySound();
		addScore(buzzyBeetle.getPointsOnDeath());
		buzzyBeetle.hit();
		
    }
    
	public void visit(Spinny spinny) {
		addScore(spinny.getPointsOnDeath());
		spinny.dead();
	}
	
	public void killEnemySound() {
		observerOfSounds.reproduceSound("stomp");
	}
	
	public void visit(SuperMushroom mushroom){
		int points = characterActualState.getMushroomPoints();
		addScore(points);
		observerOfSounds.reproduceSound("mushroom");
		if(!characterActualState.isSuper()){
			characterActualState = characterStates.get("Super");
			updateBoundingBoxToBig();
			characterAnimations.superAnimation("Normal", "Super");				
		}
		observer.update();
	}

	public void visit(GreenMushroom greenMushroom){
		lives++;
		addScore(greenMushroom.getPoints());
		observerOfSounds.reproduceSound("1-up");
	}

	public void visit(FireFlower flower){		
		int points= characterActualState.getFireFlowerPoints();
		this.characterActualState = characterStates.get("Fire");
		if(characterActualState.isSuper()){
			characterAnimations.superAnimation("Super", "Fire");
		}
		else{
			characterAnimations.superAnimation("Normal", "Fire");
		}		
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
		observerOfSounds.reproduceSound("coin");
		coins++;
	}

	public void visit(Pipe pipe) {}
	
	public void visit(Flag flag) {}
	
	public void visit(Block block) {}

	public void visit(Brick brickBlock) {}

	public void visit(VoidBlock voidBlock) {
		if (downCollision(voidBlock)){
			addScore(-15);
        	dead();
			changeState("Normal");
		}
    }
	
	public void visit(Question questionBlock) {
		if(upCollision(questionBlock)){
		     questionBlock.damage(observerOfSounds);
		}		
	}
	
	public void visit(Mast mast) {
		isInEnd = true;
		setSprite(characterActualState.getSprites().get("InFlag"));
		addScore(Math.round(100 + 25 * mast.getY()));	
		observerOfSounds.reproduceSoundOneIteration("stageClear");
		observer.update();
	}

	public void visit(MastEnd mast) {
		isInEnd = true;
		setSprite(characterActualState.getSprites().get("InFlag"));	
		addScore(Math.round(100 + 25 * mast.getY()));
		observerOfSounds.reproduceSoundOneIteration("stageClear");	
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
    
    public void setObserverOfSound(ObserverSound observer) {
    	observerOfSounds= observer;
    }

    public void setState(String state) {
		this.characterActualState = characterStates.get(state);
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

	public CharacterAnimations getCharacterAnimations(){
		return characterAnimations;
	}

}