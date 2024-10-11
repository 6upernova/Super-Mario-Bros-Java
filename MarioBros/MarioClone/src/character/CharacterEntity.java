package character;

import game.LogicalEntity;

public interface CharacterEntity extends LogicalEntity {
    public int getLives();
    public boolean isInvencible();
    public int getSpeed();
}

