package character;

import javax.swing.JPanel;

public class Player{

	protected String playerName;
	protected int playerScore;
	protected JPanel gamePanel;
	private Character character;
	private Keyboard playerKeyboard;
	
	public Player(String name) {
		playerName= name;
		character= new Character("assets.player.1");
		playerScore= 0;
		playerKeyboard=new Keyboard();
		connectKeyboardToPanel();
	}
	
	private void connectKeyboardToPanel() {
		gamePanel.addKeyListener(playerKeyboard);
		
	}
	
	
	
	public void setFinalScore() {
		playerScore=character.getScore();
	}
	
	public String getNamePlayer() {
		return playerName;
	}

	public Character getCharacter() {
		return character;
	}
	
}
