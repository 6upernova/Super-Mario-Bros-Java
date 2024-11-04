package entities;
import entities.character.Character;
import entities.platforms.Flag;
import factories.Sprite;
import views.ViewConstants;

public class Animations{
	
    public void characterDeathAnimation(Character character) {
        	character.getSoundObserver().reproduceSoundOneIteration("marioDie");
            character.setIsBusy(true);
            character.setVerticalSpeed(0);
            character.jump("Died");

            while (character.getY()>-5) {
                character.applyGravity();
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (character.getSoundObserver().isRunning()) {
                
            }
            character.getSoundObserver().loopMusicLevel();
            character.setIsBusy(false);
            character.setInStart();
            character.setIsInAir(false);
            
    }

    public void superAnimation(Character character, String actualState, String newState){
            character.setIsBusy(true);
            Sprite superRight = character.getCharacterStates().get(actualState).getSprites().get("StillRight");
            Sprite normalRight = character.getCharacterStates().get(newState).getSprites().get("StillRight");
            Sprite superLeft = character.getCharacterStates().get(actualState).getSprites().get("StillLeft");
            Sprite normalLeft = character.getCharacterStates().get(newState).getSprites().get("StillLeft");
            for(int i = 0; i<5; i++){
                try{
                	if(character.isMovingRight()) {
                		character.setSprite(normalRight);
                		character.getGraphicObserver().update();
                		Thread.sleep(100);
                		character.setSprite(superRight);
                		character.getGraphicObserver().update();
                		Thread.sleep(100);
                	}
                	else {
                		character.setSprite(normalLeft);
                		character.getGraphicObserver().update();
                		Thread.sleep(100);
                		character.setSprite(superLeft);
                		character.getGraphicObserver().update();
                		Thread.sleep(100);
                	}
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            character.setIsBusy(false);
    }

    public void characterInFlagAnimation(Character character, Flag flag){
        character.setIsBusy(true);
        while(flag.getY()>1){
            character.setY(character.getY()-1);
            flag.setY(flag.getY()-1);
            character.getGraphicObserver().update();
            flag.getGraphicObserver().update();
            try{
                Thread.sleep(ViewConstants.GAMETICK*2);                
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        character.setIsBusy(false);
    }
    

}
       

    