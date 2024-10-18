package character;

import java.awt.event.KeyEvent;

public class Keyboard extends java.awt.event.KeyAdapter {

    private String playerHorizontalDirection, playerVerticalDirection;
    private String previousDirection;
    private boolean jumping;
    private boolean keyIsPressed;
    
    public Keyboard(){
        playerHorizontalDirection="None";
        playerVerticalDirection="None";
        previousDirection="Right";
        keyIsPressed = false;
    }
     
    public void keyPressed(KeyEvent pressedKey) {
    	if (pressedKey.getKeyCode() == KeyEvent.VK_W) {
                playerVerticalDirection = "Up";
        }
        if(!keyIsPressed){
            switch(pressedKey.getKeyCode()) {
                case KeyEvent.VK_D:
                    keyIsPressed = true;
                    playerHorizontalDirection="Right";
                    break;
                case KeyEvent.VK_A:
                	keyIsPressed = true;
                    playerHorizontalDirection="Left";
                    break;
            }
        }
    }

    public void keyReleased(KeyEvent releasedKey) {
        if(releasedKey.getKeyCode()==KeyEvent.VK_W) {
        	if(playerVerticalDirection.equals("Up") || playerVerticalDirection.equals("None"))
        		jumping=false;
        		playerVerticalDirection="Down";
        }
    	if(keyIsPressed){
            switch(releasedKey.getKeyCode()) {
                case KeyEvent.VK_D:
                    previousDirection = playerHorizontalDirection;
                    playerHorizontalDirection = "None";
                    keyIsPressed = false;
                    break;
                case KeyEvent.VK_A:
                    previousDirection = playerHorizontalDirection;
                    playerHorizontalDirection = "None";
                    keyIsPressed = false;
                    break;
            }
        }
    }
    
    public String getPlayerHorizontalDirection() {
        return playerHorizontalDirection;
    }

    public String getPlayerVerticalDirection() {
    	return playerVerticalDirection;
    }
    public String getPreviousDirection() {
        return previousDirection;
    }
    
}
