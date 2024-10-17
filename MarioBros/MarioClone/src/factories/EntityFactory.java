package factories;

import platforms.*;
import platforms.Void;
import powerUps.*;
import views.ViewConstants;
import enemies.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import character.Character;

public class EntityFactory {
	
	protected SpriteFactory spriteFactory;
	
	public EntityFactory(String mode) {
		if( mode == "custom" ) {
		   spriteFactory= new Custom(mode);
		}
		else spriteFactory= new Original(mode);
	}
	
	public Character newCharacter(int worldX, int worldY) {
		Character character= new Character(spriteFactory.getCharacterStillSprite(), spriteFactory.getSpriteMapCharacter());
		return character;
	}

	public Enemy newEnemy(int type, int worldX, int worldY) {
	  Enemy enemy=null;
	  switch (type) {
	         case 2:{
		               enemy= newGoomba(worldX,worldY);
					   break;
	                  }
	         case 3:{ 
      	               enemy= newKoopaTroopa(worldX,worldY);
						 break;
	                  }
	         case 4:{
      	               enemy= newPiranhaPlant(worldX,worldY);
						 break;
	                  }
	         case 5:{
      	               enemy= newLakitu(worldX,worldY);
						 break;
	                  }
	         case 7:{ 
      	               enemy= newBuzzyBeetle(worldX,worldY);
						 break;
                      }
	  }
		return enemy;
	}
	public PowerUp newPowerUp(int type, int worldX, int worldY) {
		PowerUp powerUp=null;
		  switch (type) {
		         case 10:{
			              powerUp= newSuperMushroom(worldX,worldY);
						  break;
		                 }
		         case 11:{
	        	          powerUp= newFireFlower(worldX,worldY);
						  break;
	                     }
		         case 12:{ 
		        	      powerUp= newStar(worldX,worldY);
						  break;
	                     }
		         case 13:{ 
		        	      powerUp= newGreenMushroom(worldX,worldY);
						  break;
		                 }
		         case 14:{
		        	      powerUp= newCoin(worldX,worldY);
						  break;
		                 }
		  }
			return powerUp;
	}
	public Platform newPlatform(int type, int worldX, int worldY) {
		Platform platform=null;
		  switch (type) {
		         case 20:{
			              platform= newBlock(worldX,worldY);
						  break;
		                 }
		         case 21:{ 
		        	      platform= newBrick(worldX,worldY);
						  break;
		                 }
		         case 22:{
	        	          platform= newQuestion(worldX,worldY);
						  break;
	                     }
		         case 23:{ 
	        	          platform= newPipe(worldX,worldY);
						  break;
                         }
		         case 24:{
		        	      platform= newVoid(worldX,worldY);
						  break;
		                 }
		         case 25:{ 
		        	    	platform= newFlag(worldX,worldY);
							break;
	                      }
		  }
			return platform;
	}

	public Character createCharacter(){

		//Preguntar Si se puede hacer de esta manera 
		HashMap<String,Sprite> marioSprites = spriteFactory.getSpriteMapCharacter();
		
        Character character = new Character(marioSprites.get("Still") , marioSprites);
		return character;
	}

	//POWER UPS 
	private PowerUp newSuperMushroom(int worldX, int worldY) {
		SuperMushroom superMushroom = new SuperMushroom(spriteFactory.getSuperMushroomSprite(),worldX,worldY);
	    return superMushroom;
	}
    
	private PowerUp newGreenMushroom(int worldX, int worldY) {
	    GreenMushroom greenMushroom= new GreenMushroom(spriteFactory.getGreenMushroomSprite(),worldX,worldY);
	    return greenMushroom;                   
    }
	
	private PowerUp newStar(int worldX, int worldY) {
	    Star star= new Star(spriteFactory.getStarSprite(),worldX,worldY);
	    return star;
	}
	
	private PowerUp newCoin(int worldX, int worldY) {
	    Coin coin= new Coin(spriteFactory.getCoinSprite(),worldX,worldY );
	    return coin;
	}
	
	private PowerUp newFireFlower(int worldX, int worldY) {
		FireFlower flower= new FireFlower(spriteFactory.getFireFlowerSprite(), worldX,worldY);
	    return flower;
	}
	
	//ENEMYS
	private Enemy newKoopaTroopa(int worldX, int worldY) {
	    KoopaTroopa koopa= new KoopaTroopa(spriteFactory.getKoopaTroopaSprite(),worldX,worldY);
	    return koopa;
	}

	private Enemy newBuzzyBeetle(int worldX, int worldY) {
		BuzzyBeetle beetle= new BuzzyBeetle(spriteFactory.getBuzzyBeetleSprite(),worldX,worldY);
	    return beetle;
	}

	private Enemy newLakitu(int worldX, int worldY) {
		Lakitu lakitu= new Lakitu(spriteFactory.getLakituSprite(),worldX,worldY);
	    return lakitu;
	}

	private Enemy newPiranhaPlant(int worldX, int worldY) {
		PiranhaPlant piranha= new PiranhaPlant(spriteFactory.getPiranhaPlantSprite(),worldX,worldY);
	    return piranha;
	}

	private Enemy newGoomba(int worldX, int worldY) {
		Goomba goomba= new Goomba(spriteFactory.getGoombaSprite(), worldX,worldY);
	    return goomba;
	}
	
    //PLATFORMS
	private Platform newPipe(int worldX, int worldY) {
		Pipe pipe= new Pipe(spriteFactory.getPipeSprite(),worldX,worldY);
	    return pipe;
	}
	
	private Platform newVoid(int worldX, int worldY) {
		Void gameVoid= new Void(spriteFactory.getVoidSprite(), worldX,worldY);
	    return gameVoid;
	}
	
	private Platform newFlag(int worldX, int worldY) {
		Flag flag= new Flag(spriteFactory.getFlagSprite(), worldX,worldY);
	    return flag;
	}
	
	private Platform newQuestion(int worldX, int worldY) {
		Question question= new Question(spriteFactory.getQuestionBlockSprite(),worldX, worldY);
	    return question;
	}
	
	private Platform newBrick(int worldX, int worldY) {
		Brick brick= new Brick(spriteFactory.getBrickSprite(),worldX,worldY);
	    return brick;
	}
	
	private Platform newBlock(int worldX, int worldY) {
		Block block= new Block(spriteFactory.getBlockSprite(),worldX,worldY);
	    return block;
	}
	
}