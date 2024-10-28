package views;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;

public class RankingPanel extends JLabel {
	
    private Font customFont;
    
    public RankingPanel(Collection<String> players) {        
        changeFont();
        setIcon(new ImageIcon("src/assets/backgrounds/rankingBackground.png"));
        setLayout(new GridLayout(6, 1)); 
        addPlayers(players);
    }
    private void changeFont() {
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src"+File.separator+"assets"+File.separator+"font"+File.separator+"smbfont.ttf"));
            customFont = customFont.deriveFont(Font.BOLD, 28f);
            setFont(customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            setFont(new Font("Arial", Font.BOLD, 28));
        }
    }
    private void addPlayers(Collection<String> players){
        JLabel emptyLabel = new JLabel();
        add(emptyLabel);        
        Iterator<String> it = players.iterator();
        while(it.hasNext()){
            String player = it.next();
            JLabel playerLabel = new JLabel(player, SwingConstants.CENTER);
            playerLabel.setOpaque(false);
            playerLabel.setFont(customFont);
            playerLabel.setForeground(Color.WHITE);
            add(playerLabel);
        }
    }
    
}