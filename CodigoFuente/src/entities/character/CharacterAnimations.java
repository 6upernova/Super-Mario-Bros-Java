package entities.character;
import factories.Sprite;
public class CharacterAnimations{
    protected Character character;

    public CharacterAnimations(Character character){
        this.character = character;
    }

    public void deathAnimation() {
            character.setIsBusy(true);
            character.jump("Died");

            while (character.getY()>-5) {
                character.applyGravity();
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            character.setIsBusy(false);
            character.setInStart();
            
            
    }

    public void superAnimation(String actualState, String newState){
        
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

    }




    
}
       

    