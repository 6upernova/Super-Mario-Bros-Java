package entities.character;

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

    public void superAnimation(){
        new Thread(() -> {
            


        }).start();
    }
    
    
}
       

    