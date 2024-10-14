package factories;

import java.io.File;

public abstract class SpriteFactory {
    String folderPath; 
    
    protected SpriteFactory(String path){
        this.folderPath = path;
    }
    public Sprite getCharacterSprite(){
        return new Sprite(folderPath + File.separator+"Character.png");	 
    }
    public Sprite getBackgroundSprite(int number){
        return new Sprite(folderPath + File.separator+"Character"+number+".png");	 
    }
    //ENEMYS SPRITES
    public Sprite getGoombaSprite(){
        return new Sprite(folderPath + File.separator+"Goomba.gif");	 
    }
    public Sprite getKoopaTroopaSprite(){
        return new Sprite(folderPath + File.separator+"KoopaTroopa.gif");	 
    }
    public Sprite getPiranhaPlantSprite(){
        return new Sprite(folderPath + File.separator+"PiranhaPlant.gif");	 
    }    
    public Sprite getLakituSprite(){
        return new Sprite(folderPath + File.separator+"Lakitu.gif");	 
    }
    public Sprite getBuzzyBeetleSprite(){
        return new Sprite(folderPath + File.separator+"BuzzyBeetle.gif");	 
    }
    public Sprite getSpinySprite(){
        return new Sprite(folderPath + File.separator+"Spiny.gif");	 
    }
    public Sprite getShellSprite(){
        return new Sprite(folderPath + File.separator+"Shell.png");	 
    }
    //POWERUPS SPRITES    
    public Sprite getSuperMushroomSprite(){
        return new Sprite(folderPath + File.separator+"Mushroom.png");	 
    }
    public Sprite getGreenMushroomSprite(){
        return new Sprite(folderPath + File.separator+"GreenMushroom.png");	 
    }
    public Sprite getFireFlowerSprite(){
        return new Sprite(folderPath + File.separator+"FireFlower.gif");	 
    }
    public Sprite getStarSprite(){
        return new Sprite(folderPath + File.separator+"Star.gif");	 
    }    
    public Sprite getCoinSprite(){
        return new Sprite(folderPath + File.separator+"Coin.gif");	 
    }
    //PROJETILE
    public Sprite getFireballSprite(){
        return new Sprite(folderPath + File.separator+"Fireball.png");	 
    }
    public Sprite getSpinyEggSprite(){
        return new Sprite(folderPath + File.separator+"SpinyEgg.gif");	 
    }
    //PLATFLORMS
    public Sprite getBrickSprite(){
        return new Sprite(folderPath + File.separator+"BrickBlock.png");	 
    }
    public Sprite getQuestionBlockSprite(){
        return new Sprite(folderPath + File.separator+"QuestionBlock.gif");	 
    }
    public Sprite getBlockSprite(){
        return new Sprite(folderPath + File.separator+"SolidBlock.png");	 
    }
    public Sprite getPipeSprite(){
        return new Sprite(folderPath + File.separator+"Pipe.png");	 
    }
    public Sprite getFlagSprite(){
        return new Sprite(folderPath + File.separator+"Flag.png");	 
    }
    public Sprite getVoidSprite(){
        return new Sprite(folderPath + File.separator+"Void.png");	 
    }
}