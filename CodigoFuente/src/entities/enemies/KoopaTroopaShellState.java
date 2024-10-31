package entities.enemies;

import factories.Sprite;
import tools.GraphicTools;
import entities.character.Character;

public class KoopaTroopaShellState implements KoopaTroopaState {
    protected KoopaTroopa koopaTroopa;
    protected long spawnTimeMillis;
    public boolean standing;

    public KoopaTroopaShellState(KoopaTroopa koopaTroopa){
        this.koopaTroopa = koopaTroopa;
        spawnTimeMillis = System.currentTimeMillis();
        standing = true;
    }

    public void moveRight(int frame) {
        if(standing)
            checkChangeState();
        else{
            float enemyX = koopaTroopa.getX();
            float horizontalSpeed = koopaTroopa.getHorizontalSpeed();
            koopaTroopa.setX(GraphicTools.round2Digits(enemyX + horizontalSpeed * 1));
            koopaTroopa.getObserver().update();
        }
	}
	
	public void moveLeft(int frame) {
        if(standing)
            checkChangeState();
        else{
            float enemyX = koopaTroopa.getX();
            float horizontalSpeed = koopaTroopa.getHorizontalSpeed();
            koopaTroopa.setX(GraphicTools.round2Digits(enemyX - horizontalSpeed * 1));
            koopaTroopa.getObserver().update();
        }
	} 

    public void hit(Character character){
        standing = false;
        String direction = koopaTroopa.getDirection() != "None" ? "None" : checkSideCollision(character);
        koopaTroopa.setDirection(direction);
    }

    private String checkSideCollision(Character character){
        String direction = character.getBoundingBox().rightCollision(koopaTroopa.getBoundingBox()) ? "Right" : "Left";
        return direction;
    }

    public void updateShell(){
        setShellSprite();
        updateSpawnTime();
        koopaTroopa.setDirection("None");
        standing = true;
    }

    private void setShellSprite(){
        Sprite shellSprite = koopaTroopa.getSpritesMap().get("Shell");
        koopaTroopa.setSprite(shellSprite);
        koopaTroopa.getObserver().update();
    }

    private void updateSpawnTime(){
        spawnTimeMillis = System.currentTimeMillis();
    }

    private void checkChangeState(){
        if(System.currentTimeMillis() - spawnTimeMillis >= 5000)
            koopaTroopa.normalMode();
    }
    
}
