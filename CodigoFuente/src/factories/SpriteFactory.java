package factories;
import java.io.File;
import java.util.HashMap;

public abstract class SpriteFactory {
    String folderPath; 
    
    protected SpriteFactory(String path){
        this.folderPath = path;
        System.out.println(path);
    }
    
    public HashMap<String,Sprite> getSpriteMapEnemy(){
    	return null;
    }    
    
    public Sprite getBackgroundSprite(int number){
        return new Sprite(folderPath + File.separator+"Character"+number+".png");	 
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
    public Sprite getCharacterInFlag(){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Normal"+ File.separator + "CharacterInFlag" + ".png");
    }
    
    public Sprite getCharacterDead(){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Normal"+ File.separator + "CharacterDies" + ".png");
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
    public Sprite getSuperCharacterInFlag(){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Super"+ File.separator + "SuperCharacterInFlag" + ".png");
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
    public Sprite getFireCharacterInFlag(){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Fire"+ File.separator + "FireCharacterInFlag" + ".png");
    }
    ///////////////////////////INVENCIBLES NORMAL////////////////////////////////////
    public Sprite getCharacterInvencibleStillSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Invencible"+ File.separator + "Normal" + File.separator + "Invencible"+ direction +"Still.png");
    }
    public Sprite getCharacterInvencibleRightSprite(int frame) {
        Sprite sprite;
    	if(frame % 2 == 0)
            sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator + "Invencible"+ File.separator + "Normal"+ File.separator +"InvencibleRight"+ frame + ".png");
        else 
        	sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator + "Normal"+ File.separator +"CharacterRight"+ frame + ".png");
        return sprite;
    }
    
    public Sprite getCharacterInvencibleLeftSprite(int frame) {
        Sprite sprite;
        if(frame % 2 != 0)
            sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator +"Invencible"+ File.separator + "Normal"+ File.separator +"InvencibleLeft"+ frame + ".png");
        else 
        	sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator + "Normal"+ File.separator +"CharacterLeft"+ frame + ".png");
        return sprite;
    }

    public Sprite getCharacterInvencibleJumpingSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Normal"+ File.separator +"CharacterJumping" + direction + ".png");
    }
    ///////////////////////////INVENCIBLES SUPER////////////////////////////////////
    public Sprite getSuperCharacterInvencibleStillSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Invencible"+ File.separator +"Super" +File.separator + "Invencible"+ direction +"Still.png");
    }
    
    public Sprite getSuperCharacterInvencibleRightSprite(int frame) {
        Sprite sprite;
    	if(frame % 2 == 0)
            sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator + "Invencible"+ File.separator + "Super"+ File.separator +"InvencibleRight"+ frame + ".png");
        else 
        	sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator + "Super"+ File.separator +"SuperCharacterRight"+ frame + ".png");
        return sprite;
    }
    
    public Sprite getSuperCharacterInvencibleLeftSprite(int frame) {
        Sprite sprite;
        if(frame % 2 != 0)
            sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator +"Invencible"+ File.separator + "Super"+ File.separator +"InvencibleLeft"+ frame + ".png");
        else 
        	sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator + "Super"+ File.separator +"SuperCharacterLeft"+ frame + ".png");
        return sprite;
    }

    public Sprite getSuperCharacterInvencibleJumpingSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Super"+ File.separator +"SuperCharacterJumping" + direction + ".png");
    }

    //ENEMIES SPRITES
    public Sprite getGoombaLeftSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"GoombaLeft.png");	
    }
    public Sprite getGoombaRightSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"GoombaRight.png");	
    }
    
    public Sprite getKoopaTroopaLeftSprite(int frame){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"KoopaTroopaLeft"+ frame + ".png");	 
    }
    public Sprite getKoopaTroopaRightSprite(int frame){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"KoopaTroopaRight"+ frame + ".png");	 
    }
    public Sprite getKoopaTroopaShellSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"KoopaShell.png");	 
    }

    public Sprite getPiranhaPlantSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"PiranhaPlant1.png");	 
    }    
    
    public Sprite getLakituLeftSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"LakituLeft.png");	
    }
    public Sprite getLakituRightSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"LakituRight.png");	
    }

    public Sprite getBuzzyBeetleLeftSprite(int frame){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"BeetleLeft"+ frame + ".png");	 
    }
    public Sprite getBuzzyBeetleRightSprite(int frame){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"BeetleRight"+ frame + ".png");	 
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
        return new Sprite(folderPath + File.separator+"Projectiles"+ File.separator+"Fireball1.png");	 
    }
    public Sprite getSpinyEggSprite(){
        return new Sprite(folderPath + File.separator+"Projectiles"+ File.separator+"SpinyEgg.gif");	 
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
    public Sprite getPipeTopRightSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"PipeTopRight.png");	 
    }
    public Sprite getPipeTopLeftSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"PipeTopLeft.png");	 
    }
    public Sprite getPipeBottomRightSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"PipeBottomRight.png");	 
    }
    public Sprite getPipeBottomLeftSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"PipeBottomLeft.png");	 
    }
    public Sprite getFlagSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"Flag.png");	 
    }
    public Sprite getVoidSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"Void.png");	 
    }
    public Sprite getMastSprite() {
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"Mast.png");
    }
    public Sprite getMastEndSprite() {
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"MastEnd.png");
    }
}