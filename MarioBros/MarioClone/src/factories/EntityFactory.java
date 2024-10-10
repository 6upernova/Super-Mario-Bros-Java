package factories;

import java.nio.channels.Pipe;

import enemies.Goomba;
import game.Entity;
import powerUps.Mushroom;

public class EntityFactory {
	
	protected SpriteFactory spriteFactory;
	
	public EntityFactory(String direction) {
		if( direction == "custom" ) {
		   spriteFactory= new Custom(direction);
		}
		else spriteFactory= new Original(direction);
	}

	public Entity newEnemy(char subType, int worldX, int worldY) {
	  Entity enemy=null;
	  switch (subType) {
	         case 'G':{
		               enemy= newGoomba(worldX,worldY);
	                  }
	         case 'P':{ 
	        	       enemy= newPiranhaPlant(worldX,worldY);
	                  }
	         case 'L':{
	        	       enemy= newLakitu(worldX,worldY);
	                  }
	         case 'B':{
	        	       enemy= newBuzzyBeetle(worldX,worldY);
	                  }
	         case 'K':{ 
	        	       enemy= newKoopaTroopa(worldX,worldY);
                      }
	  }
		return enemy;
	}
	public Entity newPowerUp(char subType, int worldX, int worldY) {
		Entity powerUp=null;
		  switch (subType) {
		         case 'M':{
			               powerUp= newMushroom(worldX,worldY);
		                  }
		         case 'G':{ 
		        	       powerUp= newGreenMushroom(worldX,worldY);
		                  }
		         case 'F':{
		        	       powerUp= newFireFlower(worldX,worldY);
		                  }
		         case 'C':{
		        	       powerUp= newCoin(worldX,worldY);
		                  }
		         case 'S':{ 
		        	       powerUp= newStar(worldX,worldY);
	                      }
		  }
			return powerUp;
	}
	public Entity newPlatform(char subType, int worldX, int worldY) {
		Entity platform=null;
		  switch (subType) {
		         case 'S':{
			               platform= newSolid(worldX,worldY);
		                  }
		         case 'B':{ 
		        	       platform= newBrick(worldX,worldY);
		                  }
		         case 'V':{
		        	       platform= newVoid(worldX,worldY);
		                  }
		         case 'Q':{
		        	       platform= newQuestion(worldX,worldY);
		                  }
		         case 'F':{ 
		        	       platform= newFlag(worldX,worldY);
	                      }
		         case 'P':{ 
	        	           platform= newPipe(worldX,worldY);
                          }
		  }
			return platform;
	}
	
	private Entity newMushroom(int worldX, int worldY) {
		Mushroom mushroom = new Mushroom();
	    mushroom.setPositionInWorld(worldX,worldY);
	    mushroom.setSprite(spriteFactory.getMushroom());
	    return mushroom;
	}
    
	private Entity newGreenMushroom(int worldX, int worldY) {
	    GreenMushroom greenMushroom= new GreenMushroom();
	    greenMushroom.setPositionInWorld(worldX,worldY);
	    greenMushroom.setSprite( spriteFactory.getGreenMushroom()) ;
	    return greenMushroom;                   
    }
	
	private Entity newStar(int worldX, int worldY) {
	    Star star= new Star();
	    star.setPositionInWorld(worldX,worldY);
	    star.setSprite( spriteFactory.getStar() );
	    return star;
	}
	
	private Entity newCoin(int worldX, int worldY) {
	    Coin coin= new Coin();
	    coin.setPositionInWorld(worldX,worldY);
	    coin.setSprite( spriteFactory.getCoin() );
	    return coin;
	}
	
	private Entity newFireFlower(int worldX, int worldY) {
		FireFlower flower= new FireFlower();
	    flower.setPositionInWorld(worldX,worldY);
	    flower.setSprite( spriteFactory.getFireFlower() );
	    return flower;
	}

	private Entity newKoopaTroopa(int worldX, int worldY) {
	    KoopaTroopa koopa= new KoopaTroopa();
	    koopa.setPositionInWorld(worldX,worldY);
	    koopa.setSprite( spriteFactory.getKoopaTroopa() );
	    return koopa;
	}

	private Entity newBuzzyBeetle(int worldX, int worldY) {
		BuzzyBeetle beetle= new BuzzyBeetle();
	    beetle.setPositionInWorld(worldX,worldY);
	    beetle.setSprite(spriteFactory.getBuzzyBeetle() );
	    return beetle;
	}

	private Entity newLakitu(int worldX, int worldY) {
		Lakitu lakitu= new Lakitu();
	    lakitu.setPositionInWorld(worldX,worldY);
	    lakitu.setSprite( spriteFactory.getLakitu() );
	    return lakitu;
	}

	private Entity newPiranhaPlant(int worldX, int worldY) {
		PiranhaPlant piranha= new PiranhaPlant();
	    piranha.setPositionInWorld(worldX,worldY);
	    piranha.setSprite( spriteFactory.getPiranhaPlant() );
	    return piranha;
	}

	private Entity newGoomba(int worldX, int worldY) {
		Goomba goomba= new Goomba();
	    goomba.setPositionInWorld(worldX,worldY);
	    goomba.setSprite( spriteFactory.getGoomba() );
	    return goomba;
	}
    
	private Entity newPipe(int worldX, int worldY) {
		Pipe pipe= new Pipe();
	    pipe.setPositionInWorld(worldX,worldY);
	    pipe.setSprite( spriteFactory.getPipe() );
	    return pipe;
	}
	
	private Entity newVoid(int worldX, int worldY) {
		Void v= new Void();
	    v.setPositionInWorld(worldX,worldY);
	    return v;
	}
	
	private Entity newFlag(int worldX, int worldY) {
		Flag flag= new Flag();
	    flag.setPositionInWorld(worldX,worldY);
	    flag.setSprite( spriteFactory.getFlag() );
	    return flag;
	}
	
	private Entity newQuestion(int worldX, int worldY) {
		Question question= new Question();
	    question.setPositionInWorld(worldX,worldY);
	    question.setSprite( spriteFactory.getQuestionBlock() );
	    return question;
	}
	
	private Entity newBrick(int worldX, int worldY) {
		Brick brick= new Brick();
	    brick.setPositionInWorld(worldX,worldY);
	    brick.setSprite( spriteFactory.getBrickBlock() );
	    return brick;
	}
	
	private Entity newSolid(int worldX, int worldY) {
		Solid solid= new Solid();
	    solid.setPositionInWorld(worldX,worldY);
	    solid.setSprite( spriteFactory.getSolidBlock() );
	    return solid;
	}
	
}