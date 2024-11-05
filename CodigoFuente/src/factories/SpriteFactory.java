package factories;
import java.io.File;

public abstract class SpriteFactory {
    String folderPath; 
    
    protected SpriteFactory(String path){
        this.folderPath = path;
    }
        
    public Sprite getBackgroundSprite(int number){
        return new Sprite(folderPath + File.separator+"Character"+number+".png");	 
    }

    /*=========================================================Character Sprites=========================================================*/

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

    /*======================================================Super Character Sprites======================================================*/

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
    public Sprite getSuperCharacterDead(){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Super"+ File.separator + "SuperCharacterDies" + ".png");
    }

    /*======================================================Fire Character Sprites=======================================================*/

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
    public Sprite getFireCharacterDead(){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Fire"+ File.separator + "FireCharacterDies" + ".png");
    }

    /*================================================Invincible Normal Character Sprites================================================*/

    public Sprite getCharacterInvincibleStillSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Invincible"+ File.separator + "Normal" + File.separator + "Invincible"+ direction +"Still.png");
    }
    public Sprite getCharacterInvincibleRightSprite(int frame) {
        Sprite sprite;
    	if(frame % 2 == 0)
            sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator + "Invincible"+ File.separator + "Normal"+ File.separator +"InvincibleRight"+ frame + ".png");
        else 
        	sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator + "Normal"+ File.separator +"CharacterRight"+ frame + ".png");
        return sprite;
    }
    public Sprite getCharacterInvincibleLeftSprite(int frame) {
        Sprite sprite;
        if(frame % 2 != 0)
            sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator +"Invincible"+ File.separator + "Normal"+ File.separator +"InvincibleLeft"+ frame + ".png");
        else 
        	sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator + "Normal"+ File.separator +"CharacterLeft"+ frame + ".png");
        return sprite;
    }
    public Sprite getCharacterInvincibleJumpingSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Normal"+ File.separator +"CharacterJumping" + direction + ".png");
    }
    public Sprite getCharacterInvincibleDead(){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Normal"+ File.separator + "CharacterDies" + ".png");
    }
    
    /*==================================================Invincible Super Character Sprites=================================================*/

    public Sprite getSuperCharacterInvincibleStillSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Invincible"+ File.separator +"Super" +File.separator + "Invincible"+ direction +"Still.png");
    }
    public Sprite getSuperCharacterInvincibleRightSprite(int frame) {
        Sprite sprite;
    	if(frame % 2 == 0)
            sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator + "Invincible"+ File.separator + "Super"+ File.separator +"InvincibleRight"+ frame + ".png");
        else 
        	sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator + "Super"+ File.separator +"SuperCharacterRight"+ frame + ".png");
        return sprite;
    }
    public Sprite getSuperCharacterInvincibleLeftSprite(int frame) {
        Sprite sprite;
        if(frame % 2 != 0)
            sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator +"Invincible"+ File.separator + "Super"+ File.separator +"InvincibleLeft"+ frame + ".png");
        else 
        	sprite = new Sprite(folderPath + File.separator+"Character"+ File.separator + "Super"+ File.separator +"SuperCharacterLeft"+ frame + ".png");
        return sprite;
    }
    public Sprite getSuperCharacterInvincibleJumpingSprite(String direction){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator + "Super"+ File.separator +"SuperCharacterJumping" + direction + ".png");
    }
    public Sprite getSuperCharacterInvincibleDead(){
        return new Sprite(folderPath + File.separator+"Character"+ File.separator+"Super"+ File.separator + "SuperCharacterDies" + ".png");
    }

    /*============================================================Goomba Sprites===========================================================*/

    public Sprite getGoombaLeftSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"GoombaLeft.png");	
    }
    public Sprite getGoombaRightSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"GoombaRight.png");	
    }

    /*=========================================================Koopa Troopa Sprites========================================================*/  

    public Sprite getKoopaTroopaLeftSprite(int frame){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"KoopaTroopaLeft"+ frame + ".png");	 
    }
    public Sprite getKoopaTroopaRightSprite(int frame){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"KoopaTroopaRight"+ frame + ".png");	 
    }
    public Sprite getKoopaTroopaShellSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"KoopaShell.png");	 
    }

    /*========================================================Piranha Plant Sprites========================================================*/

    public Sprite getPiranhaPlantSprite(int frame){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"PiranhaPlant"+ frame + ".png");	 
    }  

    /*============================================================Lakitu Sprites===========================================================*/ 

    public Sprite getLakituLeftSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"LakituLeft.png");	
    }
    public Sprite getLakituRightSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"LakituRight.png");	
    }

    /*=========================================================Buzzy Beetle Sprites========================================================*/

    public Sprite getBuzzyBeetleLeftSprite(int frame){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"BeetleLeft"+ frame + ".png");	 
    }
    public Sprite getBuzzyBeetleRightSprite(int frame){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"BeetleRight"+ frame + ".png");	 
    }
    public Sprite getBuzzyBeetleShellSprite(){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"BeetleShell.png");	 
    }

    /*============================================================Spinny Sprites============================================================*/

    public Sprite getSpinyLeftSprite(int frame){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"SpinyLeft"+frame+".png");	 
    }
    
    public Sprite getSpinyRightSprite(int frame){
        return new Sprite(folderPath + File.separator+"Enemy"+ File.separator+"SpinyRight"+frame+".png");	 
    }
    
    public Sprite getSpinyEggSprite(){
        return new Sprite(folderPath + File.separator+"Projectiles"+ File.separator+"SpinyEgg.png");	 
    }

    public Sprite getShellSprite(){
        return new Sprite(folderPath + File.separator+"Shell.png");	 
    }
    
    /*==========================================================Power Ups Sprites==========================================================*/

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
    
    /*==========================================================Projectile Sprites=========================================================*/

    public Sprite getFireballSprite(int frame){
        return new Sprite(folderPath + File.separator+"Projectiles"+ File.separator+"Fireball"+frame+".png");	 
    }

    public Sprite getFireBallExplotionSprite(int frame){
        return new Sprite(folderPath+ File.separator+"Projectiles"+ File.separator+"FireballBlow"+frame+".png");
    }
    /*==========================================================Platforms Sprites==========================================================*/

    public Sprite getBrickSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"BrickBlock.png");	 
    }
    public Sprite getQuestionBlockSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"QuestionBlock.png");	 
    }
    public Sprite getBlockSprite(){
        return new Sprite(folderPath + File.separator+"Platforms"+ File.separator+"SolidBlock.png");	 
    }
    public Sprite getQuestionEmptyBlock() {
    	return new Sprite(folderPath + File.separator + "Platforms" + File.separator+"EmptyQuestionBlock.png");
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
    /*=====================================================================================================================================*/

    public String getLevelBackground(int levelNumber) {
        return folderPath + File.separator+"Backgrounds"+ File.separator+"background-lvl"+levelNumber+".png";
    }
}