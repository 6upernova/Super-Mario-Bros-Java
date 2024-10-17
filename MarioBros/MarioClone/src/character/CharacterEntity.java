package character;

import game.LogicalEntity;

public interface CharacterEntity extends LogicalEntity {
    public int getLives();
    public boolean isInvincible();
    public float getSpeed();
}

