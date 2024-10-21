package factories;
import platforms.*;
import platforms.VoidBlock;
import powerUps.*;
import enemies.*;
import java.util.HashMap;
import character.Character;

public class EntityFactory {
	
	protected SpriteFactory spriteFactory;
	
	public EntityFactory(String mode) {
		if( mode == "custom" ) {
		   this.spriteFactory= new Custom(mode);
		}
		else this.spriteFactory= new Original(mode);
	}
	
	public Enemy newEnemy(int type, int worldX, int worldY) {
	  	Enemy enemy = null;
	  	switch (type) {
	         case 2:	enemy = newGoomba(worldX,worldY);
					   	break;  
	         case 3:    enemy = newKoopaTroopa(worldX,worldY);
						break;
	         case 4:    enemy = newPiranhaPlant(worldX,worldY);
						break;
	         case 5:    enemy = newLakitu(worldX,worldY);
						break;
	         case 7:    enemy = newBuzzyBeetle(worldX,worldY);
						break;
	  	}
		return enemy;
	}
	
	public PowerUp newPowerUp(int type, int worldX, int worldY) {
		PowerUp powerUp = null;
		switch (type){
		    case 10:	powerUp = newSuperMushroom(worldX,worldY);
						break;
		    case 11:	powerUp = newFireFlower(worldX,worldY);
						break;
		    case 12:	powerUp = newStar(worldX,worldY);
						break;						
		    case 13:	powerUp = newGreenMushroom(worldX,worldY);
						break;						
		    case 14:	powerUp = newCoin(worldX,worldY);
						break;						
		}
		return powerUp;
	}
	
	public Platform newPlatform(int type, int worldX, int worldY) {
		Platform platform=null;
		switch (type){
		    case 20:	platform = newBlock(worldX,worldY);
						break; 
		    case 21: 	platform = newBrick(worldX,worldY);
						break;		                 
		    case 22:	platform = newQuestion(worldX,worldY);
						break;	                     
		    case 23:	platform = newPipe(worldX,worldY);
						break;                         
		    case 24:  	platform = newVoid(worldX,worldY);
						break;
		    case 25:	platform = newFlag(worldX,worldY);
						break;               
		}
		return platform;
	}

	public Character createCharacter(){
		//Preguntar Si se puede hacer de esta manera 
        Character character = new Character(spriteFactory.getCharacterStillSprite("Right"));
		character.setNormalSprites(characterSprites());
		character.setSuperSprites(characterSuperSprites());
		character.setFireSprites(characterFireSprites());
		character.setNormalInvencibleSprites(characterInvencibleSprites());
		character.setSuperInvencibleSprites(characterSuperInvencibleSprites());
		character.setFireInvencibleSprites(characterFireInvencibleSprites());
		return character;
	}	

	private HashMap<String, Sprite> characterSprites() {
		HashMap<String,Sprite> characterSprites = new HashMap<String,Sprite>();
		characterSprites.put("StillLeft",spriteFactory.getCharacterStillSprite("Left"));
		characterSprites.put("StillRight",spriteFactory.getCharacterStillSprite("Right"));
		characterSprites.put("Left1",spriteFactory.getCharacterLeftSprite(1));
		characterSprites.put("Left2", spriteFactory.getCharacterLeftSprite(2));
		characterSprites.put("Left3",spriteFactory.getCharacterLeftSprite(3));
		characterSprites.put("Right1",spriteFactory.getCharacterRightSprite(1));
		characterSprites.put("Right2", spriteFactory.getCharacterRightSprite(2));
		characterSprites.put("Right3",spriteFactory.getCharacterRightSprite(3));
		characterSprites.put("JumpingRight",spriteFactory.getCharacterJumpingSprite("Right"));
		characterSprites.put("JumpingLeft",spriteFactory.getCharacterJumpingSprite("Left"));
		return characterSprites;
	}

	private HashMap<String, Sprite> characterSuperSprites() {
		HashMap<String,Sprite> characterSuperSprites = new HashMap<String,Sprite>();
		characterSuperSprites.put("StillLeft",spriteFactory.getSuperCharacterStillSprite("Left"));
		characterSuperSprites.put("StillRight",spriteFactory.getSuperCharacterStillSprite("Right"));
		characterSuperSprites.put("Left1",spriteFactory.getSuperCharacterLeftSprite(1));
		characterSuperSprites.put("Left2", spriteFactory.getSuperCharacterLeftSprite(2));
		characterSuperSprites.put("Left3",spriteFactory.getSuperCharacterLeftSprite(3));
		characterSuperSprites.put("Right1",spriteFactory.getSuperCharacterRightSprite(1));
		characterSuperSprites.put("Right2", spriteFactory.getSuperCharacterRightSprite(2));
		characterSuperSprites.put("Right3",spriteFactory.getSuperCharacterRightSprite(3));
		characterSuperSprites.put("JumpingRight",spriteFactory.getSuperCharacterJumpingSprite("Right"));
		characterSuperSprites.put("JumpingLeft",spriteFactory.getSuperCharacterJumpingSprite("Left"));
		return characterSuperSprites;
	}
	
	private HashMap<String, Sprite> characterFireSprites() {
		HashMap<String,Sprite> characterFireSprites = new HashMap<String,Sprite>();
		characterFireSprites.put("StillLeft",spriteFactory.getFireCharacterStillSprite("Left"));
		characterFireSprites.put("StillRight",spriteFactory.getFireCharacterStillSprite("Right"));
		characterFireSprites.put("Left1",spriteFactory.getFireCharacterLeftSprite(1));
		characterFireSprites.put("Left2", spriteFactory.getFireCharacterLeftSprite(2));
		characterFireSprites.put("Left3",spriteFactory.getFireCharacterLeftSprite(3));
		characterFireSprites.put("Right1",spriteFactory.getFireCharacterRightSprite(1));
		characterFireSprites.put("Right2", spriteFactory.getFireCharacterRightSprite(2));
		characterFireSprites.put("Right3",spriteFactory.getFireCharacterRightSprite(3));
		characterFireSprites.put("JumpingRight",spriteFactory.getFireCharacterJumpingSprite("Right"));
		characterFireSprites.put("JumpingLeft",spriteFactory.getFireCharacterJumpingSprite("Left"));
		return characterFireSprites;
	}
	
	private HashMap<String, Sprite> characterInvencibleSprites() {
		HashMap<String,Sprite> characterSprites = new HashMap<String,Sprite>();
		characterSprites.put("StillLeft",spriteFactory.		getCharacterInvencibleStillSprite("Left"));
		characterSprites.put("StillRight",spriteFactory.	getCharacterInvencibleStillSprite("Right"));
		characterSprites.put("Left1",spriteFactory.			getCharacterInvencibleLeftSprite(1));
		characterSprites.put("Left2", spriteFactory.		getCharacterInvencibleLeftSprite(2));
		characterSprites.put("Left3",spriteFactory.			getCharacterInvencibleLeftSprite(3));
		characterSprites.put("Right1",spriteFactory.		getCharacterInvencibleRightSprite(1));
		characterSprites.put("Right2", spriteFactory.		getCharacterInvencibleRightSprite(2));
		characterSprites.put("Right3",spriteFactory.		getCharacterInvencibleRightSprite(3));
		characterSprites.put("JumpingRight",spriteFactory.	getCharacterInvencibleJumpingSprite("Right"));
		characterSprites.put("JumpingLeft",spriteFactory.	getCharacterInvencibleJumpingSprite("Left"));
		return characterSprites;
	}

	private HashMap<String, Sprite> characterSuperInvencibleSprites() {
		HashMap<String,Sprite> characterSuperSprites = new HashMap<String,Sprite>();
		characterSuperSprites.put("StillLeft",spriteFactory.	getSuperCharacterInvencibleStillSprite("Left"));
		characterSuperSprites.put("StillRight",spriteFactory.	getSuperCharacterInvencibleStillSprite("Right"));
		characterSuperSprites.put("Left1",spriteFactory.		getSuperCharacterInvencibleLeftSprite(1));
		characterSuperSprites.put("Left2", spriteFactory.		getSuperCharacterInvencibleLeftSprite(2));
		characterSuperSprites.put("Left3",spriteFactory.		getSuperCharacterInvencibleLeftSprite(3));
		characterSuperSprites.put("Right1",spriteFactory.		getSuperCharacterInvencibleRightSprite(1));
		characterSuperSprites.put("Right2", spriteFactory.		getSuperCharacterInvencibleRightSprite(2));
		characterSuperSprites.put("Right3",spriteFactory.		getSuperCharacterInvencibleRightSprite(3));
		characterSuperSprites.put("JumpingRight",spriteFactory.	getSuperCharacterInvencibleJumpingSprite("Right"));
		characterSuperSprites.put("JumpingLeft",spriteFactory.	getSuperCharacterInvencibleJumpingSprite("Left"));
		return characterSuperSprites;
	}
	
	private HashMap<String, Sprite> characterFireInvencibleSprites() {
		HashMap<String,Sprite> characterFireSprites = new HashMap<String,Sprite>();
		characterFireSprites.put("StillLeft",spriteFactory.		getFireCharacterInvencibleStillSprite("Left"));
		characterFireSprites.put("StillRight",spriteFactory.	getFireCharacterInvencibleStillSprite("Right"));
		characterFireSprites.put("Left1",spriteFactory.			getFireCharacterInvencibleLeftSprite(1));
		characterFireSprites.put("Left2", spriteFactory.		getFireCharacterInvencibleLeftSprite(2));
		characterFireSprites.put("Left3",spriteFactory.			getFireCharacterInvencibleLeftSprite(3));
		characterFireSprites.put("Right1",spriteFactory.		getFireCharacterInvencibleRightSprite(1));
		characterFireSprites.put("Right2", spriteFactory.		getFireCharacterInvencibleRightSprite(2));
		characterFireSprites.put("Right3",spriteFactory.		getFireCharacterInvencibleRightSprite(3));
		characterFireSprites.put("JumpingRight",spriteFactory.	getFireCharacterInvencibleJumpingSprite("Right"));
		characterFireSprites.put("JumpingLeft",spriteFactory.	getFireCharacterInvencibleJumpingSprite("Left"));
		return characterFireSprites;
	}
	
	
	//POWER UPS 
	private PowerUp newSuperMushroom(int worldX, int worldY) {
		SuperMushroom superMushroom = new SuperMushroom(spriteFactory.getSuperMushroomSprite(),worldX,worldY);
	    return superMushroom;
	}
    
	private PowerUp newGreenMushroom(int worldX, int worldY) {
	    GreenMushroom greenMushroom = new GreenMushroom(spriteFactory.getGreenMushroomSprite(),worldX,worldY);
	    return greenMushroom;                   
    }
	
	private PowerUp newStar(int worldX, int worldY) {
	    Star star = new Star(spriteFactory.getStarSprite(),worldX,worldY);
	    return star;
	}
	
	private PowerUp newCoin(int worldX, int worldY) {
	    Coin coin = new Coin(spriteFactory.getCoinSprite(),worldX,worldY );
	    return coin;
	}
	
	private PowerUp newFireFlower(int worldX, int worldY) {
		FireFlower flower = new FireFlower(spriteFactory.getFireFlowerSprite(), worldX,worldY);
	    return flower;
	}
	
	//ENEMYS
	private Enemy newKoopaTroopa(int worldX, int worldY) {
	    KoopaTroopa koopa = new KoopaTroopa(spriteFactory.getKoopaTroopaSprite(),worldX,worldY);
	    return koopa;
	}

	private Enemy newBuzzyBeetle(int worldX, int worldY) {
		BuzzyBeetle beetle = new BuzzyBeetle(spriteFactory.getBuzzyBeetleSprite(),worldX,worldY);
	    return beetle;
	}

	private Enemy newLakitu(int worldX, int worldY) {
		Lakitu lakitu = new Lakitu(spriteFactory.getLakituSprite(),worldX,worldY);
	    return lakitu;
	}

	private Enemy newPiranhaPlant(int worldX, int worldY) {
		PiranhaPlant piranha = new PiranhaPlant(spriteFactory.getPiranhaPlantSprite(),worldX,worldY);
	    return piranha;
	}

	private Enemy newGoomba(int worldX, int worldY) {
		Goomba goomba = new Goomba(spriteFactory.getGoombaSprite(), worldX,worldY);
	    return goomba;
	}
	
    //PLATFORMS
	private Platform newPipe(int worldX, int worldY) {
		Pipe pipe = new Pipe(spriteFactory.getPipeSprite(),worldX,worldY);
	    return pipe;
	}
	
	private Platform newVoid(int worldX, int worldY) {
		VoidBlock gameVoid = new VoidBlock(spriteFactory.getVoidSprite(), worldX,worldY);
	    return gameVoid;
	}
	
	private Platform newFlag(int worldX, int worldY) {
		Flag flag = new Flag(spriteFactory.getFlagSprite(), worldX,worldY);
	    return flag;
	}
	
	private Platform newQuestion(int worldX, int worldY) {
		Question question = new Question(spriteFactory.getQuestionBlockSprite(),worldX, worldY);
	    return question;
	}
	
	private Platform newBrick(int worldX, int worldY) {
		Brick brick = new Brick(spriteFactory.getBrickSprite(),worldX,worldY);
	    return brick;
	}
	
	private Platform newBlock(int worldX, int worldY) {
		Block block = new Block(spriteFactory.getBlockSprite(),worldX,worldY);
	    return block;
	}
}