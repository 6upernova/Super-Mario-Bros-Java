package views;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JPanel;

public class RankingScreen extends JPanel {
    protected ViewController viewController;
    protected JPanel contentPanel;
    protected RankingPanel rankingPanel;
    private JButton backButton;

    public RankingScreen(ViewController viewController) {
		this.viewController= viewController;
		setPreferredSize(new Dimension(ViewConstants.WIN_WIDTH,ViewConstants.WIN_HEIGHT));
        setLayout(null);
        addBackButton();
        addRankingPanel(viewController.getPlayers());

        
    }

    private void addRankingPanel(Collection<String> players) {
        rankingPanel = new RankingPanel(players);
        this.add(rankingPanel, BorderLayout.CENTER);
    }
    
    private void addBackButton() {
        backButton = new JButton("Back to menu");        
	    backButton.setPreferredSize(new Dimension(150, 50));
        backButton.addActionListener(new BackButtonListener());
        add(backButton);
    }
    
    private class BackButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            viewController.showMenuScreen();
        }
		
	}
}
