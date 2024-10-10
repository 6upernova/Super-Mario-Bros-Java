package views;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelScreen extends JPanel {
    
    protected ViewController viewController;
    protected JLabel backgroundImage;


    public LevelScreen (ViewController viewController){
        this.viewController = viewController;
        setPreferredSize(new Dimension(ViewConstants.WINWIDTH, ViewConstants.WINHEIGHT));
        setBackground();
    }
    public void setBackground(){
        backgroundImage = new JLabel();
        backgroundImage.setIcon(new ImageIcon("/assets/background.png"));
        backgroundImage.setVisible(true);
        this.add(backgroundImage);
    }
}
