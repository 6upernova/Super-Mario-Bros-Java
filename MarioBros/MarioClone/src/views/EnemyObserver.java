package views;

import enemies.EnemyEntity;

public class EnemyObserver extends GraphicObserver{
	
	protected LevelScreen levelScreen;
	protected EnemyEntity observedEnemy;
	
	public EnemyObserver(LevelScreen levelScreen, EnemyEntity observedEntity) {
		super(observedEntity);
		this.observedEnemy = observedEntity;
		this.levelScreen = levelScreen;
		update();
	}

	
}
