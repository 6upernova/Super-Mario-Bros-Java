package views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import game.LogicalEntity;

public abstract class GraphicObserver extends JLabel implements Observer {
    
    private LogicalEntity observedEntity;

    GraphicObserver( LogicalEntity observedEntity){
        super();
        this.observedEntity = observedEntity;

    }

    public void update(){
        

    }

    protected void updateSprite(){
        String path = observedEntity.getSprite().getSkinPath();
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(path));
        this.setIcon(icon);
    }

    protected void updatePosSize(){
        int x = observedEntity.getX();
        int y = observedEntity.getY();
        int width = this.getIcon().getIconWidth();
        int height = this.getIcon().getIconHeight();
        this.setBounds(x, y, width, height);
    }




}
