package entities.enemies;
import entities.character.Character;

public interface KoopaTroopaState {
    public void moveLeft(int frame);
    public void moveRight(int frame);
    public void hit(Character character);
    public void hitEnemy(Enemy enemy);
}
