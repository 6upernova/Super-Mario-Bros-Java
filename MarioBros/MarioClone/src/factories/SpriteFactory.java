package factories;
import java.io.File;
import java.util.HashMap;

public abstract class SpriteFactory {
    String folderPath; 
    
    protected SpriteFactory(String path){
        this.folderPath = path;
    }
    
    public HashMap<String,Sprite> getSpriteMapEnemy(){
    	return null;
    }
    
    public Sprite getCharacterStillSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"CharacterStill"+ direction +".png");
    }
    
    public Sprite getCharacterRightSprite(int frame) {
    	return new Sprite(folderPath + File.separator+"Character"+ File.separator+"CharacterRight"+ frame + ".png");
    }
    
    public Sprite getCharacterLeftSprite(int frame) {
    	return new Sprite(folderPath + File.separator+"Character"+ File.separator+"CharacterLeft"+ frame + ".png");
    }

    public Sprite getCharacterJumpingSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"CharacterJumping" + direction + ".png");
    }
    
    public Sprite getBackgroundSprite(int number){
        return new Sprite(folderPath + File.separator+"Character"+number+".png");	 
    }
    //ENEMIES SPRITES
    public Sprite getGoombaSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"GoombaLeft.png");	 
    }
    public Sprite getKoopaTroopaSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"KoopaTroopaLeft1.png");	 
    }
    public Sprite getPiranhaPlantSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"PiranhaPlant1.png");	 
    }    
    public Sprite getLakituSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"LakituLeft.png");	 
    }
    public Sprite getBuzzyBeetleSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"BeetleLeft1.png");	 
    }
    public Sprite getSpinySprite(){
        return new Sprite(folderPath + File.separator+"SpinnyLeft1.png");	 
    }
    public Sprite getShellSprite(){
        return new Sprite(folderPath + File.separator+"Shell.png");	 
    }
    //POWERUPS SPRITES    
    public Sprite getSuperMushroomSprite(){
        return new Sprite(folderPath + File.separator+"PowerUps"+ File.separator+"SuperMushroom.png");	 
    }
    public Sprite getGreenMushroomSprite(){
        return new Sprite(folderPath + File.separator+"PowerUps"+ File.separator+"GreenMushroom.png");	 
    }
    public Sprite getFireFlowerSprite(){
        return new Sprite(folderPath + File.separator+"PowerUps"+ File.separator+"FireFlower.png");	 
    }
    public Sprite getStarSprite(){
        return new Sprite(folderPath + File.separator+"PowerUps"+ File.separator+"Star.png");	 
    }    
    public Sprite getCoinSprite(){
        return new Sprite(folderPath + File.separator+"PowerUps"+ File.separator+"Coin.png");	 
    }
    //PROJETILE
    public Sprite getFireballSprite(){
        return new Sprite(folderPath + File.separator+"PowerUps"+ File.separator+"Fireball.png");	 
    }
    public Sprite getSpinyEggSprite(){
        return new Sprite(folderPath + File.separator+"SpinyEgg.gif");	 
    }
    //PLATFLORMS
    public Sprite getBrickSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"BrickBlock.png");	 
    }
    public Sprite getQuestionBlockSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"QuestionBlock.png");	 
    }
    public Sprite getBlockSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"SolidBlock.png");	 
    }
    public Sprite getPipeSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"Pipe.png");	 
    }
    public Sprite getFlagSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"Flag.png");	 
    }
    public Sprite getVoidSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"Void.png");	 
    }
}