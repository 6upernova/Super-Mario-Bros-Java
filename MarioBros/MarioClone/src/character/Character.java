package character;
import java.util.HashMap;
import enemies.*;
import factories.Sprite;
import game.BoundingBox;
import game.Entity;
import game.Visitor;
import platforms.*;
import powerUps.*;
import views.GraphicObserver;
import views.ViewConstants;

public class Character extends Entity implements CharacterEntity,Visitor {
	
	protected int lives;
	protected int score;
	protected boolean invincible;
	protected CharacterState characterState;
	protected String actualState; //Variable de uso provisional (eliminar cuando esten las colisiones)
	protected HashMap<String, Sprite> sprites;
	protected HashMap<String, Sprite> superSprites;
	protected HashMap<String, Sprite> fireSprites;
	protected HashMap<String, Sprite> characterInvencibleSprites;
	protected HashMap<String, Sprite> characterSuperInvencibleSprites;
	protected HashMap<String, Sprite> characterFireInvencibleSprites;
	//Gravity And movementd
	protected boolean isInAir;
	protected float verticalSpeed;
	protected float horizontalSpeed;
	
	public Character(Sprite sprite) {
<<<<<<< HEAD
        super(sprite ,5,0);
=======
        super(sprite ,120,1);
>>>>>>> master
        this.actualState = "Normal";
		this.score = 0;
		this.lives = 3;
        this.invincible = false;
		this.isInAir = false;
		this.verticalSpeed = 0;
		this.horizontalSpeed = ViewConstants.CHARACTER_SPEED;
		this.characterState = new NormalState(this);
	}
	
	public void moveLeft(String key){
			float worldX = getX();
			setX(round2Digits(worldX - horizontalSpeed));
			if(!isInAir())
				setSprite(characterState.getSprites().get(key));	
			observer.update();
	}
	public void moveRight(String key){
			float worldX = getX();
			setX(round2Digits(worldX + horizontalSpeed));
			if(!isInAir())
				setSprite(characterState.getSprites().get(key));
			observer.update();
	}
	public void applyGravity() {
		if (isInAir) {
			verticalSpeed -= ViewConstants.WORLD_GRAVITY ; 
			float worldY = getY();
			if(worldY + verticalSpeed <= 0){
				setY(0);
			}
			else{
				setY(worldY + verticalSpeed); 
			}
			
			
			if (isOnSolid()) {
				isInAir = false;
				verticalSpeed = 0;
				horizontalSpeed = ViewConstants.CHARACTER_SPEED; 
			}
		}
		
	}	
	public void jump(String key){
		if(!isInAir()){
			verticalSpeed = ViewConstants.CHARACTER_JUMP;
        	isInAir = true;
			setSprite(characterState.getSprites().get(key));
        	observer.update();
		}
		
	}

	public void stayStill(String key){
		if(!isInAir())
			setSprite(characterState.getSprites().get(key));
		observer.update();
	}

	private boolean isOnSolid(){
		//Metodo provisional hasta definir lo de las colisiones es decir hay que comprobar 
		return getY()<=0;
	}

	public boolean isInAir(){
		return isInAir;
	}

	private float round2Digits(float number){
		return Math.round(number * 100.0) / 100.0f;
	}
	
	public void dead(){
		lives--;
		//animation.dead();
	}
	
	///////////////////////////////////////////////////
    protected void changeState(CharacterState state) {
		this.characterState = state;
    }
	
	public void damaged() {
	}
    ///////////////////////////////////////////////////
	
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

	public void endInvencible(){
		this.invincible = false;
	}

	public float getSpeed() {
		return ViewConstants.CHARACTER_SPEED;
	}

	//VISITAS
    public void visit(Goomba goomba) {
		if(leftCollision(goomba) || rightCollision(goomba)){
			System.out.println("colision de costado");
			characterState.damaged();
		}		
		if(downCollision(goomba)){
			addScore(goomba.getPointsOnDeath());
			goomba.dead();
		}
    }    
    public void visit(KoopaTroopa koopaTroopa) {
		if(leftCollision(koopaTroopa) || rightCollision(koopaTroopa)){
			characterState.damaged();
		}		
		if(downCollision(koopaTroopa)){
			addScore(koopaTroopa.getPointsOnDeath());
			koopaTroopa.dead();
		}
    }    
    public void visit(PiranhaPlant piranhaPlant) {
		if(leftCollision(piranhaPlant) || rightCollision(piranhaPlant)){
			characterState.damaged();
		}		
		if(downCollision(piranhaPlant)){
			addScore(piranhaPlant.getPointsOnDeath());
			piranhaPlant.dead();
		}
    }
    public void visit(Lakitu lakitu) {
		if(leftCollision(lakitu) || rightCollision(lakitu)){
			characterState.damaged();
		}		
		if(downCollision(lakitu)){
			addScore(lakitu.getPointsOnDeath());
			lakitu.dead();
		}
    }
    public void visit(BuzzyBeetle buzzyBeetle) {
		if(leftCollision(buzzyBeetle) || rightCollision(buzzyBeetle)){
			characterState.damaged();
		}		
		if(downCollision(buzzyBeetle)){
			addScore(buzzyBeetle.getPointsOnDeath());
			buzzyBeetle.dead();
		}
    }
	public void visit(Spiny spiny) {
		if(leftCollision(spiny) || rightCollision(spiny)){
			characterState.damaged();
		}		
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
	//Visits
	//power ups
	public void visit(SuperMushroom mushroom){
		actualState="Super";
		int points= mushroom.getPoints();
		System.out.println("aumento");
		characterState = new SuperState(this);
		points = points + 40;
		addScore(points);
<<<<<<< HEAD
=======
		//setY(positionInY+1);
>>>>>>> master
		updateBoundingBoxToBig();
		//System.out.println(isOnSolid());
		observer.update();
		//hacer que desaparezca de la pantalla
	}

	public void visit(GreenMushroom greenMushroom){
		System.out.println("old score: "+lives);
		lives++;
		addScore( greenMushroom.getPoints());
		System.out.println("new score: "+lives);
	//hacer que desaparezca de la pantalla
	}

	public void visit(FireFlower flower){
		actualState="Fire";
		int points= flower.getPoints();
		this.characterState = new FireState(this);
		addScore(points);
		updateBoundingBoxToBig();
		//System.out.println(isOnSolid());
		observer.update();
	}
	public void visit(Star star){
		if (invincible) {
			addScore(35);
		}
		else addScore(characterState.getStarPoints());
		invincible = true;
		observer.update();
	}

	public void visit(Coin coin){
		System.out.println("old score: "+score);
		addScore( coin.getPoints());
		System.out.println("new score: "+score);
		//hacer que desaparezca de la pantalla
	}

	private void updateBoundingBoxToBig(){
		//Set nuevo x,y acorde
		boundingBox.height = 2 * boundingBox.height;	
	}

	//platforms
	public void visit(Block block) {

	}
	public void visit(Pipe pipe) {
		if(boundingBox.leftCollision(pipe.getBoundingBox()) || boundingBox.rightCollision(pipe.getBoundingBox())){
		}
		//System.out.println("visita pipe");
	}
	public void visit(Flag flag) {
		System.out.println("visita a la flag");
	}
	public void visit(VoidBlock voidBlock) {
		subtractScore(15);
		/*si todavia tiene vidas
		resetea el nivel
		sino muere 
		*/
        dead();
    }
	public void visit(Brick brickBlock) {
		/*
		
		if (boundingBox.upCollision(brickBlock.getBoundingBox())) {
			setVerticalSpeed(0);
			positionInY = brickBlock.getY() + (float) boundingBox.getHeight();
		}
		if(boundingBox.downCollision(brickBlock.getBoundingBox())){
			setVerticalSpeed(0);
			positionInY = brickBlock.getY() - (float) boundingBox.getHeight();

		}
		if(boundingBox.leftCollision(brickBlock.getBoundingBox())){
			setHorizontalSpeed(0);
			positionInX = brickBlock.getX() + (float) brickBlock.getBoundingBox().getWidth();
		}
		if(boundingBox.rightCollision(brickBlock.getBoundingBox())){
			setHorizontalSpeed(0);
			positionInX = brickBlock.getX() - (float) brickBlock.getBoundingBox().getWidth();
		}
		observer.update();
		*/
	}
	public void visit(Question voidBlock) {

	}
	public void visit(Mast mast) {

	}
	public void visit(MastEnd mast) {

	}

	public void setObserver(GraphicObserver observer) {
		this.observer = observer;
		observer.update();
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

	public void setNormalSprites(HashMap<String, Sprite> characterSprites) {
		this.sprites = characterSprites;
	}
	public void setSuperSprites(HashMap<String, Sprite> characterSuperSprites) {
		this.superSprites = characterSuperSprites;
	}
	public void setFireSprites(HashMap<String, Sprite> characterFireSprites) {
		this.fireSprites = characterFireSprites;
	}
	public void setNormalInvencibleSprites(HashMap<String, Sprite> characterInvencibleSprites) {
		this.characterInvencibleSprites = characterInvencibleSprites;
	}
	public void setSuperInvencibleSprites(HashMap<String, Sprite> characterSuperInvencibleSprites) {
		this.characterSuperInvencibleSprites = characterSuperInvencibleSprites;
	}
	public void setFireInvencibleSprites(HashMap<String, Sprite> characterInvencibleFireSprites) {
		this.characterFireInvencibleSprites = characterInvencibleFireSprites;
	}

	public HashMap<String, Sprite> getNormalSprites() {
		return sprites;
    }
    public HashMap<String, Sprite> getSuperSprites() {
		return superSprites;
    }
	public HashMap<String, Sprite> getFireSprites() {
		return fireSprites;
	}
	public HashMap<String, Sprite> getNormalInvencibleSprites() {
		return characterInvencibleSprites;
    }
    public HashMap<String, Sprite> getSuperInvencibleSprites() {
		return characterSuperInvencibleSprites;
    }
	public HashMap<String, Sprite> getFireInvencibleSprites() {
		return characterFireInvencibleSprites;
	}
}