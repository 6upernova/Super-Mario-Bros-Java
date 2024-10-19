package character;

import java.util.HashMap;
import enemies.*;
import factories.Sprite;
import game.Entity;
import game.VisitedElement;
import game.Visitor;
import platforms.*;
import powerUps.*;
import views.GraphicObserver;
import views.ViewConstants;

public class Character extends Entity implements CharacterEntity,Visitor {
	
	protected int lives;
	protected int score;
	protected boolean invincible;
	protected CharacterState actualState;
	protected HashMap<String, Sprite> sprites;

	

	//Gravity And movementd
	protected boolean isInAir;
	protected float verticalSpeed;
	protected float horizontalSpeed;

	
	
	public Character(Sprite sprite, HashMap<String,Sprite> sprites) {
        super(sprite ,5,1);
		this.sprites = sprites;
		this.score=0;
		this.lives=3;
        this.invincible= false;
		this.isInAir = false;
		this.verticalSpeed = 0;
		this.horizontalSpeed = ViewConstants.CHARACTER_SPEED;
	}

	
	public void moveLeft(String key){
		float worldX = getX();
	    setX(round2Digits(worldX - horizontalSpeed));
		if(!isInAir())
			setSprite(sprites.get(key));	
		observer.update();
		updateHitboxCoords();
	}
	
	public void moveRight(String key){
        float worldX = getX();
	    setX(round2Digits(worldX + horizontalSpeed));
		if(!isInAir())
			setSprite(sprites.get(key));
		observer.update();
		updateHitboxCoords();
	}
	
	public void applyGravity() {
		if (isInAir) {
			verticalSpeed -= ViewConstants.WORLD_GRAVITY ; 
			float worldY = getY();
			setY(worldY + verticalSpeed); 
			
			
			
			if (isOnSolid()) {
				isInAir = false;
				verticalSpeed = 0;
				horizontalSpeed = ViewConstants.CHARACTER_SPEED; 
			}
		}
	}
	
	public void jump(String key){
		if(!isInAir() && isOnSolid()){
			verticalSpeed = ViewConstants.CHARACTER_JUMP;
			horizontalSpeed -= 0.1f;
        	isInAir = true;
			setSprite(sprites.get(key));
        	observer.update();
		}
		updateHitboxCoords();
	}

	public void stayStill(String key){
		if(!isInAir())
			setSprite(sprites.get(key));
		observer.update();
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

	//VISITAS
    public void visit(Goomba goomba) {
    addScore(goomba.getPointsOnDeath());
    goomba.dead();
    }    
    public void visit(KoopaTroopa koopaTroopa) {
    addScore(koopaTroopa.getPointsOnDeath());
    koopaTroopa.dead();
    }    
    public void visit(PiranhaPlant piranhaPlant) {
    addScore(piranhaPlant.getPointsOnDeath());
    piranhaPlant.dead();
    }
    public void visit(Lakitu lakitu) {
    addScore(lakitu.getPointsOnDeath());
    lakitu.dead();
    }
    public void visit(BuzzyBeetle buzzyBeetle) {
    addScore(buzzyBeetle.getPointsOnDeath());
    buzzyBeetle.dead();
    }
	public void visit(Spiny spiny) {
		addScore(spiny.getPointsOnDeath());
		spiny.dead();
		}
	/*
	public void visit(Shell shell) {
		addScore(shell.getPointsOnDeath());
		shell.dead();
		} */
	//Visits
	//power ups
	public void visit(SuperMushroom mushroom) {
	//actualState= stateList[1];
	int points= mushroom.getPoints();
	System.out.println("aumento");

	/*
	if (actualState.getName() == "Super")
	points = points + 40;
	addScore( points );

	*/
	//hacer que desaparezca de la pantalla
	}
	public void visit(GreenMushroom greenMushroom) {
	lives++;
	addScore( greenMushroom.getPoints() );
	//hacer que desaparezca de la pantalla
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
	public void visit(Star star) {
	int points= star.getPoints();
	if (invincible)
	points = points + 15;
	addScore( points );
	//hacer que desaparezca de la pantalla
	invincible = true;
	}
		public void visit(Coin coin) {
		addScore( coin.getPoints() );
	//hacer que desaparezca de la pantalla
		}
	
	//platforms
	public void visit(Block block) {
		}
	public void visit(Pipe pipe) {
		
	}
	public void visit(Flag flag) {
		}
	public void visit(VoidBlock voidBlock) {
		subtractScore(15);
	/*si todavia tiene vidas
	resetea el nivel
	sino muere 
	*/
        dead();
    }

	public void visit(Brick voidBlock) {

	}

	public void visit(Question voidBlock) {

	}
	public void setObserver(GraphicObserver observer) {
		this.observer = observer;
	}
}