package factories;
public abstract class SpriteFactory {
    String folderPath; 
    
    protected SpriteFactory(String path){
        this.folderPath = path;
    }
    public Sprite getCharacterSprite(){
        return new Sprite(folderPath + "/Character.png");	 
    }
    public Sprite getBackgroundSprite(int number){
        return new Sprite(folderPath + "/Character"+number+".png");	 
    }
    //ENEMYS SPRITES
    public Sprite getGoombaSprite(){
        return new Sprite(folderPath + "/Goomba.png");	 
    }
    public Sprite getKoopaTroopaSprite(){
        return new Sprite(folderPath + "/KoopaTroopa.png");	 
    }
    public Sprite getPiranhaPlantSprite(){
        return new Sprite(folderPath + "/PiranhaPlant.png");	 
    }    
    public Sprite getLakituSprite(){
        return new Sprite(folderPath + "/Lakitu.png");	 
    }
    public Sprite getBuzzyBeetleSprite(){
        return new Sprite(folderPath + "/BuzzyBeetle.png");	 
    }
    public Sprite getSpinySprite(){
        return new Sprite(folderPath + "/Spiny.png");	 
    }
    public Sprite getShellSprite(){
        return new Sprite(folderPath + "/Shell.png");	 
    }    
    //POWERUPS SPRITES
    public Sprite getStarSprite(){
        return new Sprite(folderPath + "/Star.png");	 
    }
    public Sprite getSuperMushroomSprite(){
        return new Sprite(folderPath + "/Mushroom.png");	 
    }
    public Sprite getFireFlowerSprite(){
        return new Sprite(folderPath + "/FireFlower.png");	 
    }
    public Sprite getGreenMushroomSprite(){
        return new Sprite(folderPath + "/GreenMushroom.png");	 
    }
    public Sprite getCoinSprite(){
        return new Sprite(folderPath + "/Coin.png");	 
    }
    //PROJETILE
    public Sprite getFireballSprite(){
        return new Sprite(folderPath + "/Fireball.png");	 
    }
    public Sprite getSpinyEggSprite(){
        return new Sprite(folderPath + "/SpinyEgg.png");	 
    }
    //PLATFLORMS
    public Sprite getBrickSprite(){
        return new Sprite(folderPath + "/BrickBlock.png");	 
    }
    public Sprite getQuestionBlockSprite(){
        return new Sprite(folderPath + "/QuestionBlock.png");	 
    }
    public Sprite getBlockSprite(){
        return new Sprite(folderPath + "/SolidBlock.png");	 
    }
    public Sprite getPipeSprite(){
        return new Sprite(folderPath + "/Pipe.png");	 
    }
    public Sprite getFlagSprite(){
        return new Sprite(folderPath + "/Flag.png");	 
    }
    public Sprite getVoidSprite(){
        return new Sprite(folderPath + "/Void.png");	 
    }
}