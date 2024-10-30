package views;

import entities.enemies.EnemyEntity;
import tools.GraphicTools;

public class EnemyObserver extends GraphicObserver{
	
	protected LevelScreen levelScreen;
	protected EnemyEntity observedEnemy;
	
	public EnemyObserver(LevelScreen levelScreen, EnemyEntity observedEntity) {
		super(observedEntity);
		this.observedEnemy = observedEntity;
		this.levelScreen = levelScreen;
		super.update();
	}

	public void update() {
        updateSprite();
        updatePositionSize();
        updateBoundingBoxCoords();
    }

    private void updateBoundingBoxCoords(){
        int x = GraphicTools.transformX(observedEntity.getX(),this);
        int y = GraphicTools.transformY(observedEntity.getY(),this);
        observedEnemy.getBoundingBox().updateBoundingBoxCoords(x, y);
    }

}
