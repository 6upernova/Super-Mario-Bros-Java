package views;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.Iterator;
import java.awt.Color;

public class RankingPanel extends JLabel {

    public RankingPanel(Collection<String> players) {
        setIcon(new ImageIcon("src/assets/backgrounds/rankingBackground.png"));
        setLayout(new GridLayout(6, 1)); 
        addPlayers(players);
    }
    
    private void addPlayers(Collection<String> players){
        JLabel emptyLabel = new JLabel();
        add(emptyLabel);        
        Iterator<String> it = players.iterator();
        while(it.hasNext()){
            String player = "                 "+it.next();            
            JLabel playerLabel = new JLabel(player, SwingConstants.LEFT);
            playerLabel.setOpaque(false);
            playerLabel.setFont(ViewConstants.font);
            playerLabel.setForeground(Color.WHITE);
            add(playerLabel);
        }
    }
    
}