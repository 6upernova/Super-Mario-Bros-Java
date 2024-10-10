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
        setPreferredSize(new Dimension(ViewConstants.WIN_WIDTH, ViewConstants.WIN_HEIGHT));
        setBackground();
    }
    public void setBackground(){
        backgroundImage = new JLabel();
        backgroundImage.setIcon(new ImageIcon(getClass().getResource("/assets/Background-test01.png")));
        backgroundImage.setLayout(null);
        
        backgroundImage.setBounds(0,0, ViewConstants.WIN_WIDTH, ViewConstants.WIN_HEIGHT);
        backgroundImage.setVisible(true);

        this.add(backgroundImage);
    }


}
