package factories;
public abstract class SpriteFactory {
    String folderPath; 
    
    protected SpriteFactory(String path){
        this.folderPath = path;
    }
    public Sprite getCharacter(){
        return new Sprite(folderPath + "/Character.png");	 
    }
    public Sprite getBackground(int number){
        return new Sprite(folderPath + "/Character"+number+".png");	 
    }
    //ENEMYS SPRITES
    public Sprite getGoomba(){
        return new Sprite(folderPath + "/Goomba.png");	 
    }
    public Sprite getKoopaTroopa(){
        return new Sprite(folderPath + "/KoopaTroopa.png");	 
    }
    public Sprite getPiranhaPlant(){
        return new Sprite(folderPath + "/PiranhaPlant.png");	 
    }    
    public Sprite getLakitu(){
        return new Sprite(folderPath + "/Lakitu.png");	 
    }
    public Sprite getBuzzyBeetle(){
        return new Sprite(folderPath + "/BuzzyBeetle.png");	 
    }
    public Sprite getSpiny(){
        return new Sprite(folderPath + "/Spiny.png");	 
    }
    public Sprite getShell(){
        return new Sprite(folderPath + "/Shell.png");	 
    }    
    //POWERUPS SPRITES
    public Sprite getStar(){
        return new Sprite(folderPath + "/Star.png");	 
    }
    public Sprite getMushroom(){
        return new Sprite(folderPath + "/Mushroom.png");	 
    }
    public Sprite getFireFlower(){
        return new Sprite(folderPath + "/FireFlower.png");	 
    }
    public Sprite getGreenMushroom(){
        return new Sprite(folderPath + "/GreenMushroom.png");	 
    }
    public Sprite getCoin(){
        return new Sprite(folderPath + "/Coin.png");	 
    }
    //PROJETILE
    public Sprite getFireball(){
        return new Sprite(folderPath + "/Fireball.png");	 
    }
    public Sprite getSpinyEgg(){
        return new Sprite(folderPath + "/SpinyEgg.png");	 
    }
    //PLATFLORMS
    public Sprite getBrickBlock(){
        return new Sprite(folderPath + "/BrickBlock.png");	 
    }
    public Sprite getQuestionBlock(){
        return new Sprite(folderPath + "/QuestionBlock.png");	 
    }
    public Sprite getSolidBlock(){
        return new Sprite(folderPath + "/SolidBlock.png");	 
    }
    public Sprite getPipe(){
        return new Sprite(folderPath + "/Pipe.png");	 
    }
    public Sprite getFlag(){
        return new Sprite(folderPath + "/Flag.png");	 
    }
    public Sprite getVoid(){
        return new Sprite(folderPath + "/Void.png");	 
    }
}