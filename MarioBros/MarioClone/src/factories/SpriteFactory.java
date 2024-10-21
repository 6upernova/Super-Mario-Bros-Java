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
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Normal"+ File.separator + "CharacterStill"+ direction +".png");
    }
    
    public Sprite getCharacterRightSprite(int frame) {
    	return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Normal"+ File.separator + "CharacterRight"+ frame + ".png");
    }
    
    public Sprite getCharacterLeftSprite(int frame) {
    	return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Normal"+ File.separator + "CharacterLeft"+ frame + ".png");
    }

    public Sprite getCharacterJumpingSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Normal"+ File.separator + "CharacterJumping" + direction + ".png");
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    public Sprite getSuperCharacterStillSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Super"+ File.separator + "SuperCharacterStill"+ direction +".png");
    }
    
    public Sprite getSuperCharacterRightSprite(int frame) {
    	return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Super"+ File.separator + "SuperCharacterRight"+ frame + ".png");
    }
    
    public Sprite getSuperCharacterLeftSprite(int frame) {
    	return new Sprite(folderPath + File.separator + "Character" + File.separator+"Super"+ File.separator + "SuperCharacterLeft"+ frame + ".png");
    }

    public Sprite getSuperCharacterJumpingSprite(String direction){
        return new Sprite(folderPath + File.separator + "Character" + File.separator+"Super"+ File.separator + "SuperCharacterJumping" + direction + ".png");
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    public Sprite getFireCharacterStillSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Fire"+ File.separator + "FireCharacterStill"+ direction +".png");
    }
    
    public Sprite getFireCharacterRightSprite(int frame) {
    	return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Fire"+ File.separator + "FireCharacterRight"+ frame + ".png");
    }
    
    public Sprite getFireCharacterLeftSprite(int frame) {
    	return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Fire"+ File.separator + "FireCharacterLeft"+ frame + ".png");
    }

    public Sprite getFireCharacterJumpingSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Fire"+ File.separator + "FireCharacterJumping" + direction + ".png");
    }
    public Sprite getBackgroundSprite(int number){
        return new Sprite(folderPath + File.separator+"Character"+number+".png");	 
    }
    ///////////////////////////INVENCIBLES NORMAL////////////////////////////////////
    public Sprite getCharacterInvencibleStillSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Normal"+ File.separator + "Invencible"+ File.separator + "CharacterStill"+ direction +".png");
    }
    
    public Sprite getCharacterInvencibleRightSprite(int frame) {
    	return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Normal"+ File.separator + "Invencible"+ File.separator +"CharacterRight"+ frame + ".png");
    }
    
    public Sprite getCharacterInvencibleLeftSprite(int frame) {
    	return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Normal"+ File.separator  + "Invencible"+ File.separator +"CharacterLeft"+ frame + ".png");
    }

    public Sprite getCharacterInvencibleJumpingSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Normal"+ File.separator  + "Invencible"+ File.separator +"CharacterJumping" + direction + ".png");
    }
    ///////////////////////////INVENCIBLES SUPER////////////////////////////////////
    public Sprite getSuperCharacterInvencibleStillSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Super"+ File.separator + "Invencible"+ File.separator + "SuperCharacterStill"+ direction +".png");
    }
    
    public Sprite getSuperCharacterInvencibleRightSprite(int frame) {
    	return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Super"+ File.separator + "Invencible"+ File.separator + "SuperCharacterRight"+ frame + ".png");
    }
    
    public Sprite getSuperCharacterInvencibleLeftSprite(int frame) {
    	return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Super"+ File.separator  + "Invencible"+ File.separator + "SuperCharacterLeft"+ frame + ".png");
    }

    public Sprite getSuperCharacterInvencibleJumpingSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Super"+ File.separator  + "Invencible"+ File.separator + "SuperCharacterJumping" + direction + ".png");
    }
    ///////////////////////////INVENCIBLES FUEGO////////////////////////////////////
    public Sprite getFireCharacterInvencibleStillSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Fire"+ File.separator + "Invencible"+ File.separator + "FireCharacterStill"+ direction +".png");
    }
    
    public Sprite getFireCharacterInvencibleRightSprite(int frame) {
    	return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Fire"+ File.separator + "Invencible"+ File.separator +"FireCharacterRight"+ frame + ".png");
    }
    
    public Sprite getFireCharacterInvencibleLeftSprite(int frame) {
    	return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Fire"+ File.separator  + "Invencible"+ File.separator +"FireCharacterLeft"+ frame + ".png");
    }

    public Sprite getFireCharacterInvencibleJumpingSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Fire"+ File.separator  + "Invencible"+  File.separator +"FireCharacterJumping" + direction + ".png");
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