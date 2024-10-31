package views;
import javax.swing.JLabel;
import entities.enemies.EnemyEntity;
import tools.GraphicTools;
import java.awt.Color;

public class EnemyObserver extends GraphicObserver{
	
	protected LevelScreen levelScreen;
	protected EnemyEntity observedEnemy;
	
	public EnemyObserver(LevelScreen levelScreen, EnemyEntity observedEnemy) {
		super(observedEnemy);
		this.observedEnemy = observedEnemy;
		this.levelScreen = levelScreen;
		super.update();
	}

	public void update() {
        updateSprite();
        updatePositionSize();
        updateBoundingBoxCoords();
    }

    private void updateBoundingBoxCoords(){
        int x = GraphicTools.transformX(observedEnemy.getX(),this);
        int y = GraphicTools.transformY(observedEnemy.getY(),this);
        observedEnemy.getBoundingBox().updateBoundingBoxCoords(x, y);
    }


    public void remove(){
        JLabel points = new JLabel("\u002B"+observedEnemy.getPointsOnDeath());
        int x = GraphicTools.transformX(observedEnemy.getX(),this);
        int y = GraphicTools.transformY(observedEnemy.getY(),this);
        points.setForeground(Color.WHITE);
        points.setFont(ViewConstants.font);
        points.setBounds(x, y,600, 40);
        levelScreen.drawPoints(points);
        
        
    }


}
