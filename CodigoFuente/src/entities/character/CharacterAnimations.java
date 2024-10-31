package entities.character;

import factories.Sprite;
import views.ViewConstants;

public class CharacterAnimations{
    protected Character character;

    public CharacterAnimations(Character character){
        this.character = character;
    }

    public void deathAnimation() {
        new Thread(() -> {
            character.setIsBusy(true);
            character.jump("Died");

            while (character.getY()>-10) {
                character.applyGravity();
                try {
                    Thread.sleep(18);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            character.setIsBusy(false);
            character.setInStart();
            
            
            
        }).start();
    }

    public void superAnimation(String actualState, String newState){
        new Thread(() -> {
            character.setIsBusy(true);
            Sprite superm = character.getCharacterStates().get(actualState).getSprites().get("StillRight");
            Sprite normal = character.getCharacterStates().get(newState).getSprites().get("StillRight");
            for(int i = 0; i<5; i++){
                try{
                    character.setSprite(normal);
                    character.getGraphicObserver().update();
                    Thread.sleep(100);
                    character.setSprite(superm);
                    character.getGraphicObserver().update();
                    Thread.sleep(100);
               
                    
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            character.setIsBusy(false);

        }).start();
    }
    
    
}
       

    