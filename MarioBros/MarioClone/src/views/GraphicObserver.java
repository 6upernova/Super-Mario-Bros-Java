package views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import game.LogicalEntity;

public abstract class GraphicObserver extends JLabel implements Observer {
    protected LogicalEntity observedEntity;

    GraphicObserver( LogicalEntity observedEntity){
        super();
        this.observedEntity = observedEntity;

    }

    public void update(){
        updateSprite();
        updatePositionSize();

    }

    protected void updateSprite(){
        String path = observedEntity.getSprite().getSkinPath();
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        icon = GraphicTools.scalePlatformImage(icon);
        this.setIcon(icon);
    }

    protected void updatePositionSize(){
        int x = GraphicTools.getScreenPositionX(observedEntity.getX());
        int y = GraphicTools.getScreenPositionY(observedEntity.getY());
        int width = this.getIcon().getIconWidth();
        int height = this.getIcon().getIconHeight();
        this.setBounds(x, y, width, height);
    }

}
