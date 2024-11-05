package entities.character;
import java.util.HashMap;

import entities.Animations;
import entities.Entity;
import entities.character.characterStates.*;
import entities.enemies.*;
import entities.platforms.*;
import entities.powerUps.*;
import entities.state.question.Question;
import factories.Sprite;
import observer.CharacterObserver;
import observer.SoundObserver;
import tools.GraphicTools;
import views.ViewConstants;

public class Character extends Entity implements CharacterEntity,CharacterVisitor {
	
	private final int HIT_INVINCIBILITY_TIME = 500;
	private final int STAR_INVINCIBILITY_TIME = 6000 ;
	
	protected int lives;
	protected int score;
	protected int coins;
	protected CharacterState characterActualState;
	protected HashMap<String,CharacterState> characterStates;
	protected HashMap<String, Sprite> characterInvincibleSprites;
	protected HashMap<String, Sprite> characterSuperInvincibleSprites;
	protected SoundObserver soundObserver;
	protected float verticalSpeed;
	protected float horizontalSpeed;
	protected boolean isInAir;
	protected boolean isInEnd;
	protected boolean invincible;
	protected boolean invulnerable;
	protected boolean isBusy;
	private Animations characterAnimations;
	private boolean isMovingRight;
	
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
		characterAnimations= new Animations();
	}

	public void setInStart(){	
		setSprite(characterActualState.getSprites().get("StillRight"));
		setX(5);
		setY(0);
		((CharacterObserver)observer).respawn();
	}

	public void setCharacterStates(HashMap<String,CharacterState> characterStates){
		this.characterStates = characterStates;
		characterActualState = characterStates.get("Normal");
	}

	public HashMap<String,CharacterState> getCharacterStates(){
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

	public int getStarInvencibilityTime(){
		return STAR_INVINCIBILITY_TIME;
	}

	
	public int getHitInvencibilityTime(){
		return HIT_INVINCIBILITY_TIME;
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
        	soundObserver.reproduceSound("jump");
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
			soundObserver.reproduceSoundOneIteration("characterDies",0);
			characterAnimations.characterDeathAnimation(this);
		}
		else soundObserver.reproduceSoundOneIteration("gameOver",0);
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
	
	public SoundObserver getSoundObserver(){
		return soundObserver;
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

	public void setInvincible(boolean invincible){
		this.invincible = invincible;
	}

	public float getSpeed() {
		return ViewConstants.CHARACTER_SPEED;
	}

    public void visit(Goomba goomba) {	
		addScore(goomba.getPointsOnDeath());
		goomba.dead();
    }    
    
    public void visit(KoopaTroopa koopaTroopa) {
		addScore(koopaTroopa.getPointsOnDeath());
		koopaTroopa.hit(this);
    }   
    
    public void visit(PiranhaPlant piranhaPlant) {
		addScore(piranhaPlant.getPointsOnDeath());
		this.damaged();
    }	
    
    public void visit(Lakitu lakitu) {
		addScore(lakitu.getPointsOnDeath());
		lakitu.dead();
    }
    
    public void visit(BuzzyBeetle buzzyBeetle) {
		addScore(buzzyBeetle.getPointsOnDeath());
		buzzyBeetle.hit();
		
    }
    
	public void visit(Spiny spinny) {
		if(invincible) {
			addScore(spinny.getPointsOnDeath());
			spinny.dead();
		}
	}
	
	public void visit(SuperMushroom mushroom){
		int points = characterActualState.getMushroomPoints();
		addScore(points);
		soundObserver.reproduceSound("mushroom");
		if(!characterActualState.isSuper()){
			characterActualState = characterStates.get("Super");
			updateBoundingBoxToBig();
			characterAnimations.superAnimation(this,"Normal", "Super");				
		}
		observer.update();
	}

	public void visit(GreenMushroom greenMushroom){
		lives++;
		addScore(greenMushroom.getPoints());
		soundObserver.reproduceSound("1-up");
	}

	public void visit(FireFlower flower){		
		int points= characterActualState.getFireFlowerPoints();
		this.characterActualState = characterStates.get("Fire");
		if(characterActualState.isSuper()){
			characterAnimations.superAnimation(this,"Super", "Fire");
		}
		else{
			characterAnimations.superAnimation(this,"Normal", "Fire");
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
			soundObserver.reproduceSoundOneIteration("starMusic", 3);
		}
		invincible = true;
	}

	public void visit(Coin coin){
		addScore( coin.getPoints());
		soundObserver.reproduceSound("coin");
		coins++;
	}

	public void visit(Pipe pipe) {}
	
	public void visit(Block block) {}

	public void visit(Brick brickBlock) {
		
	}

	public void visit(VoidBlock voidBlock) {
		if (downCollision(voidBlock)){
			addScore(-15);
			dead();
			changeState("Normal");
			updateBoundingBoxToSmall();
		}
    }
	
	public void visit(Question questionBlock) {
		int points = 0;
		if(upCollision(questionBlock)){
			points = questionBlock.damage(soundObserver, this);
		}
		addScore(points);		
	}
	
	
	public void visit(Flag flag) {		
		isInEnd = true;
		setSprite(characterActualState.getSprites().get("InFlag"));
		addScore(Math.round(100 + 25 * flag.getY()));	
		soundObserver.reproduceSoundOneIteration("stageClear",0);
		characterAnimations.characterInFlagAnimation(this, flag);
		observer.update();
	}
	

	public void visit(Mast mast) {
		isInEnd = true;
		setSprite(characterActualState.getSprites().get("InFlag"));
		addScore(Math.round(100 + 25 * mast.getY()));	
		soundObserver.reproduceSoundOneIteration("stageClear",0);
		observer.update();
	}

	public void visit(MastEnd mast) {
		isInEnd = true;
		setSprite(characterActualState.getSprites().get("InFlag"));	
		addScore(Math.round(100 + 25 * mast.getY()));
		soundObserver.reproduceSoundOneIteration("stageClear",0);	
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

	public void setNormalInvincibleSprites(HashMap<String, Sprite> characterInvincibleSprites) {
		this.characterInvincibleSprites = characterInvincibleSprites;
	}
	
	public void setSuperInvincibleSprites(HashMap<String, Sprite> characterSuperInvincibleSprites) {
		this.characterSuperInvincibleSprites = characterSuperInvincibleSprites;
	}

	
	public HashMap<String, Sprite> getNormalInvincibleSprites() {
		return characterInvincibleSprites;
    }
	
    public HashMap<String, Sprite> getSuperInvincibleSprites() {
		return characterSuperInvincibleSprites;
    }

    public void setInEnd(boolean isInEnd) {	
		this.isInEnd = isInEnd;
    }

    public void addCoins(int coins) {
		this.coins += coins;
    }

    public void addLives(int lives) {
		this.lives = lives;
    }
    
    public void setObserverOfSound(SoundObserver observer) {
    	soundObserver= observer;
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

	public Animations getCharacterAnimations(){
		return characterAnimations;
	}

	
}