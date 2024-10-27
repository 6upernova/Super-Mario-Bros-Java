package views;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class InformationPanel extends JLabel {
    protected int score;
    protected int coins;
    protected int lives; 
    protected int time;

    public InformationPanel() {
        this.score = 0;
        this.coins = 0;
        this.lives = 3;
        this.time = 400;
        configureFontAndBackground();
        updateInformation();
    }

    private void configureFontAndBackground() {setOpaque(false);               
        setOpaque(false);          
        setForeground(Color.WHITE);
        setBackground(new Color(0x6D6AFF, false)); 
        setOpaque(true);
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src"+File.separator+"assets"+File.separator+"font"+File.separator+"smbfont.ttf"));
            customFont = customFont.deriveFont(Font.BOLD, 16f); // Establecer estilo y tamaño de la fuente
            setFont(customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            setFont(new Font("Arial", Font.BOLD, 16));
        }
    }

    public void updateInformation() {
        String separator = "    ";
        setText(separator+"SCORE:"+score+separator+"TIME:"+time+separator+"COINS:"+coins+separator+"LIVES:"+lives);   
        int panelHeight = (int) (ViewConstants.PANEL_HEIGHT * 0.075);
        int panelWidth = ViewConstants.PANEL_WITDH;        
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        setBounds(0, 0, panelWidth, panelHeight);         
        revalidate();
        repaint();
    }

    public void updateScore(int score) {
        this.score = score;
    }
    public void updateCoins(int coins) {
        this.coins = coins;
    }
    public void updateLives(int lives) {
        this.lives = lives;
    }
    public void updateTime(int time){
        this.time = time;
    }
    
}
