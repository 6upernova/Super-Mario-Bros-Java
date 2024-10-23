package HitboxDebug;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import game.BoundingBox;


public class HitboxPanel extends JLabel {
    BoundingBox hitbox;

    public HitboxPanel(BoundingBox hitbox) {
        this.hitbox = hitbox;
        this.setOpaque(false);
        this.setBounds(hitbox.x, hitbox.y,  hitbox.width, hitbox.height); 
        updateHitbox();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);  
        g.drawRect(0, 0, hitbox.width, hitbox.height);  
    }

    public void updateHitbox() {
        this.setBounds(hitbox.x, hitbox.y, hitbox.width, hitbox.height); 
        revalidate();
        repaint();
    }
}

