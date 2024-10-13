package factories;

import enemies.Goomba;
import game.Entity;
import platforms.*;
import platforms.Void;
import powerUps.*;
import enemies.*;

public class EntityFactory {
	protected SpriteFactory spriteFactory;
	
	public EntityFactory(String direction) {
		if( direction == "custom" ) {
		   spriteFactory= new Custom(direction);
		}
		else spriteFactory= new Original(direction);
	}
	
	public Entity createEntity(int type,int worldX, int worldY) {
        //SEGUN EL TIPO QUE ES CREA CON LA ENTITY
        Entity entity = null;
        if( type>1 && type<9 )
            entity= newEnemy(type,worldX,worldY);
                    
        if( type>9 && type<15 )
            entity= newPowerUp(type,worldX,worldY);
                    
        if( type>19 && type<25 )
            entity= newPlatform(type,worldX,worldY);
        return entity;
    }

	private Entity newEnemy(int type, int worldX, int worldY) {
	  Entity enemy=null;
	  switch (type) {
	         case 2:{
		               enemy= newGoomba(worldX,worldY);
	                  }
	         case 3:{ 
      	               enemy= newKoopaTroopa(worldX,worldY);
	                  }
	         case 4:{
      	               enemy= newPiranhaPlant(worldX,worldY);
	                  }
	         case 5:{
      	               enemy= newLakitu(worldX,worldY);
	                  }
	         case 7:{ 
      	               enemy= newBuzzyBeetle(worldX,worldY);
                      }
	  }
		return enemy;
	}
	public Entity newPowerUp(int type, int worldX, int worldY) {
		Entity powerUp=null;
		  switch (type) {
		         case 10:{
			              powerUp= newSuperMushroom(worldX,worldY);
		                 }
		         case 11:{
	        	          powerUp= newFireFlower(worldX,worldY);
	                     }
		         case 12:{ 
		        	      powerUp= newStar(worldX,worldY);
	                     }
		         case 13:{ 
		        	      powerUp= newGreenMushroom(worldX,worldY);
		                 }
		         case 14:{
		        	      powerUp= newCoin(worldX,worldY);
		                 }
		  }
			return powerUp;
	}
	public Entity newPlatform(int type, int worldX, int worldY) {
		Entity platform=null;
		  switch (type) {
		         case 20:{
			              platform= newBlock(worldX,worldY);
		                 }
		         case 21:{ 
		        	      platform= newBrick(worldX,worldY);
		                 }
		         case 22:{
	        	          platform= newQuestion(worldX,worldY);
	                     }
		         case 23:{ 
	        	          platform= newPipe(worldX,worldY);
                         }
		         case 24:{
		        	      platform= newVoid(worldX,worldY);
		                 }
		         case 25:{ 
		        	       platform= newFlag(worldX,worldY);
	                      }
		  }
			return platform;
	}
	//POWER UPS 
	private Entity newSuperMushroom(int worldX, int worldY) {
		SuperMushroom superMushroom = new SuperMushroom(spriteFactory.getSuperMushroomSprite(),worldX,worldY);
	    return superMushroom;
	}
    
	private Entity newGreenMushroom(int worldX, int worldY) {
	    GreenMushroom greenMushroom= new GreenMushroom(spriteFactory.getGreenMushroomSprite(),worldX,worldY);
	    return greenMushroom;                   
    }
	
	private Entity newStar(int worldX, int worldY) {
	    Star star= new Star(spriteFactory.getStarSprite(),worldX,worldY);
	    return star;
	}
	
	private Entity newCoin(int worldX, int worldY) {
	    Coin coin= new Coin(spriteFactory.getCoinSprite(),worldX,worldY );
	    return coin;
	}
	
	private Entity newFireFlower(int worldX, int worldY) {
		FireFlower flower= new FireFlower(spriteFactory.getFireFlowerSprite(), worldX,worldY);
	    return flower;
	}
	//ENEMYS
	private Entity newKoopaTroopa(int worldX, int worldY) {
	    KoopaTroopa koopa= new KoopaTroopa(spriteFactory.getKoopaTroopaSprite(),worldX,worldY);
	    return koopa;
	}

	private Entity newBuzzyBeetle(int worldX, int worldY) {
		BuzzyBeetle beetle= new BuzzyBeetle(spriteFactory.getBuzzyBeetleSprite(),worldX,worldY);
	    return beetle;
	}

	private Entity newLakitu(int worldX, int worldY) {
		Lakitu lakitu= new Lakitu(spriteFactory.getLakituSprite(),worldX,worldY);
	    return lakitu;
	}

	private Entity newPiranhaPlant(int worldX, int worldY) {
		PiranhaPlant piranha= new PiranhaPlant(spriteFactory.getPiranhaPlantSprite(),worldX,worldY);
	    return piranha;
	}

	private Entity newGoomba(int worldX, int worldY) {
		Goomba goomba= new Goomba(spriteFactory.getGoombaSprite(), worldX,worldY);
	    return goomba;
	}
    //PLATFORMS
	private Entity newPipe(int worldX, int worldY) {
		Pipe pipe= new Pipe(spriteFactory.getPipeSprite(),worldX,worldY);
	    return pipe;
	}
	
	private Entity newVoid(int worldX, int worldY) {
		Void gameVoid= new Void(spriteFactory.getVoidSprite(), worldX,worldY);
	    return gameVoid;
	}
	
	private Entity newFlag(int worldX, int worldY) {
		Flag flag= new Flag(spriteFactory.getFlagSprite(), worldX,worldY);
	    return flag;
	}
	
	private Entity newQuestion(int worldX, int worldY) {
		Question question= new Question(spriteFactory.getQuestionBlockSprite(),worldX,worldY);
	    return question;
	}
	
	private Entity newBrick(int worldX, int worldY) {
		Brick brick= new Brick(spriteFactory.getBrickSprite(),worldX,worldY);
	    return brick;
	}
	
	private Entity newBlock(int worldX, int worldY) {
		Block block= new Block(spriteFactory.getBlockSprite(),worldX,worldY);
	    return block;
	}
	
}