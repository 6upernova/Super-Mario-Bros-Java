package entities.enemies;
import entities.character.Character;

public interface KoopaTroopaState {
    public void move(int frame);
    public void hit(Character character);
    public void hitEnemy(Enemy enemy);
}
