package entities.character;

import views.ViewConstants;

public class CharacterAnimations{
    protected Character character;

    public CharacterAnimations(Character character){
        this.character = character;
    }

    public void deathAnimation() {
        character.jump("Died");
        for(int i = 0; i< 8000; i++){
            character.applyGravity();
        }
        character.isDying = false;
    }


}