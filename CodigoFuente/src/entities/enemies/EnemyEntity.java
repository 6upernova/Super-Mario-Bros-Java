package entities.enemies;

import entities.LogicalEntity;

public interface EnemyEntity extends LogicalEntity{
	public void moveRight(int frame);
	public void moveLeft(int frame);
}
