package views;

import java.awt.Image;
import java.net.URL;

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
        icon = GraphicTools.scaleImage(icon.getIconWidth(),36, icon);
        this.setIcon(icon);
    }

    protected void updatePositionSize(){
        int x = GraphicTools.transformX(observedEntity.getX(),this);
        int y = GraphicTools.transformY(observedEntity.getY(),this);
        int width = this.getIcon().getIconWidth();
        int height = this.getIcon().getIconHeight();
        this.setBounds(x, y, width, height);
    }

    
}
