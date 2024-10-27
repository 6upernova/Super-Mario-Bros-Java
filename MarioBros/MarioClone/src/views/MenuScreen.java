package views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuScreen extends JPanel{
	protected JButton exit;
	protected JButton newGame;
	protected JButton ranking;
	protected ViewController viewController;
	
	public MenuScreen(ViewController view) {
		viewController= view;
		setPreferredSize(new Dimension(ViewConstants.WIN_WIDTH,ViewConstants.WIN_HEIGHT));
        setLayout(null);
        createJButtons();
	}

	private void createJButtons() {
		configureButtons();
		addButtonListeners();
        addButtons();
	}
	
	private void configureButtons(){
		newGame= new JButton("New Game");
		ranking= new JButton("Ranking");
		exit= new JButton("Exit");
	    newGame.setBounds(150,ViewConstants.WIN_WIDTH/2 ,150, 50);
	    ranking.setBounds(350,ViewConstants.WIN_WIDTH/2 ,150, 50);
	    exit.setBounds(550,ViewConstants.WIN_WIDTH/2 ,150, 50);
	}
	private void addButtonListeners(){
		newGame.addActionListener(new NewGameButtonListener());
        //ranking.addActionListener(new RankingButtonListener());
		exit.addActionListener(new ExitButtonListener());
	}
	private void addButtons(){
        add(newGame);
        add(ranking);
        add(exit);
	}
	
	private class RankingButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//viewController.showRankingScreen();
		}
		
	}
	
	private class ExitButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			viewController.exitGame();
		}
	}

	private class NewGameButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			viewController.startGame();
		}
		
	}
}