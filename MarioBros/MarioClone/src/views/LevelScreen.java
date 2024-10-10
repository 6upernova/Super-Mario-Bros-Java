package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class LevelScreen extends JPanel {
    
    protected ViewController viewController;
    protected JPanel contentPanel;
    protected JLabel backgroundImage;
    protected JScrollPane scrollPanel;


    public LevelScreen (ViewController viewController){
        this.viewController = viewController;
        setPreferredSize(new Dimension(ViewConstants.WIN_WIDTH, ViewConstants.WIN_HEIGHT));
        setLayout(new BorderLayout());
        setBackgroundAndScroll();
    }

    public void setBackgroundAndScroll() {
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/assets/backgrounds/background-lvl1.png"));
        float scale = calculateScale(backgroundIcon.getIconHeight(),ViewConstants.PANEL_HEIGHT);
        backgroundIcon = scaleImage(scale, backgroundIcon);
        backgroundImage = new JLabel();
        backgroundImage.setIcon(backgroundIcon);

        
        backgroundImage.setPreferredSize(new Dimension(backgroundImage.getIcon().getIconWidth(), backgroundImage.getIcon().getIconHeight()));
        backgroundImage.setLayout(null);
		backgroundImage.setBounds(0,0, backgroundIcon.getIconWidth(), ViewConstants.PANEL_HEIGHT);
        
        contentPanel = new JPanel(null); 
        contentPanel.setPreferredSize(new Dimension(backgroundImage.getIcon().getIconWidth(), backgroundImage.getIcon().getIconHeight()));
        contentPanel.add(backgroundImage);

       
        scrollPanel = new JScrollPane(contentPanel); 
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPanel.setBounds(0, 0, ViewConstants.PANEL_WITDH, ViewConstants.PANEL_HEIGHT);

        
        this.add(scrollPanel, BorderLayout.CENTER);
    }

    private ImageIcon scaleImage(float scale, ImageIcon imageIcon){
        Image image = imageIcon.getImage();
        int width = Math.round(imageIcon.getIconWidth() * scale);
        int height = Math.round(imageIcon.getIconHeight() * scale);
        image = image.getScaledInstance(width,  height, ABORT);
        return new ImageIcon(image);
    }

    private float calculateScale(float origin, float destination){
        return destination / origin;
    }


}
    


    

    




