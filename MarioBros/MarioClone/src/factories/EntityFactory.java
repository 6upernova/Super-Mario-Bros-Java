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
			              powerUp= newMushroom(worldX,worldY);
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
			              platform= newSolid(worldX,worldY);
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