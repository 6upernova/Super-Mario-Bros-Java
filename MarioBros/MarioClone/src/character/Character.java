package character;
import java.util.HashMap;
import enemies.*;
import factories.Sprite;
import game.Entity;
import game.CharacterVisitor;
import platforms.*;
import powerUps.*;
import tools.GraphicTools;
import views.ViewConstants;
import views.CharacterObserver;

public class Character extends Entity implements CharacterEntity,CharacterVisitor {
	protected int lives;
	protected int score;
	protected boolean invincible;
	protected CharacterState characterActualState;
	protected HashMap<String,CharacterState> characterStates;
	protected HashMap<String, Sprite> characterInvencibleSprites;
	protected HashMap<String, Sprite> characterSuperInvencibleSprites;

	
	//Gravity And movementd
	protected boolean isInAir;
	protected float verticalSpeed;
	protected float horizontalSpeed;
	private boolean isInEnd;
	private int coins;
	
	public Character(Sprite sprite) {
        super(sprite ,5,0);
		this.score = 0;
		this.lives = 3;
        this.invincible = false;
		this.isInAir = false;
		this.verticalSpeed = 0;
		this.horizontalSpeed = ViewConstants.CHARACTER_SPEED;
		this.isInEnd = false;
		this.coins = 0;
	}

	public void setCharacterStates(HashMap<String,CharacterState> characterStates){
		this.characterStates = characterStates;
		characterActualState = characterStates.get("Normal");

	}
	
	public void moveLeft(String key){
			float worldX = getX();
			setX(GraphicTools.round2Digits(worldX - horizontalSpeed));
			if(!isInAir())
				setSprite(characterActualState.getSprites().get(key));	
			observer.update();
	}

	public void moveRight(String key){
			float worldX = getX();
			setX(GraphicTools.round2Digits(worldX + horizontalSpeed));
			if(!isInAir())
				setSprite(characterActualState.getSprites().get(key));
			observer.update();
	}

	public void applyGravity() {
		if (isInAir){ 
			verticalSpeed += ViewConstants.WORLD_GRAVITY;
			
			//if(verticalSpeed <= ViewConstants.MAX_FALL_SPEED){
			//	verticalSpeed = ViewConstants.MAX_FALL_SPEED;
			//}
			float worldY = getY();
			setY(worldY + (verticalSpeed*0.04f));
			observer.update();
		}
	}
	
	
	public void jump(String key){
		if(!isInAir()){
			verticalSpeed = ViewConstants.CHARACTER_JUMP;
        	isInAir = true;
			setSprite(characterActualState.getSprites().get(key));
        	observer.update();
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
	
	public void dead(){
		lives--;
		setX(5);
		setY(0);
		if(this.lives > 0)
			((CharacterObserver)observer).respawn();
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

	public void endInvencible(){
		this.invincible = false;
	}

	public float getSpeed() {
		return ViewConstants.CHARACTER_SPEED;
	}

	//VISITAS
    public void visit(Goomba goomba) {	
		if(downCollision(goomba)){
			addScore(goomba.getPointsOnDeath());
			goomba.dead();
		}
    }    
    public void visit(KoopaTroopa koopaTroopa) {
		if(downCollision(koopaTroopa)){
			addScore(koopaTroopa.getPointsOnDeath());
			koopaTroopa.dead();
		}
    }    
    public void visit(PiranhaPlant piranhaPlant) {
		if(downCollision(piranhaPlant)){
			addScore(piranhaPlant.getPointsOnDeath());
			piranhaPlant.dead();
		}
    }
    public void visit(Lakitu lakitu) {
		if(downCollision(lakitu)){
			addScore(lakitu.getPointsOnDeath());
			lakitu.dead();
		}
    }
    public void visit(BuzzyBeetle buzzyBeetle) {
		if(downCollision(buzzyBeetle)){
			addScore(buzzyBeetle.getPointsOnDeath());
			buzzyBeetle.dead();
		}
    }
	public void visit(Spiny spiny) {
		if(downCollision(spiny)){
			addScore(spiny.getPointsOnDeath());
			spiny.dead();
		}
	}
	/*
	public void visit(Shell shell) {
		addScore(shell.getPointsOnDeath());
		shell.dead();
		} */
	
	//power ups visits
	public void visit(SuperMushroom mushroom){
		int points = characterActualState.getMushroomPoints();
		characterActualState = characterStates.get("Super");
		updateBoundingBoxToBig();
		addScore(points);

		observer.update();
		//hacer que desaparezca de la pantalla
	}

	public void visit(GreenMushroom greenMushroom){
		lives++;
		addScore(greenMushroom.getPoints());
		//hacer que desaparezca de la pantalla
	}

	public void visit(FireFlower flower){
		int points= characterActualState.getFireFlowerPoints();
		this.characterActualState = characterStates.get("Fire");
		addScore(points);
		observer.update();
	}
	public void visit(Star star){
		if (invincible) {
			addScore(35);
		}
		else addScore(characterActualState.getStarPoints());
		invincible = true;
		observer.update();
	}

	public void visit(Coin coin){
		addScore( coin.getPoints());
		coins++;
		//hacer que desaparezca de la pantalla
	}

	public void updateBoundingBoxToBig(){
		//Set nuevo x,y acorde
		boundingBox.height *= 2;
		boundingBox.updateExternalBoundsToBig();
	}
	public void updateBoundingBoxToSmall(){
		//Set nuevo x,y acorde
		if(boundingBox.height > ViewConstants.CELL_SIZE){
			boundingBox.height /= 2;
			boundingBox.updateExternalBoundsToSmall();
		}
	}

	//platforms
	public void visit(Pipe pipe) {
		isInAir = false;
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
	

}